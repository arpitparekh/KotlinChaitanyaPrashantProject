package arpit.parekh.kotlinchaitanyaprashantproject.activity_result

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyResultBinding

class MyResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ActivityResultLauncher

        val launcher : ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                // we will get the result in a form of Uri (path of its internal storage)
                binding.imageView4.setImageURI(it)
            })

        val permissionLauncher : ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.RequestPermission(),
            ActivityResultCallback {

                if(it){
                    Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show()
                }

            })
        val galleryLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {

                val uri = it.data?.data

                binding.imageView5.setImageURI(uri)

            })

        binding.imageView4.setOnClickListener {

            // file explorer // and pick an image
            launcher.launch("image/*")

        }

        binding.btnPermission.setOnClickListener {

            permissionLauncher.launch(Manifest.permission.CAMERA)
        }

        binding.imageView5.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            galleryLauncher.launch(intent)
        }



    }
}