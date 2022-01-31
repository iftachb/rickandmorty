package com.example.rickandmorty

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.rickandmorty.databinding.CharacterDetailsScreenBinding

class CharacterDetailsScreenFragment : Fragment() {
    companion object {
        val COUNT = "COUNT"
        fun newInstance(count: Int): CharacterDetailsScreenFragment {
            val myFragment = CharacterDetailsScreenFragment()
            val args = Bundle()
            args.putInt(COUNT, count)
            myFragment.setArguments(args)
            return myFragment
        }
    }

    private lateinit var binding : CharacterDetailsScreenBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterDetailsScreenBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = getArguments()?.getInt(COUNT, 0)
        val results = viewModel.resultLiveData.value?.get(position!!)
        with(binding) {
            results.let {
                tvName.text = it!!.name
                tvGender.text = it.gender
                tvLocation.text = it.location?.name
                tvOrigin.text = it.origin?.name
                tvStatus.text = it.status
                tvType.text = it.type
                tvSpecies.text = it.species

                bShare.setOnClickListener {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, results?.name)
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(sendIntent, null)
                    startActivity(shareIntent)
                }
            }
        }
    }
}