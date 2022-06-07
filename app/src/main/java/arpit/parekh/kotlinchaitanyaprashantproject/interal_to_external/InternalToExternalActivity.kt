package arpit.parekh.kotlinchaitanyaprashantproject.interal_to_external

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.annotation.RequiresApi
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityInternalToExternalBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class InternalToExternalActivity : AppCompatActivity() {
    lateinit var binding : ActivityInternalToExternalBinding
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalToExternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTansfer.setOnClickListener {

            val filePath : String = Environment.getDataDirectory().path+"/data/"+packageName+"/"+"databases"+"/"+"NoteDatabase"

            Log.i("path",filePath)

            val fis = FileInputStream(filePath)

            val arr = ByteArray(fis.available())

            fis.read(arr)

            fis.close()


            val rootFolder = Environment.getExternalStorageDirectory();

            val file = File(rootFolder,"NoteDatabase")

            val fos = FileOutputStream(file)

            fos.write(arr)

            fos.close()


        }

    }
}