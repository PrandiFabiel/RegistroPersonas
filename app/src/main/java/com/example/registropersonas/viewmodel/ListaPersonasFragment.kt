package com.example.registropersonas.viewmodel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.registropersonas.R

class ListaPersonasFragment : Fragment() {

    companion object {
        fun newInstance() = ListaPersonasFragment()
    }

    private lateinit var viewModel: ListaPersonasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_personas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListaPersonasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}