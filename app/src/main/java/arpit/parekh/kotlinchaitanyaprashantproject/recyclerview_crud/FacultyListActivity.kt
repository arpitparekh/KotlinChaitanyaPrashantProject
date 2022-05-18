package arpit.parekh.kotlinchaitanyaprashantproject.recyclerview_crud

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityFacultyListBinding

class FacultyListActivity : AppCompatActivity(),OnAdapterItemClickInterface{

    lateinit var binding : ActivityFacultyListBinding
    lateinit var list : ArrayList<Faculty>
    lateinit var adapter : FacultyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacultyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // there 3 types of manager inside rectclerView

        // Linear
        // Grid
        // Staggered Grid

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
//        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)

        list = ArrayList()

        adapter = FacultyAdapter(list,this)  // make a whole different class

        binding.recyclerView.adapter = adapter


//        binding.spinner.adapter = adapter

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

    override fun onClick(position: Int) {

        // click event

        val faculty = list[position]

        AlertDialog.Builder(this)
            .setTitle("Choose One")
            .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->

//
//                AlertDialog.Builder(this)
//                    .setView()

            })
            .setNegativeButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->

                AlertDialog.Builder(this)
                    .setTitle("Do u Really Want to Delete ?")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface1, i1 ->

                        list.remove(faculty)

                        adapter.notifyDataSetChanged()

                    })
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface1, i1 ->

                        dialogInterface1.dismiss()

                    }).create().show()

            }).create().show()


    }

}