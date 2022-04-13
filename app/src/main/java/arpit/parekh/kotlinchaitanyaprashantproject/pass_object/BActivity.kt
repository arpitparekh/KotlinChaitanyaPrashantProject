package arpit.parekh.kotlinchaitanyaprashantproject.pass_object

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import arpit.parekh.kotlinchaitanyaprashantproject.R

class BActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bactivity)

        val textView = findViewById<TextView>(R.id.tvObject)

        val i = intent

        val student : Student = i.getSerializableExtra("object") as Student

        // is /  as  is used to cast object

        textView.text = student.toString()




    }
}