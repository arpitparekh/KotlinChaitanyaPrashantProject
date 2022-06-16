package arpit.parekh.kotlinchaitanyaprashantproject.firebase_authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {

    lateinit var binding : ActivityForgetPasswordBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnSendEmail.setOnClickListener {

            val email = binding.edtEmail.text.toString()

            auth.sendPasswordResetEmail(email).addOnFailureListener {

                Toast.makeText(this,"Email Send Successfully",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {

                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()

            }

        }

    }
}