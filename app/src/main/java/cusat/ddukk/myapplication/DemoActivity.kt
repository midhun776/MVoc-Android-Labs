package cusat.ddukk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast

class DemoActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        var etext = findViewById<EditText>(R.id.et_demoname)
        var btn = findViewById<Button>(R.id.button3)

        registerForContextMenu(etext)

        btn.setOnLongClickListener(View.OnLongClickListener {
            showPopUpMenu(btn)
        })
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.contexti,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.opi_copy -> {
                Toast.makeText(applicationContext,"Copied",Toast.LENGTH_SHORT).show()
            }
            R.id.opi_cut -> {
                Toast.makeText(applicationContext,"Cutted",Toast.LENGTH_SHORT).show()
            }
            R.id.opi_paste -> {
                Toast.makeText(applicationContext,"Pasted",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }

    fun showPopUpMenu(v: View): Boolean {
        PopupMenu(this,v).apply {
            setOnMenuItemClickListener(this@DemoActivity)
            inflate(R.menu.pop)
            show()
        }
        return true
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.poppng -> {
                Toast.makeText(applicationContext,"Saved as PNG",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.popjpeg -> {
                Toast.makeText(applicationContext,"Saved as JPEG",Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}