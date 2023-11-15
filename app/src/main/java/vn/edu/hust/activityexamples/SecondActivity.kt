package vn.edu.hust.activityexamples

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        try {
            val id = intent.getStringExtra("id")
            val name = intent.getStringExtra("name")
            val phone = intent.getStringExtra("phone")
            val email = intent.getStringExtra("email")

            findViewById<TextView>(R.id.id_text).text = id
            findViewById<TextView>(R.id.name_text).text = name
            findViewById<TextView>(R.id.phone_text).text = phone
            findViewById<TextView>(R.id.email_text).text = email

        } catch (ex: Exception) {
            setResult(Activity.RESULT_CANCELED)
        }

    }
}