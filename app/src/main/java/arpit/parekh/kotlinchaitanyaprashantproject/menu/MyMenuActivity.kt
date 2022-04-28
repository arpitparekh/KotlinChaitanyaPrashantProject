package arpit.parekh.kotlinchaitanyaprashantproject.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyMenuBinding
import com.google.android.material.snackbar.Snackbar

class MyMenuActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.btnContext)
//        registerForContextMenu()

        // there are three types of menu

        // option menu  // menu inside actionbar

        // context menu // long press child

        // popup menu // single click on child

        binding.btnPopUp.setOnClickListener {

            val pop = PopupMenu(this,binding.btnPopUp) // 2 parameter is anchor

            pop.menuInflater.inflate(R.menu.my_menu,pop.menu)

            pop.setOnMenuItemClickListener {

                when(it.itemId){

                    R.id.action_item1->Snackbar.make(binding.root,"item1",Snackbar.LENGTH_SHORT).show()
                    R.id.action_item2->Snackbar.make(binding.root,"item2",Snackbar.LENGTH_SHORT).show()
                    R.id.action_item3->Snackbar.make(binding.root,"item3",Snackbar.LENGTH_SHORT).show()
                    R.id.action_item4->Snackbar.make(binding.root,"item4",Snackbar.LENGTH_SHORT).show()
                    R.id.action_item5->Snackbar.make(binding.root,"item5",Snackbar.LENGTH_SHORT).show()
                    R.id.action_item6->Snackbar.make(binding.root,"item6",Snackbar.LENGTH_SHORT).show()

                }

                true
            }

            pop.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // inflate a menu

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
            R.id.action_item5->Toast.makeText(this,"item5",Toast.LENGTH_SHORT).show()
            R.id.action_item6->Toast.makeText(this,"item6",Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v == binding.btnContext){
            menuInflater.inflate(R.menu.my_menu,menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.action_item1->Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show()
            R.id.action_item2->Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show()
            R.id.action_item3->Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show()
            R.id.action_item4->Toast.makeText(this,"item4",Toast.LENGTH_SHORT).show()
            R.id.action_item5->Toast.makeText(this,"item5",Toast.LENGTH_SHORT).show()
            R.id.action_item6->Toast.makeText(this,"item6",Toast.LENGTH_SHORT).show()

        }

        return super.onContextItemSelected(item)
    }


}