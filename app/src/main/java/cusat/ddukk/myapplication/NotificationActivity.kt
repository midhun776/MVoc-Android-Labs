package cusat.ddukk.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class NotificationActivity : AppCompatActivity() {

    private lateinit var builder: Notification.Builder
    private lateinit var notificationChannel: NotificationChannel

    private var channelId = "i.ddukk.notification"
    private var description = "DDUKK Notification"
    private lateinit var notificationManager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        var bt_notify = findViewById<Button>(R.id.bt_notifySend)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        bt_notify.setOnClickListener {

            Toast.makeText(applicationContext,"Test",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,RecyclerActivity::class.java)
            val pendingIntent = PendingIntent.getActivities(this,0, arrayOf(intent) ,PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this,channelId).apply {
                    setSmallIcon(R.drawable.baseline_5g_24)
                    setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.img1))
                    setContentIntent(pendingIntent)
                    setShowWhen(true)
                    setContentTitle("Notification Intent")
                    setContentText("Click here to go to RecyclerActivity!")
                }
            } else {
                builder = Notification.Builder(this).apply {
                    setSmallIcon(R.drawable.baseline_5g_24)
                    setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.img1))
                    setContentIntent(pendingIntent)
                    setContentTitle("Notification Intent")
                    setContentText("Click here to go to RecyclerActivity!")
                }
            }

            notificationManager.notify(12345,builder.build())
        }
    }
}