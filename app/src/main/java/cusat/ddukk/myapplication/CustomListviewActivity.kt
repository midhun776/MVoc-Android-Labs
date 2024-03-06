package cusat.ddukk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CustomListviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_listview)

        val images = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
        val names = arrayOf("Midhun", "Civiya", "Dony")
        val messages = arrayOf("Hello", "Nale aate", "Will call you!")


        val data: MutableList<HashMap<String, String>> = mutableListOf()

        for (i in names.indices) {
            val cur: HashMap<String, String> = HashMap()
            cur["name"] = names[i]
            cur["message"] = messages[i]
            cur["image"] = "${images[i]}"
            data.add(cur)
        }

        val from = arrayOf("image", "name", "message")
        val to = intArrayOf(R.id.lv_avatar, R.id.lv_name, R.id.lv_message)
        val customSimpleAdapter = CustomAdapter(this, data, R.layout.custom_list_item, from, to)
        val listView = findViewById<ListView>(R.id.custom_listview)

        listView.adapter = customSimpleAdapter

    }
}