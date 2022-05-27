package arpit.parekh.kotlinchaitanyaprashantproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    @ColumnInfo(name="title")
    val title : String,

    @ColumnInfo(name = "des")
    val des : String,

    @PrimaryKey(autoGenerate = true)
    val key : Int=0)