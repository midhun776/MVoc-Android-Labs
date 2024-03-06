package cusat.ddukk.myapplication.Adaptor

import android.graphics.Color
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cusat.ddukk.myapplication.R
import cusat.ddukk.myapplication.model.ItemsViewModel

class RecyclerAdapter(private val data: List<ItemsViewModel>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var parent: ViewGroup

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile: ImageView = itemView.findViewById(R.id.msg_profile)
        val name: TextView = itemView.findViewById(R.id.tv_Mname)
        val message: TextView = itemView.findViewById(R.id.tv_Mmessage)
        val tv_continue: TextView = itemView.findViewById(R.id.tv_continue)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.parent = parent
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var isExpanded: Boolean = false
        val item = data[position]

        holder.profile.setImageResource(item.image)
        holder.name.text = item.name
        holder.message.text = item.message


        if (item.message.length < 33){
            holder.tv_continue.visibility = View.INVISIBLE
        }

        holder.tv_continue.setOnClickListener {
            if (!isExpanded) {
                isExpanded = !isExpanded
                holder.message.maxLines = Int.MAX_VALUE
                var count: Int = holder.message.maxLines
                holder.tv_continue.visibility = View.INVISIBLE
                TransitionManager.beginDelayedTransition(parent!!, AutoTransition())
                holder.message.setTextColor(parent.context.resources.getColor(R.color.purple_500))
            }
        }
        holder.message.setOnClickListener {
            if (isExpanded) {
                isExpanded = !isExpanded
                TransitionManager.beginDelayedTransition(parent!!, AutoTransition()).apply {
                    holder.tv_continue.visibility = View.VISIBLE
                    holder.message.setLines(1)
                    holder.message.setTextColor(Color.BLACK)
                }
            }
        }

    }
}