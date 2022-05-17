package arpit.parekh.kotlinchaitanyaprashantproject.recyclerview_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityFacultyListBinding

class FacultyListActivity : AppCompatActivity() {

    lateinit var binding : ActivityFacultyListBinding
    lateinit var list : ArrayList<Faculty>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacultyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // there 3 types of manager inside rectclerView

        // Linear
        // Grid
        // Staggered Grid

        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
//        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)

        list = ArrayList()

        val adapter = FacultyAdapter(list)  // make a whole different class

        binding.recyclerView.adapter = adapter

        binding.btnAdd.setOnClickListener {

            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            val salary = binding.edtSalary.text.toString()

            val faculty = Faculty(name,address,salary.toDouble())

            list.add(faculty)

            adapter.notifyDataSetChanged()

            reset()

        }


    }

    fun reset(){
        binding.edtName.setText("")
        binding.edtAddress.setText("")
        binding.edtSalary.setText("")
    }
}