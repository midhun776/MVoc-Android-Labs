package cusat.ddukk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_home)

        var login = findViewById<Button>(R.id.bt_Login)
        var register = findViewById<Button>(R.id.bt_Register)
        var uname = findViewById<EditText>(R.id.etuname)

        register.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"Register Here!",Toast.LENGTH_SHORT).show()
            var i = Intent(applicationContext,RegistrationActivity::class.java)
            startActivity(i)
        })

        login.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"Welcome "+uname.text.toString(),Toast.LENGTH_SHORT).show()
            var i = Intent(applicationContext,HomeActivity::class.java)
            i.putExtra("name",uname.text.toString())
            startActivity(i)
        })

    }
}