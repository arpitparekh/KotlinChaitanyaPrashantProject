package arpit.parekh.kotlinchaitanyaprashantproject.adapters

data class Vehicle(val name : String,val type : String,val average : Int){

    override fun toString(): String {
        return "Name : $name\ntype : $type\naverage : $average"
    }

}