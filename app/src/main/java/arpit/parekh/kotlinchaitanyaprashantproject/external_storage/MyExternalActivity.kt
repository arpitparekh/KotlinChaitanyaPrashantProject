package arpit.parekh.kotlinchaitanyaprashantproject.external_storage

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyExternalBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MyExternalActivity : AppCompatActivity() {
    lateinit var binding :ActivityMyExternalBinding
    var isGranted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyExternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWriteExternal.setOnClickListener {

            if(isGranted){

                val data = binding.edtWriteExternal.text.toString()

                val rootFolder : File = Environment.getExternalStorageDirectory()

                val subFolder : File = File(rootFolder,"kotlinFolder")

                subFolder.mkdir()

                val file = File(subFolder,"kotlin.txt")

                val fos = FileOutputStream(file)

                fos.write(data.toByteArray())

                fos.close()

            }else{
                askPermission()
            }

        }

        binding.btnReadExternal.setOnClickListener {

            if(isGranted){

                val data = binding.edtWriteExternal.text.toString()

                val rootFolder : File = Environment.getExternalStorageDirectory()

                val subFolder : File = File(rootFolder,"kotlinFolder")

                subFolder.mkdir()

                val file = File(subFolder,"kotlin.txt")

                val fis = FileInputStream(file)

                val arr = ByteArray(fis.available())

                fis.read(arr)

                val result = String(arr)

                binding.tvExternal.text = result

            }else{
                askPermission()
            }

        }
    }

    private fun askPermission(){

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE),101)

        }else{
            isGranted = true
            Toast.makeText(this,"Permission Already Granted",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                isGranted = true

                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Permission not Granted",Toast.LENGTH_SHORT).show()
            }
        }
    }

}