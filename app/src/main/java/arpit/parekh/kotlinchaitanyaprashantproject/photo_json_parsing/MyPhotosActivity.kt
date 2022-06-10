package arpit.parekh.kotlinchaitanyaprashantproject.photo_json_parsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyPhotosBinding
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class MyPhotosActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyPhotosBinding
    lateinit var list : ArrayList<Photo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPhotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPhotos.layoutManager = GridLayoutManager(this,2)

        list = ArrayList()

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://picsum.photos/v2/list").build()

        val call = client.newCall(request)

        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i("myError",e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {

                val json = response.body!!.string()

                val jsonArray = JSONArray(json)

                for(i in 0 until jsonArray.length()){

                    val jsonObject = jsonArray.getJSONObject(i)

                    val author = jsonObject.getString("author")
                    val url = jsonObject.getString("download_url")

                    val photo = Photo(author,url)

                    list.add(photo)

                }
                runOnUiThread {
                    val adapter = PhotoAdapter(list,this@MyPhotosActivity)
                    binding.rvPhotos.adapter =adapter
                }


            }

        })

    }
}