package com.example.registropersonas.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.registropersonas.databinding.FragmentPersonasBinding
import com.example.registropersonas.model.Persona
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonasFragment : Fragment(){

    private val viewModel: PersonaViewModel by viewModels()
    private lateinit var binding: FragmentPersonasBinding

    private val args : PersonasFragmentArgs by navArgs()
    private var personaId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonasBinding.inflate(inflater, container, false)

        LlenarCampos()

        binding.guardarButton.setOnClickListener {
            viewModel.guardar(
                Persona(
                    personaId,
                    binding.nombresEditText.text.toString(),
                    binding.salarioEditText.floatValue()
                )
            )
        }

        viewModel.guardado.observe(viewLifecycleOwner){
            if (it) {
                Snackbar.make(binding.salarioEditText, "Guardo", Snackbar.LENGTH_LONG).show()
                findNavController().navigateUp()
            }
        }

        return binding.root
    }

    fun LlenarCampos(){
        val persona: Persona? = args.persona

        persona?.let {
            personaId = it.personaId
            binding.nombresEditText.setText(it.nombres)
            binding.salarioEditText.setText(it.balance.toString())
        }
    }

    fun TextInputEditText.floatValue() = text.toString().toFloatOrNull() ?: 0.0f
}