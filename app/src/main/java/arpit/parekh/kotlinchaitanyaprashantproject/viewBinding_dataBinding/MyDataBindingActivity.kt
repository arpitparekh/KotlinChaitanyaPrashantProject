package arpit.parekh.kotlinchaitanyaprashantproject.viewBinding_dataBinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyDataBindingBinding

class MyDataBindingActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyDataBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // view binding

        // data binding

        // databinding is used to bind any class object data into xml directly

        val t = Tops(12,9,"Sagar")

//        binding.tvName.text = t.name_faculty
//        binding.tvNoFaculty.text = t.no_of_faculty.toString()
//        binding.tvNoStudent.text = t.no_of_student.toString()

        binding.obj = t

    }
}