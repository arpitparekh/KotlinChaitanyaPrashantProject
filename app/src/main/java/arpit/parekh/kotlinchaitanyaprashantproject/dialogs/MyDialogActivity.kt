package arpit.parekh.kotlinchaitanyaprashantproject.dialogs

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyDialogBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.DialogLayoutBinding
import com.google.android.material.snackbar.Snackbar

class MyDialogActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyDialogBinding
    lateinit var dialogBinding: DialogLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAlert.setOnClickListener {

            // alert dialog

            val builder : AlertDialog.Builder = AlertDialog.Builder(this)

            builder.setTitle("This is title")

            builder.setMessage("This is message")

            builder.setCancelable(false)

            builder.setIcon(R.drawable.ic_smile)

            builder.setPositiveButton("Toast", DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this,"This is Positive button click",Toast.LENGTH_SHORT).show()

            })

            builder.setNegativeButton("SnackBar", DialogInterface.OnClickListener { dialogInterface, i ->

                Snackbar.make(binding.root,"This is Negative button click",Snackbar.LENGTH_SHORT).show()

            })

            builder.setNeutralButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

                dialogInterface.dismiss()

            })

            builder.show()

        }

        binding.btnAlertCustom.setOnClickListener {

            dialogBinding = DialogLayoutBinding.inflate(layoutInflater)

            val builder = AlertDialog.Builder(this)

            builder.setView(dialogBinding.root)

            builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->

                val data = dialogBinding.edtSomething.text.toString()
                binding.tvSomething.text = data
            })
            builder.show()

        }

    }
}