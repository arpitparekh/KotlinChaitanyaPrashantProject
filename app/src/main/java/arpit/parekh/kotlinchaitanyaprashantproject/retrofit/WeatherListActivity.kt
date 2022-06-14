package arpit.parekh.kotlinchaitanyaprashantproject.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityWeatherListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherListActivity : AppCompatActivity() {
    lateinit var binding : ActivityWeatherListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api : WeatherApi = ApiHelper.getApiObject()

        binding.btnFindWeather.setOnClickListener {

            val location = binding.edtLocation.text.toString();

            val call : Call<Weather> = api.getWeatherData(location)

            call.enqueue(object : Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {

                    val weather = response.body()

                    binding.obj = weather

                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                   Log.i("weatherError",t.message.toString())
                }

            })

        }

    }
}