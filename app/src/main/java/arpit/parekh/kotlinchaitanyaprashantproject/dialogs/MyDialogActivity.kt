package arpit.parekh.kotlinchaitanyaprashantproject.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyDialogBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.DialogLayoutBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ProgressHorizontalBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ProgressSpinnerBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MyDialogActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyDialogBinding
    lateinit var dialogBinding: DialogLayoutBinding
    lateinit var progressSpinnerBinding : ProgressSpinnerBinding
    lateinit var progressHorizontalBinding: ProgressHorizontalBinding
    lateinit var items : ArrayList<String>

    @RequiresApi(Build.VERSION_CODES.N)
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

                })
                .setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i ->

                    // positive button for single choice dialog
                })
                .create().show()


        }

        binding.btnProgress1.setOnClickListener {


            progressSpinnerBinding = ProgressSpinnerBinding.inflate(layoutInflater)

//            val pd = ProgressDialog(this)
//            pd.setTitle("Downloading")
//            pd.setMessage("Please Wait")
//            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
//            pd.show()

            val dialog = Dialog(this)


            val builder = AlertDialog.Builder(this)
            builder.setView(progressSpinnerBinding.root)
            builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()
//            dialog.dismiss()
        }

        binding.btnProgress2.setOnClickListener {

            progressHorizontalBinding = ProgressHorizontalBinding.inflate(layoutInflater)

            val builder = AlertDialog.Builder(this)
            builder.setView(progressHorizontalBinding.root)

            val dialog : AlertDialog = builder.create()

            progressHorizontalBinding.pbHorizontal.max = 100

            dialog.show()

            Thread{

                for( i in 0..100){

                    Thread.sleep(50)

                    runOnUiThread {

                        progressHorizontalBinding.pbHorizontal.progress = i
                        progressHorizontalBinding.tvProgress.text = i.toString()

                    }
                    if(i==100){

                        dialog.dismiss()
                        runOnUiThread {

                            if(dialog.isShowing){
                                dialog.dismiss()

                            }
                            Toast.makeText(this,"Download SuccessFull",Toast.LENGTH_SHORT).show()

                        }
                    }
                }

            }.start()


        }
        binding.btnTimePicker.setOnClickListener {

            val calender = Calendar.getInstance()

            val hour : Int= calender.get(Calendar.HOUR_OF_DAY)
            val minuet = calender.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this,object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {

//                    binding.btnTimePicker.text = "$p1 : $p2"

                    binding.btnTimePicker.text = convert24To12("$p1:$p2")

                }

            },hour,minuet,true)

            timePicker.show()

        }

        binding.btnDataPicker.setOnClickListener {

            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONDAY)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

                    binding.btnDataPicker.text = "$p3/${p2+1}/$p1"

                }
            },year,month,day)

            datePicker.show()
        }

        binding.btnFullScreen.setOnClickListener {

            dialogBinding = DialogLayoutBinding.inflate(layoutInflater)

            val dialog = Dialog(this,android.R.style.Theme_Light_NoTitleBar_Fullscreen)

            dialog.setContentView(dialogBinding.root)

            dialog.show()
        }

    }

    fun convert24To12(hour24 : String) : String {
        val pattern12 = SimpleDateFormat("hh:mm a")
        val pattern24 = SimpleDateFormat("HH:mm")
        // first convert 24 hours string into Date class object using pattern24
        // convert 24 date object into 12 hours string using pattern12
        val date24 : Date =  pattern24.parse(hour24)
        return  pattern12.format(date24)
    }
}