package arpit.parekh.kotlinchaitanyaprashantproject.service

import android.app.Service
import android.content.Intent
import android.os.Environment
import android.os.IBinder
import java.io.DataInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL

class DownloadFileService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        downloadFileFromServer()

        return super.onStartCommand(intent, flags, startId)



    }

    private fun downloadFileFromServer() {

        // https://file-examples.com/storage/fe88505b6162b2538a045ce/2017/10/file-example_PDF_1MB.pdf

        Thread{

            val url : URL = URL("https://file-examples.com/storage/fe88505b6162b2538a045ce/2017/10/file_example_JPG_2500kB.jpg")

            val inputStream : InputStream =  url.openStream()

            val dataInputStream : DataInputStream = DataInputStream(inputStream)

            ////////////////////////////  external storage ////////////////////////////

            val rootPath = Environment.getExternalStorageDirectory()

            val subFolder = File(rootPath,"Downloaded Files")

            subFolder.mkdir()

            val file = File(subFolder,"demoImage.jpg")

            val fos = FileOutputStream(file)

            //////////////////////////////////////////////////////////////////////////

            val arr = ByteArray(1024)

            var size : Int = 0

            while(dataInputStream.read(arr).also { size = it } > 0) {

                fos.write(arr, 0, size)

            }

        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}