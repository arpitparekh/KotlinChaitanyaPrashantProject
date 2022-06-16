package arpit.parekh.kotlinchaitanyaprashantproject.firebase_authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityFirebaseLoginBinding
import com.google.firebase.auth.FirebaseAuth

class FirebaseLoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityFirebaseLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvNewUser.setOnClickListener {

            startActivity(Intent(this,FirebaseRegisterActivity::class.java))

        }

        binding.btnLogin.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {

                Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
            }

        }

        binding.tvForget.setOnClickListener {

            startActivity(Intent(this,ForgetPasswordActivity::class.java))

        }

    }
}