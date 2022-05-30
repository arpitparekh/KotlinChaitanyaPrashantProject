package arpit.parekh.kotlinchaitanyaprashantproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    @ColumnInfo(name="title")
    var title : String,

    @ColumnInfo(name = "des")
    var des : String,

    @PrimaryKey(autoGenerate = true)
    val key : Int=0){

    override fun toString(): String {
        return "title : $title\ndes : $des"
    }

}