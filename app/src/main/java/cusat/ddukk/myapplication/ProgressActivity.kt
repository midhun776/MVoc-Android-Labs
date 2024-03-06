package cusat.ddukk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class ProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        var tv_horizontal = findViewById<TextView>(R.id.tv_horizontal)
        var hProgess = findViewById<ProgressBar>(R.id.horizontalProgressBar)
        var btnHorizontal = findViewById<Button>(R.id.bt_horizontal)
        var btStart = findViewById<Button>(R.id.bt_start)

        var cProgess = findViewById<ProgressBar>(R.id.circularProgressBar)
        cProgess.visibility = View.INVISIBLE
        var btnCircular = findViewById<Button>(R.id.bt_circular)

        tv_horizontal!!.text = "0/" + hProgess.max
        var i = 0

        btnHorizontal.setOnClickListener {
            i+=10
            if (i>=100) {
                i = 0
            }

            hProgess.progress = i
            tv_horizontal!!.text = i.toString() + "/" + hProgess.max

        }



        btStart.setOnClickListener {
            hProgess.visibility = View.VISIBLE
            i = hProgess.progress

            Thread(Runnable {
                if (i>=100) {
                    i=0
                }
                while (i<100) {
                    i += 10

                    runOnUiThread(Runnable {
                        hProgess.progress = i
                        tv_horizontal!!.text = i.toString() + "/" + hProgess.max
                    })
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }).start()
        }

        btnCircular.setOnClickListener {
            cProgess.visibility = View.VISIBLE
            i = hProgess.progress

            Thread(Runnable {
                if (i>=100) {
                    i=0
                }
                while (i<100) {
                    i += 1

                    runOnUiThread(Runnable {
                        hProgess.progress = i
                        tv_horizontal!!.text = i.toString() + "/" + hProgess.max
                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                cProgess.visibility = View.INVISIBLE
            }).start()
        }

    }
}