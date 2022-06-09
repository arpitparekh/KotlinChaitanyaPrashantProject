package arpit.parekh.kotlinchaitanyaprashantproject.market_json_parsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMarketListBinding
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MarketListActivity : AppCompatActivity() {

    lateinit var binding : ActivityMarketListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFetch.setOnClickListener {

            val time = binding.edtTime.text.toString()
            val equity = binding.edtEquity.text.toString()

            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://alpha-vantage.p.rapidapi.com/query?interval=$time&function=TIME_SERIES_INTRADAY&symbol=$equity")
                .addHeader("X-RapidAPI-Key","6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077")
                .addHeader("X-RapidAPI-Host","alpha-vantage.p.rapidapi.com")
                .build()

            val call = client.newCall(request)

            call.enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.i("myError",e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {

                    val json = response.body!!.string()

                    val rootObject : JSONObject = JSONObject(json)

                    val subObjectOne : JSONObject = rootObject.getJSONObject("Meta Data")

                    val info = subObjectOne.getString("1. Information")
                    val symbol = subObjectOne.getString("2. Symbol")
                    val timeZone = subObjectOne.getString("6. Time Zone")

                    val subObjectTwo : JSONObject = rootObject.getJSONObject("Time Series ($time)")

                    val timeObject : JSONObject = subObjectTwo.getJSONObject("2022-06-08 17:30:00")

                    val open = timeObject.getString("1. open")
                    val high = timeObject.getString("2. high")
                    val low = timeObject.getString("3. low")
                    val close = timeObject.getString("4. close")
                    val volume = timeObject.getString("5. volume")

                    val result = """
                        information is $info
                        symbol is $symbol
                        timezone is $timeZone
                        open : $open
                        high is $high
                        low is $low
                        close is $close
                        volume is $volume
                    """.trimIndent()

                    runOnUiThread {

                        binding.tvMarket.text = result

                    }


                }


            })


        }
    }
}