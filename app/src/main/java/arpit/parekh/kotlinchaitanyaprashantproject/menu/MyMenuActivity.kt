package arpit.parekh.kotlinchaitanyaprashantproject.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyMenuBinding

class MyMenuActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // there are three types of menu

        // option menu  // menu inside actionbar

        // context menu // long press child

        // popup menu // single click on child
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        if(item.itemId==R.id.action_item1){

//        }else if(item.itemId==R.id.action_item2){
//
//        }else if(item.itemId==R.id.action_item3){
//
//        }else if(item.itemId==R.id.action_item4){
//
//        }
        when(item.itemId){

            R.id.action_item1->Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show()
            R.id.action_item2->Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show()
            R.id.action_item3->Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show()
            R.id.action_item4->Toast.makeText(this,"item4",Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }


}