package com.mrlp.memorygame.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mrlp.memorygame.databinding.FragmentSplashBinding
import com.mrlp.memorygame.viewmodel.SplashViewModel

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private lateinit var mSplashViewModel: SplashViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mSplashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root

        selectNextDestination()

        return root
    }

    private fun selectNextDestination() {
        Handler(Looper.getMainLooper()).postDelayed({
            if(mSplashViewModel.tutorialDone(requireActivity())){
                val navToGame = SplashFragmentDirections.actionSplashFragmentToNavigationGame2()
                findNavController().navigate(navToGame)
            }else{
                val navToTutorial = SplashFragmentDirections.actionSplashFragmentToTutorialFragment()
                findNavController().navigate(navToTutorial)
            }
        },3000)
    }

}