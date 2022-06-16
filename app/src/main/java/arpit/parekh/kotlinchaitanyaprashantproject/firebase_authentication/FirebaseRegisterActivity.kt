package arpit.parekh.kotlinchaitanyaprashantproject.firebase_authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityFirebaseRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class FirebaseRegisterActivity : AppCompatActivity() {

    lateinit var binding : ActivityFirebaseRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {

                Toast.makeText(this,"Register Successfully",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,FirebaseLoginActivity::class.java))

            }.addOnFailureListener {
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
            }

        }

    }
}