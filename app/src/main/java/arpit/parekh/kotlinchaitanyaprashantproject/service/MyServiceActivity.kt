package arpit.parekh.kotlinchaitanyaprashantproject.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyServiceBinding

class MyServiceActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlaySong.setOnClickListener {

            val intent = Intent(this,PlaySongService::class.java)
            startService(intent)
        }

        binding.btnDownloadFile.setOnClickListener {

            val intent = Intent(this,DownloadFileService::class.java)
            startService(intent)

        }

    }
}