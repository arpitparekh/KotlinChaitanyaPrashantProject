package arpit.parekh.kotlinchaitanyaprashantproject.internal_storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityInternalStorageBinding
import java.io.FileInputStream
import java.io.FileOutputStream

class InternalStorageActivity : AppCompatActivity() {

    lateinit var binding : ActivityInternalStorageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStore.setOnClickListener {

            val str = binding.edtInternal.text.toString()

            val fis : FileOutputStream = openFileOutput("chaitanyaClass.txt", MODE_PRIVATE)

            fis.write(str.toByteArray())

            fis.close()

            Toast.makeText(this,"File Write Successfully",Toast.LENGTH_SHORT).show()

        }

        binding.btnFetch.setOnClickListener {

            val fis : FileInputStream = openFileInput("chaitanyaClass.txt")

            val arr = ByteArray(fis.available())

            fis.read(arr)

            val str = String(arr)

            binding.tvInternal.text = str

        }

    }
}