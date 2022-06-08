package arpit.parekh.kotlinchaitanyaprashantproject.json_parsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyJsonBinding
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MyJsonActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyJsonBinding
    lateinit var list : ArrayList<Return>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

        val client : OkHttpClient = OkHttpClient()

        val request : Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .build()

        val call : Call = client.newCall(request)

        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i("failure",e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
//                Log.i("response",response.body!!.string())

                val json : String = response.body!!.string()  // OKHTTP OVER

                val jsonArray : JSONArray = JSONArray(json)

                for(i in 0 until jsonArray.length()) {

                    val jsonObject: JSONObject = jsonArray.getJSONObject(i)

                    val title: String = jsonObject.getString("title")
                    val body: String = jsonObject.getString("body")

                    val r = Return(title,body)

                    list.add(r)

                }

                runOnUiThread {

                    val adapter = ArrayAdapter<Return>(this@MyJsonActivity,android.R.layout.simple_list_item_1,list)
                    binding.listViewJson.adapter = adapter

                }
            }

        })
    }
}