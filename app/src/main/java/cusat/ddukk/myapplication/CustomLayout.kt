package cusat.ddukk.myapplication

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast

fun Toast.showCustomToast(message: String,activity: Activity) {
    val layout = activity.layoutInflater
        .inflate(R.layout.custom_toast,activity.findViewById(R.id.custom_toast_container))

    var textView = layout.findViewById<TextView>(R.id.ctoast_tv)
    textView.text = message

    this.apply {
        setGravity(Gravity.BOTTOM,0,200)
        view=layout
        show()
    }

}