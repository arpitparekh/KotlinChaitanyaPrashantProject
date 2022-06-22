package arpit.parekh.kotlinchaitanyaprashantproject.firebase_full

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityFirebaseFullRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class FirebaseFullRegistrationActivity : AppCompatActivity() {

    lateinit var binding : ActivityFirebaseFullRegistrationBinding
    var imageUri : Uri? = null
    lateinit var auth : FirebaseAuth
    lateinit var databaseRef : DatabaseReference
    lateinit var storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseFullRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        databaseRef = FirebaseDatabase.getInstance().getReference("userData")

        val launcher = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {

                binding.ivProfile.setImageURI(it) // put result in imageView

                imageUri = it  // path of a imageview from internal storage

            })

        binding.ivProfile.setOnClickListener {

            launcher.launch("image/*")

        }

        binding.btnSubmit.setOnClickListener {

            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            val phone = binding.edtPhone.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val repeatPassword = binding.edtRepeatPassword.text.toString()

            if(name.isNotEmpty() && address.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()
                && password.isNotEmpty() && repeatPassword.isNotEmpty() && imageUri!=null && password == repeatPassword
            ){

                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {

                    val uid = auth.currentUser?.uid

                    storageReference = FirebaseStorage.getInstance().getReference("User Image").child(uid!!)

                    storageReference.putFile(imageUri!!).addOnSuccessListener {

                        storageReference.downloadUrl.addOnSuccessListener {

                            val url = it.toString()

                            val user = User(name,address,phone, email, uid, url)

                            databaseRef.push().setValue(user).addOnSuccessListener {

                                Toast.makeText(this@FirebaseFullRegistrationActivity,"Success",Toast.LENGTH_SHORT).show()

                            }.addOnFailureListener {

                            }

                        }.addOnFailureListener {

                        }

                    }.addOnFailureListener {

                    }

                }.addOnFailureListener {

                }


            }

        }

    }
}