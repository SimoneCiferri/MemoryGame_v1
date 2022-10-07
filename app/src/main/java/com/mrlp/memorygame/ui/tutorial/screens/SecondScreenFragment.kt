package com.mrlp.memorygame.ui.tutorial.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.mrlp.memorygame.R
import com.mrlp.memorygame.databinding.FragmentSecondScreenBinding
import com.mrlp.memorygame.viewmodel.SecondScreenViewModel

class SecondScreenFragment : Fragment() {

    private var _binding: FragmentSecondScreenBinding? = null
    private lateinit var mSecondScreenViewModel: SecondScreenViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mSecondScreenViewModel = ViewModelProvider(this).get(SecondScreenViewModel::class.java)

        _binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUiController()

        return root
    }

    private fun setUiController() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.tvNext2.setOnClickListener{
            viewPager?.currentItem=2
        }
    }

}