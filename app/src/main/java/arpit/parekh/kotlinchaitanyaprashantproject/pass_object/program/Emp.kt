package arpit.parekh.kotlinchaitanyaprashantproject.pass_object.program

import java.io.Serializable

data class Emp(var name:String,
               val address:String,
               val gender:String,
               val salary : Int)   : Serializable