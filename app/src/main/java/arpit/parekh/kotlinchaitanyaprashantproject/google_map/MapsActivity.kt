package arpit.parekh.kotlinchaitanyaprashantproject.google_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity() {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        binding.btnFindLocation.setOnClickListener {

            val lat = binding.edtLat.text.toString()
            val lon = binding.edtLon.text.toString()

            mapFragment.getMapAsync(object : OnMapReadyCallback{

                override fun onMapReady(mapObject: GoogleMap) {

                    map = mapObject

                    val location : LatLng = LatLng(lat.toDouble(), lon.toDouble())
                    map.addMarker(MarkerOptions().position(location).title("Marker in Sydney"))
                    map.moveCamera(CameraUpdateFactory.newLatLng(location))

                }
            })

        }


    }

//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney : LatLng = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }
}