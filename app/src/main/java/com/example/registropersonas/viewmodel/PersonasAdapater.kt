package com.example.registropersonas.viewmodel

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.registropersonas.databinding.RowPersonasBinding
import com.example.registropersonas.model.Persona


class PersonasAdapter(
    private var onItemClicked: ((persona:Persona) -> Unit)
) : ListAdapter<Persona, PersonasAdapter.PersonaViewHolder>(PersonaDiffCallBack()){

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val binding =
            RowPersonasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonaViewHolder(binding)
    }

    inner class PersonaViewHolder(private  val binding: RowPersonasBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item: Persona) {
                    binding.personaIdTextView.text = item.personaId.toString()
                    binding.nombresTextView.text = item.nombres
                    binding.salarioTextView.text = item.balance.toString()

                    binding.root.setOnClickListener{
                        onItemClicked(item)
                    }
                }
            }
}

class PersonaDiffCallBack : DiffUtil.ItemCallback<Persona>() {
    override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem.personaId == newItem.personaId
    }

    override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem == newItem
    }
}
