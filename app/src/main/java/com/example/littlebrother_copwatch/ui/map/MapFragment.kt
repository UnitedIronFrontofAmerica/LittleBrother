package com.example.littlebrother_copwatch.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.littlebrother_copwatch.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment() , OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        map_view.onCreate(savedInstanceState)
        map_view.onResume()
        map_view.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let{
            googleMap = it
        }

        val atlanta = LatLng(33.778, -84.388)
        map?.addMarker(
            MarkerOptions()
                .position(atlanta)
                .title("Marker in Atlanta")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.city_marker))

        )
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(atlanta, 10F))

        //INFO: The following sets coordinates and marker positions for Atlanta Police related facilities
        //TODO: More facilities needed
        val zoneOne = LatLng(33.777, -84.460)
        map?.addMarker(
            MarkerOptions()
                .position(zoneOne)
                .title("Zone 1 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        val zoneTwo = LatLng(33.840, -84.372)
        map?.addMarker(
            MarkerOptions()
                .position(zoneTwo)
                .title("Zone 2 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        val zoneThree = LatLng(33.730, -84.373)
        map?.addMarker(
            MarkerOptions()
                .position(zoneThree)
                .title("Zone 3 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        val zoneFour = LatLng(33.725, -84.450)
        map?.addMarker(
            MarkerOptions()
                .position(zoneFour)
                .title("Zone 4 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        val zoneFive = LatLng(33.760, -84.389)
        map?.addMarker(
            MarkerOptions()
                .position(zoneFive)
                .title("Zone 5 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        val zoneSix = LatLng(33.751, -84.321)
        map?.addMarker(
            MarkerOptions()
                .position(zoneSix)
                .title("Zone 6 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        val zoneSixMini = LatLng(33.765, -84.349)
        map?.addMarker(
            MarkerOptions()
                .position(zoneSixMini)
                .title("Mini Zone 6 Atlanta Police Department")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police_facility_marker))
        )

        //INFO TODO: END

        //TODO: Add polygons to visualize boundaries for City of Atlanta and/or Atlanta Police Zones
        /*
        val zone_one = map?.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(),
                )
        )
        */
        //TODO: END
    }

}