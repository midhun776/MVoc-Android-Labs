package cusat.ddukk.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast

class CustomAdapter(
    private val mContext: Context,
    data: MutableList<HashMap<String, String>>,
    res: Int,
    from: Array<String>,
    to: IntArray
) : SimpleAdapter(mContext, data, res, from, to) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = super.getView(position, convertView, parent)

        val lv_image = view.findViewById<ImageView>(R.id.lv_avatar)
        val lv_name = view.findViewById<TextView>(R.id.lv_name)

        lv_image.setOnClickListener {
            Toast.makeText(
                mContext,
                "Image with title ${lv_name.text} is pressed",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}