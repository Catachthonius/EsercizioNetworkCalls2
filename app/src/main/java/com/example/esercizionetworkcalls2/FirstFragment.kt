package com.example.esercizionetworkcalls2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.esercizionetworkcalls2.databinding.FragmentFirstBinding
import com.example.esercizionetworkcalls2.networkElements.CatFactData
import com.example.esercizionetworkcalls2.networkElements.CatFactViewModel

class FirstFragment : Fragment() {

    private val catFactViewModel: CatFactViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            catFactViewModel.catFact()
        }

        catFactViewModel.catFactResult.observe(viewLifecycleOwner) {
            catFactText(it)
        }
    }

    private fun catFactText(it: CatFactData) {
        binding.textviewFirst.text = it.fact
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}