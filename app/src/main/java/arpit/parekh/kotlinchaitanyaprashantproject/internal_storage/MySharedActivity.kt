package arpit.parekh.kotlinchaitanyaprashantproject.internal_storage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMySharedBinding

class MySharedActivity : AppCompatActivity() {

    lateinit var binding : ActivityMySharedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySharedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStore.setOnClickListener {

            val sharedPreferences : SharedPreferences = getSharedPreferences("myData", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("number",45)
            editor.putString("string","tops")
            editor.putBoolean("isLogin",true)
            editor.apply()
        }

        binding.btnFetch.setOnClickListener {

            val sharedPreferences = getSharedPreferences("myData", MODE_PRIVATE)
            val a = sharedPreferences.getInt("number",0)

            binding.tvShow.text = a.toString()
        }

        binding.btnClear.setOnClickListener {

            val sharedPreferences = getSharedPreferences("myData", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }

    }
}