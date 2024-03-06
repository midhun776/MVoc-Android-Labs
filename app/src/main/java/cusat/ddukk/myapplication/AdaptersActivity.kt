package cusat.ddukk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AdaptersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapters)

        var btn_simple = findViewById<Button>(R.id.bt_simpleAdapter)
        var btn_custom = findViewById<Button>(R.id.bt_customAdapter)
        var btn_recycler = findViewById<Button>(R.id.bt_recyclerView)

        btn_simple.setOnClickListener {
            var i = Intent(applicationContext,SampleListviewActivity::class.java)
            startActivity(i)
        }

        btn_custom.setOnClickListener {
            var i = Intent(applicationContext,CustomListviewActivity::class.java)
            startActivity(i)
        }

        btn_recycler.setOnClickListener {
            var i = Intent(applicationContext,SampleListviewActivity::class.java)
            startActivity(i)
        }

    }
}