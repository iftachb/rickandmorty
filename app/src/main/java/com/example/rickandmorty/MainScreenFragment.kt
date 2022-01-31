package com.example.rickandmorty

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.rickandmorty.databinding.MainScreenBinding

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager

class MainScreenFragment: Fragment() {
    private lateinit var binding : MainScreenBinding
    // optimisation: can use Koin viewModel
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState )
        with(binding) {
            viewModel.characters.dataLiveData.observe(viewLifecycleOwner) {
                viewModel.resultLiveData.postValue(it.results)
            }
            viewModel.characters.errorMassageLiveData.observe(viewLifecycleOwner, {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })

            viewModel.resultLiveData.observe(viewLifecycleOwner) { results ->
                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(requireContext())
                    if (results != null) {
                        adapter = CharacterAdapter(requireActivity(), results!!)
                    }
                }
            }

        }
    }
}