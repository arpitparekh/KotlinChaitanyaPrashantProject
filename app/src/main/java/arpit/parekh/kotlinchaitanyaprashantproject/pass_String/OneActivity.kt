package arpit.parekh.kotlinchaitanyaprashantproject.pass_String

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import arpit.parekh.kotlinchaitanyaprashantproject.R

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        val editText = findViewById<EditText>(R.id.edtName)

        val button = findViewById<Button>(R.id.btnSend)

        button.setOnClickListener {

            val str = editText.text.toString()

            val intent = Intent(this,TwoActivity::class.java)
            intent.putExtra("data",str)
            startActivity(intent)

        }

    }
}