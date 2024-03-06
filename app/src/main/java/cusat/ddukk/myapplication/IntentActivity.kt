package cusat.ddukk.myapplication

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import cusat.ddukk.myapplication.receivers.BroadcastServiceReceiver

class IntentActivity : AppCompatActivity() {

    lateinit var receiver: BroadcastServiceReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        var bt_activate = findViewById<Button>(R.id.bt_activate)
        var bt_deactivate = findViewById<Button>(R.id.bt_deactivate)
        var bt_intent = findViewById<Button>(R.id.bt_iactivity)
        var img_change = findViewById<ImageView>(R.id.img_change)

        var tv_txt = findViewById<TextView>(R.id.tv_demoText)

        val action = intent?.action

        var msg = ""

        when(action) {
            Intent.ACTION_SEND -> {
                msg = intent?.getStringExtra(Intent.EXTRA_TEXT).toString()
                Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
            }
        }

        if (msg!="") {
            var message = tv_txt.text.toString() + " = " + msg
            tv_txt.text = message
        }

        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filter.addAction(Intent.ACTION_DATE_CHANGED)

        receiver = BroadcastServiceReceiver()

        bt_activate.setOnClickListener {
            registerReceiver(receiver, filter)
        }

        bt_deactivate.setOnClickListener {
            unregisterReceiver(receiver)
        }
        bt_intent.setOnClickListener {
            var i = Intent(this,IntentDemoActivity::class.java)
            startActivity(i)
        }

    }

//    override fun onStop() {
//        super.onStop()
//        unregisterReceiver(receiver)
//    }
}