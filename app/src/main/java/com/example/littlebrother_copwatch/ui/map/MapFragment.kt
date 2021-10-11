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
        val atlanta = LatLng(33.753, -84.386)
        map?.addMarker(
            MarkerOptions()
                .position(atlanta)
                .title("Marker in Atlanta")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.atl_skyline))

        )
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(atlanta, 10F))

    }

}