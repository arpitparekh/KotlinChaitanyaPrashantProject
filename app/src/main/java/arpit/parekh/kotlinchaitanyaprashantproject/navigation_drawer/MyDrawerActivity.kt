package arpit.parekh.kotlinchaitanyaprashantproject.navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyDrawerBinding

class MyDrawerActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
/////////////////////////////////////////////////////////////////////////////////////////
        binding.navigationView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.action_item1 -> Toast.makeText(this,"Item1",Toast.LENGTH_SHORT).show()
                R.id.action_item2 -> Toast.makeText(this,"Item2",Toast.LENGTH_SHORT).show()
                R.id.action_item3 -> Toast.makeText(this,"Item3",Toast.LENGTH_SHORT).show()
                R.id.action_item4 -> Toast.makeText(this,"Item4",Toast.LENGTH_SHORT).show()
                R.id.action_item5 -> Toast.makeText(this,"Item5",Toast.LENGTH_SHORT).show()
                R.id.action_item6 -> Toast.makeText(this,"Item6",Toast.LENGTH_SHORT).show()

            }
            true
        }
////////////////////////////////////////////////////////////////////////
        binding.toolbar.toolbarLayout.setNavigationOnClickListener {

            binding.drawerLayout.openDrawer(Gravity.LEFT)

        }
////////////////////////////////////////////////////////////////////////////////////////////////////
        val headerLayout : View = binding.navigationView.getHeaderView(0)

        val imageView = headerLayout.findViewById<ImageView>(R.id.ivProfile)
        val tv1 = headerLayout.findViewById<TextView>(R.id.tvName)
        val tv2 = headerLayout.findViewById<TextView>(R.id.tvEmail)

        imageView.setOnClickListener {
            Toast.makeText(this,"ImageView Click",Toast.LENGTH_SHORT).show()
        }
        tv1.setOnClickListener {
            Toast.makeText(this,"TextView1 Click",Toast.LENGTH_SHORT).show()
        }
        tv2.setOnClickListener {
            Toast.makeText(this,"TextView2 Click",Toast.LENGTH_SHORT).show()
        }
////////////////////////////////////////////////////////////////////////////////////////////////////

//        programmatically add header layout
//        binding.navigationView.addHeaderView()
    }
}