package cusat.ddukk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        var btProgress = findViewById<Button>(R.id.bt_progressBar)
        var bt_custom = findViewById<Button>(R.id.bt_customToastDialog)
        var bt_fragment = findViewById<Button>(R.id.bt_fragment)
        var bt_adapters = findViewById<Button>(R.id.bt_adapters)
        var bt_recycler = findViewById<Button>(R.id.bt_recycler)
        var bt_intents = findViewById<Button>(R.id.bt_intents)
        var bt_notification = findViewById<Button>(R.id.bt_notifications)

        btProgress.setOnClickListener {
            var i = Intent(applicationContext,ProgressActivity::class.java)
            startActivity(i)
        }

        bt_custom.setOnClickListener {
            var i = Intent(applicationContext,CustomActivity::class.java)
            startActivity(i)
        }
        bt_fragment.setOnClickListener {
            var i = Intent(applicationContext,FragmentActivity::class.java)
            startActivity(i)
        }

        bt_adapters.setOnClickListener {
            var i = Intent(applicationContext,AdaptersActivity::class.java)
            startActivity(i)
        }

        bt_recycler.setOnClickListener {
            var i = Intent(applicationContext,RecyclerActivity::class.java)
            startActivity(i)
        }
        bt_intents.setOnClickListener {
            var i = Intent(applicationContext,IntentActivity::class.java)
            startActivity(i)
        }
        bt_notification.setOnClickListener {
            var i = Intent(applicationContext,NotificationActivity::class.java)
            startActivity(i)
        }

    }
}