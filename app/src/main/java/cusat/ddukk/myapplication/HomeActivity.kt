package cusat.ddukk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import java.nio.file.Files.delete

class HomeActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var place = findViewById<EditText>(R.id.et_place)
        var btn = findViewById<Button>(R.id.bt_menu)

        registerForContextMenu(place)

        btn.setOnLongClickListener(View.OnLongClickListener {
            showMenu(btn)
        })

        val name = intent.getStringExtra("name").toString()
        var tvName = findViewById<TextView>(R.id.tv_name)
        tvName.setText(name).toString()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.context_cut -> Toast.makeText(applicationContext,"Cutted",Toast.LENGTH_SHORT).show()
            R.id.context_copy -> Toast.makeText(applicationContext,"Copied",Toast.LENGTH_SHORT).show()
            R.id.context_paste -> Toast.makeText(applicationContext,"Pasted",Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.option_logout -> Toast.makeText(applicationContext,"Succesfully Logout",Toast.LENGTH_SHORT).show()
            R.id.option_profile -> Toast.makeText(applicationContext,"Profile page",Toast.LENGTH_SHORT).show()
            R.id.option_activity -> Toast.makeText(applicationContext,"Activity page",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMenu(v: View): Boolean {
        PopupMenu(this, v).apply {
            setOnMenuItemClickListener(this@HomeActivity)
            inflate(R.menu.popup)
            show()
        }
        return true
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.popup_png -> {
                Toast.makeText(applicationContext,"Saved as PNG!",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.popup_jpeg -> {
                Toast.makeText(applicationContext,"Saved as JPEG!",Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}