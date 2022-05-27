package arpit.parekh.kotlinchaitanyaprashantproject.room

import android.content.Context
import androidx.room.Room

class NoteHelper {

    companion object{

        fun getDatabaseObject(context : Context) : NoteDatabase{  // method that return an object of abstract class

            val db : NoteDatabase = Room.databaseBuilder(context,
                NoteDatabase::class.java,
                "NoteDatabase")
                .allowMainThreadQueries()
                .build()

            return db

            // coroutines

        }

    }

}