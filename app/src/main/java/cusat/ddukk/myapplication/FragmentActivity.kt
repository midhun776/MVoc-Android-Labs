package cusat.ddukk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        var radioChecked: String? = null

        var bt_static = findViewById<Button>(R.id.bt_static)
        var bt_dynamic = findViewById<Button>(R.id.bt_dynamic)
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        bt_static.setOnClickListener {
            var i = Intent(applicationContext,StaticFragmentActivity::class.java)
            startActivity(i)
        }

        bt_dynamic.setOnClickListener {
            var i = Intent(applicationContext,DynamicFragmentActivity::class.java)
            if (radioChecked != null) {
                val bundle: Bundle = Bundle()
                bundle.putString("order",radioChecked)
                i.putExtra("bundle",bundle)
            }
            startActivity(i)
        }

        radioGroup.setOnCheckedChangeListener { group, checkId ->
            val radioBtn =  findViewById<RadioButton>(checkId)
            Toast.makeText(applicationContext,radioBtn.text.toString(),Toast.LENGTH_LONG).show()

            if (radioBtn.text.equals("Fragment One"))
                radioChecked = "one"
            else if (radioBtn.text.equals("Fragment Two"))
                radioChecked = "two"
            else
                radioChecked = null
        }
    }
}