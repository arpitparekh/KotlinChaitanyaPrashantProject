package arpit.parekh.kotlinchaitanyaprashantproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {

    companion object{

        fun getApiObject() : WeatherApi{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://community-open-weather-map.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api : WeatherApi = retrofit.create(WeatherApi::class.java)

            return api

        }

    }

}