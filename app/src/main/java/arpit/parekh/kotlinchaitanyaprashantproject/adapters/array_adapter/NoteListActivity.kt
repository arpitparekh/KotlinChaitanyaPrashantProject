package arpit.parekh.kotlinchaitanyaprashantproject.adapters.array_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    lateinit var binding : ActivityNoteListBinding
    lateinit var list : ArrayList<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

        list.add(12)
        list.add(45)
        list.add(56)
        list.add(67)

//        list.add("Bring Milk")
//        list.add("Call Dad")
//        list.add("Call Home")
//        list.add("Take Veggies")

        // adapters

        // adapters to used to add large amount of data into layouts

        // ArrayAdapter
        // SimpleAdapter
        // RecyclerView Adapter

        // arrayAdapter

        val adapter = ArrayAdapter<Int>(this,R.layout.listview_item_layout,list)

        binding.listViewNotes.adapter = adapter

    }
}