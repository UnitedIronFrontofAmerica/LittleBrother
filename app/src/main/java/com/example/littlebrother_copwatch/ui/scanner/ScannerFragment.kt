package com.example.littlebrother_copwatch.ui.scanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.littlebrother_copwatch.R

class ScannerFragment : Fragment() {

    private lateinit var scannerViewModel: ScannerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        scannerViewModel =
                ViewModelProvider(this).get(ScannerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_scanner, container, false)
        val textView: TextView = root.findViewById(R.id.text_scanner)
        return root
    }
}