package arpit.parekh.kotlinchaitanyaprashantproject.pass_String

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import arpit.parekh.kotlinchaitanyaprashantproject.R

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val textView = findViewById<TextView>(R.id.tvName)

        val intent = intent

        val stringData : String? = intent.getStringExtra("data")

        textView.text = stringData

    }
}