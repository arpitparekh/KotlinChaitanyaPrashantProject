package arpit.parekh.kotlinchaitanyaprashantproject.pass_object

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import arpit.parekh.kotlinchaitanyaprashantproject.R

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aactivity)

        val button = findViewById<Button>(R.id.btnPassObject)

        button.setOnClickListener {

            val student = Student("Chaitnya","MP")

            val intent = Intent(this,BActivity::class.java)
            intent.putExtra("object",student)
            startActivity(intent)
        }

    }
}