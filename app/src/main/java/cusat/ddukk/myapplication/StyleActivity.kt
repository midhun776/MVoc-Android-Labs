package cusat.ddukk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StyleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_style)

        var btn = findViewById<Button>(R.id.bt_theme)

        btn.setOnClickListener {
            var i = Intent(applicationContext,ThemeActivity::class.java)
            startActivity(i)
        }
    }
}