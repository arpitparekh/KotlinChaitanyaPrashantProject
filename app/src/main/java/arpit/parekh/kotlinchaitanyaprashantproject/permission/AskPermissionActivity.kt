package arpit.parekh.kotlinchaitanyaprashantproject.permission

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityAskPermissionBinding
import java.util.jar.Manifest

class AskPermissionActivity : AppCompatActivity() {
    lateinit var binding : ActivityAskPermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAskPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // internal storage

        // external storage  // img // pdf // room database back inside a external

        // we need permission for that

        binding.btnCamera.setOnClickListener {

            if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),12)
            }else{
                Toast.makeText(this,"Permission is Already Granted",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==12){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show()
            }
        }
    }
}