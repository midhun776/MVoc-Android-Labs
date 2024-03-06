package cusat.ddukk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DynamicFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment)

        var btn_one = findViewById<Button>(R.id.btn_one)
        var btn_two = findViewById<Button>(R.id.btn_two)

        var i = getIntent()
        var bundle = i.getBundleExtra("bundle")
        var frgag = bundle?.getString("order")

        var fragmentManager = supportFragmentManager

        if (frgag != null) {
            if (frgag == "one") {
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.fragmentContainer, FragmentOne())
                fragmentTransaction.commit()
            } else if (frgag == "two"){
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.fragmentContainer, FragmentTwo())
                fragmentTransaction.commit()
            }
        }

        btn_one.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, FragmentOne())
            fragmentTransaction.commit()
        }

        btn_two.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, FragmentTwo())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}