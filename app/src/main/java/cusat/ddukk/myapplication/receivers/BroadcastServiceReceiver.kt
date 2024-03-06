package cusat.ddukk.myapplication.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import cusat.ddukk.myapplication.R

class BroadcastServiceReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        //Toast.makeText(context,"Broadcast Received!",Toast.LENGTH_SHORT).show()
        val action = intent?.action

        var msg = context?.resources?.getString(R.string.airplane)

        when(action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
            Intent.ACTION_DATE_CHANGED ->
                Toast.makeText(context,"Date Changed!!",Toast.LENGTH_SHORT).show()
        }
    }
}