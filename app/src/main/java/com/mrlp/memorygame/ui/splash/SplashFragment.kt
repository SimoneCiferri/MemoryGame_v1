package com.mrlp.memorygame.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.get
import com.mrlp.memorygame.R
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

        val textView: TextView = binding.textSplash
        mSplashViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }

}