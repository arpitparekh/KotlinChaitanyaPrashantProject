package arpit.parekh.kotlinchaitanyaprashantproject.dialogs

import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyDialogBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.DialogLayoutBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ProgressSpinnerBinding
import com.google.android.material.snackbar.Snackbar

class MyDialogActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyDialogBinding
    lateinit var dialogBinding: DialogLayoutBinding
    lateinit var progressSpinnerBinding : ProgressSpinnerBinding
    lateinit var items : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)

        items = ArrayList()

        val hobbies = arrayOf("Cycling","gym","coding","reading")
        val checks = booleanArrayOf(false,true,true,false)

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

        binding.btnMultiChoice.setOnClickListener {

            items.clear()

            items.add(hobbies[1])
            items.add(hobbies[2])

            val builder = AlertDialog.Builder(this)

            builder.setTitle("Choose Hobbies")

            builder.setMultiChoiceItems(hobbies,booleanArrayOf(false,true,true,false), DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

                if(b){
                    items.add(hobbies[i])
                }else{
                    items.remove(hobbies[i])
                }
            })

            builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this,items.toString(),Toast.LENGTH_SHORT).show()

            })

            builder.show()


        }

        binding.btinSingleChoiceDialog.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Choose One")
                .setSingleChoiceItems(hobbies,2, DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,hobbies[i],Toast.LENGTH_SHORT).show()

                }).create().show()


        }

        binding.btnProgress1.setOnClickListener {


            progressSpinnerBinding = ProgressSpinnerBinding.inflate(layoutInflater)

//            val pd = ProgressDialog(this)
//            pd.setTitle("Downloading")
//            pd.setMessage("Please Wait")
//            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
//            pd.show()

            val dialog = Dialog(this)
            dialog.setContentView(progressSpinnerBinding.root)
            dialog.show()

//            dialog.dismiss()


        }

    }
}