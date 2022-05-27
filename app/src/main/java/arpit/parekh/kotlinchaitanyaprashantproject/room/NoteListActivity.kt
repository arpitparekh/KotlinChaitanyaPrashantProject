package arpit.parekh.kotlinchaitanyaprashantproject.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityNoteList2Binding

class NoteListActivity : AppCompatActivity() {
    lateinit var binding : ActivityNoteList2Binding
    lateinit var dao : NoteDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteList2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        dao  =  NoteHelper.getDatabaseObject(this).getDao()

        binding.btnAdd.setOnClickListener {

            val title = binding.edtTitle.text.toString()
            val description = binding.edtDes.text.toString()

            val note = Note(title,description)

            dao.insertNote(note)

            Toast.makeText(this,"Note Added SuccessFully",Toast.LENGTH_SHORT).show()

        }



    }
}