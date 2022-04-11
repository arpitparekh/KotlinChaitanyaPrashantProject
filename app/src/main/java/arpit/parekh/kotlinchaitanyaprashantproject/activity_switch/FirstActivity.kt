package arpit.parekh.kotlinchaitanyaprashantproject.activity_switch

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import arpit.parekh.kotlinchaitanyaprashantproject.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val button = findViewById<Button>(R.id.btnSwitch)
        val button2 = findViewById<Button>(R.id.btnSwitchImplicit)
        val button3 = findViewById<Button>(R.id.btnCall)
        val button4 = findViewById<Button>(R.id.btnMail)
        val button5 = findViewById<Button>(R.id.btnCamera)

        title = "First Activity"

        supportActionBar?.hide()

        button.setOnClickListener {

            // Intent
            // Intent class is used to switch between activities

            // Intent take java class as its second parameter

            val intent = Intent(this,SecondActivity::class.java)

            // explicit intent

            startActivity(intent)

//            finish()  // destroys the activity

        }

        button2.setOnClickListener {

            // implicit intent

            // we use different intent actions

            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_APP_EMAIL)
            startActivity(intent)

        }

        button3.setOnClickListener {

            // Uri  // unified resource identifier

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9601397062")
            startActivity(intent)

            // assignment

            // send mail from your activity

        }

        button4.setOnClickListener {

            // TODO : Mail intent

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("mailto:arpitparekh0042@gmail.com")
//            intent.putExtra(Intent.EXTRA_SUBJECT,"Demo Subject")
//            intent.putExtra(Intent.EXTRA_TEXT,"This is text")
            startActivity(intent)

        }

        button5.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        }


    }
}