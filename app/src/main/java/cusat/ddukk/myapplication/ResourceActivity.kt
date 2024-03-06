package cusat.ddukk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        var img1 = findViewById<ImageView>(R.id.imgView1)
        var img2 = findViewById<ImageView>(R.id.imgView2)
        var btChange = findViewById<Button>(R.id.btChange)

        val myDrawable = resources.getDrawable(R.drawable.img3)

        btChange.setOnClickListener {
            img1.setImageDrawable(myDrawable)
        }

        img2.setImageResource(R.drawable.img2)


    }
}