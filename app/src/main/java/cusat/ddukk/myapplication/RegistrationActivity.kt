package cusat.ddukk.myapplication

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        var back = findViewById<ImageButton>(R.id.ibt_back)
        var register = findViewById<Button>(R.id.et_register)
        var dob = findViewById<TextView>(R.id.editTextDate)

        back.setOnClickListener(View.OnClickListener {
            finish()
        })

        register.setOnClickListener(View.OnClickListener {

            val dialog= MaterialAlertDialogBuilder(this)
            dialog.setTitle("Confirm Registration!")
            dialog.setMessage("Are you sure for registration?").setIcon(R.drawable.baseline_exit_to_app_24)
            dialog.setPositiveButton("Ok") { dialog, which ->
                var i = Intent(applicationContext,DemoActivity::class.java)
                startActivity(i)
            }
            dialog.show()
        })

        dob.setOnClickListener {

            val cal = Calendar.getInstance()

            val day = cal.get(Calendar.DAY_OF_MONTH)
            val month = cal.get(Calendar.MONTH)
            val year = cal.get(Calendar.YEAR)

            val datePickerDialog = DatePickerDialog(this,{
                view, year, monthOfYear, dayOfMonth ->
                dob.setText((dayOfMonth).toString()+"-"+(monthOfYear+1)+"-"+year)},
                year,month,day)
            datePickerDialog.show()
            }
        }
    }
