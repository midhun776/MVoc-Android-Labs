package cusat.ddukk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class IntentDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_demo)

        var bt_send = findViewById<Button>(R.id.bt_sendsms)
        var bt_broadcastPage = findViewById<Button>(R.id.bt_broadcastPage)
        var tv_msg = findViewById<EditText>(R.id.tv_sendmsg)

        bt_send.setOnClickListener {
            val msg = tv_msg.text

            val sendIntent = Intent(Intent.ACTION_SEND)
                .apply {
                    putExtra(Intent.EXTRA_TEXT,msg.toString())
                    type="text/plain"
                }

            val chooser: Intent = Intent.createChooser(sendIntent,"Choose an App!")
            if (sendIntent.resolveActivity(packageManager)!=null) {
                startActivity(chooser)
            }
        }

        bt_broadcastPage.setOnClickListener {
            var i = Intent(this,IntentActivity::class.java)
            startActivity(i)
        }

    }
}