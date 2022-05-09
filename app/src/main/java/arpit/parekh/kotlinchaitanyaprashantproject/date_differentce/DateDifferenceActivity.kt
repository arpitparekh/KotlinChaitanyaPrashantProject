package arpit.parekh.kotlinchaitanyaprashantproject.date_differentce

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityDateDifferenceBinding
import java.text.SimpleDateFormat
import java.util.*

class DateDifferenceActivity : AppCompatActivity() {

    lateinit var binding : ActivityDateDifferenceBinding
    var startDate : String = ""
    var endDate : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateDifferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dateOne.setOnClickListener {

            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val  day= calender.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

                    startDate = "$p3/${p2+1}/$p1"

                    binding.dateOne.text = startDate

                }
            },year,month,day)

            datePicker.show()

        }

        binding.dateTwo.setOnClickListener {

            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val  day= calender.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

                    endDate = "$p3/${p2+1}/$p1"

                    binding.dateTwo.text = endDate

                }
            },year,month,day)

            datePicker.show()


        }

        binding.btnDiff.setOnClickListener {

            "hour:min"

            val datePattern = SimpleDateFormat("dd/M/yyyy")

            val startDateObject : Date = datePattern.parse(startDate)
            val endDateObject : Date = datePattern.parse(endDate)

            if(startDateObject!=null && endDateObject!=null){

                var diffrence : Long = endDateObject.time - startDateObject.time

                diffrence = diffrence / (1000 * 60 * 60 * 24)

                diffrence = Math.abs(diffrence)

                binding.tvDiff.text = diffrence.toString()


            }



        }

    }
}