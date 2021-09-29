package com.example.littlebrother_copwatch.ui.dossier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.littlebrother_copwatch.R

class DossierFragment : Fragment() {

    private lateinit var dossierViewModel: DossierViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dossierViewModel =
                ViewModelProvider(this).get(DossierViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dossier, container, false)
        val textView: TextView = root.findViewById(R.id.text_dossier)
        return root
    }
}