package arpit.parekh.kotlinchaitanyaprashantproject.room

import androidx.room.*

@Dao
interface NoteDao {

    // DAO  // data access objects

    // in my sql each and every row is define as data access object

    // insert .. update .. delete .. show

    // select * from Note

    // MYSQLDATAHELPER

    @Insert
    fun insertNote(note : Note)

    @Update
    fun updateNote(note : Note)

    @Delete
    fun deleteNote(note : Note)

    @Query("select * from Note")
    fun showNotes() : List<Note>

    @Query("select * from Note where `key`=:key")
    fun getPerticularNote(key : Int) : Note

    @Query("delete from note where `key`=:key")
    fun deleteOther(key : Int)

    @Query("update note set title=:title,des=:des where `key`=:key")
    fun updateOther(title :String,des : String,key : Int)



}