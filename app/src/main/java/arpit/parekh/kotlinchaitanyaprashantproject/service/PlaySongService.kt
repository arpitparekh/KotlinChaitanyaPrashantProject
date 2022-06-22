package arpit.parekh.kotlinchaitanyaprashantproject.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import arpit.parekh.kotlinchaitanyaprashantproject.R

class PlaySongService : Service() {

    lateinit var mediaPlayer : MediaPlayer

    //https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3
    //https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3
    //https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3

    val arr = arrayOf("https://download.samplelib.com/mp3/sample-3s.mp3",
    "https://download.samplelib.com/mp3/sample-9s.mp3",
    "https://download.samplelib.com/mp3/sample-15s.mp3")


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        playSong(0)

        return super.onStartCommand(intent, flags, startId)
    }

    private fun playSong(position: Int) {  // 0 // 1 // 2
        if(position>=arr.size){
            return
        }
        mediaPlayer = MediaPlayer.create(this,Uri.parse(arr[position]))
        mediaPlayer.setVolume(100.0f,100.0f)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            playSong(position+1)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()

    }

    override fun onCreate() {
        super.onCreate()
    }

}