package com.oceanbrasil.ocean_android_introducao_11_10_2022.view.criaturas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oceanbrasil.ocean_android_introducao_11_10_2022.view.CriaturasAdapter
import com.oceanbrasil.ocean_android_introducao_11_10_2022.R
import com.oceanbrasil.ocean_android_introducao_11_10_2022.databinding.FragmentCriaturasBinding
import com.oceanbrasil.ocean_android_introducao_11_10_2022.viewmodel.CriaturasViewModel

class CriaturasFragment : Fragment() {

    private var _binding: FragmentCriaturasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val criaturasViewModel = ViewModelProvider(this).get(CriaturasViewModel::class.java)

        _binding = FragmentCriaturasBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // Construção da lista

        val rvCriaturas = root.findViewById<RecyclerView>(R.id.rvCriaturas)
        rvCriaturas.layoutManager = GridLayoutManager(root.context, 2)


        criaturasViewModel.criaturas.observe(viewLifecycleOwner) {
            Toast.makeText(this@CriaturasFragment.context, "Criaturas carregadas com sucesso!", Toast.LENGTH_LONG).show()
            rvCriaturas.adapter = CriaturasAdapter(it)
        }

        // Fim da construção da lista
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}