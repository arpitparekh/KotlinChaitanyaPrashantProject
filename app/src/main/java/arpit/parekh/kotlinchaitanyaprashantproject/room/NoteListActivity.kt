package arpit.parekh.kotlinchaitanyaprashantproject.room

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityNoteList2Binding

class NoteListActivity : AppCompatActivity(),OnNoteClickInterface {
    lateinit var binding : ActivityNoteList2Binding
    lateinit var dao : NoteDao
    lateinit var list : List<Note>
//    lateinit var adapter : ArrayAdapter<Note>
    lateinit var adapter: NoteAdapter
    var bool : Boolean = false
    var noteClick : Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteList2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewNotes.layoutManager = GridLayoutManager(this,2)

        list = ArrayList()

        dao  =  NoteHelper.getDatabaseObject(this).getDao()

        refresh()


        binding.btnAdd.setOnClickListener {

            val title = binding.edtTitle.text.toString()
            val description = binding.edtDes.text.toString()

            if(bool){


                noteClick?.title = title
                noteClick?.des = description

                dao.updateNote(noteClick!!)


            }else{

                val note = Note(title,description)

                dao.insertNote(note)

                Toast.makeText(this,"Note Added SuccessFully",Toast.LENGTH_SHORT).show()

            }

            refresh()

            clear()

            binding.btnAdd.text = "Add"
            bool = false

        }

//        binding.listViewNotes.setOnItemClickListener { adapterView, view, pos, l ->
//
//            val note = list[pos]
//
//            AlertDialog.Builder(this)
//                .setTitle("Choose One")
//                .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->
//
//                    binding.edtTitle.setText(note.title)
//                    binding.edtDes.setText(note.des)
//
//                    binding.btnAdd.text = "Update"
//
//                    bool = true
//
//                    noteClick = note
//
//                }).setNegativeButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
//
//                    dao.deleteNote(note)
//
//                    refresh()
//
//                }).create().show()
//
//        }
    }

    private fun refresh() {

        list =  dao.showNotes()

//        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)

        adapter = NoteAdapter(list,this)

        binding.recyclerViewNotes.adapter = adapter

    }

    private fun clear(){

        binding.edtTitle.setText("")
        binding.edtDes.setText("")

    }

    override fun onNoteClick(pos: Int) {
        val note = list[pos]

            AlertDialog.Builder(this)
                .setTitle("Choose One")
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->

                    binding.edtTitle.setText(note.title)
                    binding.edtDes.setText(note.des)

                    binding.btnAdd.text = "Update"

                    bool = true

                    noteClick = note

                }).setNegativeButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->

                    dao.deleteNote(note)

                    refresh()

                }).create().show()
    }
}