package com.mrlp.memorygame.ui.tutorial.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mrlp.memorygame.databinding.FragmentThirdScreenBinding
import com.mrlp.memorygame.ui.tutorial.TutorialFragmentDirections
import com.mrlp.memorygame.viewmodel.ThirdScreenViewModel

class ThirdScreenFragment : Fragment() {

    private var _binding: FragmentThirdScreenBinding? = null
    private lateinit var mThirdScreenViewModel: ThirdScreenViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mThirdScreenViewModel = ViewModelProvider(this).get(ThirdScreenViewModel::class.java)

        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUiController()

        return root
    }

    private fun setUiController() {
        binding.tvFinish.setOnClickListener{
            mThirdScreenViewModel.onTutorialFinished(requireActivity())
            val navToGame = TutorialFragmentDirections.actionTutorialFragmentToNavigationGame()
            Navigation.findNavController(binding.root).navigate(navToGame)
        }
    }
}