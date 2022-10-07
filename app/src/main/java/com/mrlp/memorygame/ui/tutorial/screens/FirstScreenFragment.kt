package com.mrlp.memorygame.ui.tutorial.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.mrlp.memorygame.R
import com.mrlp.memorygame.databinding.FragmentFirstScreenBinding
import com.mrlp.memorygame.viewmodel.FirstScreenViewModel

class FirstScreenFragment : Fragment() {

    private var _binding: FragmentFirstScreenBinding? = null
    private lateinit var mFirstScreenViewModel: FirstScreenViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mFirstScreenViewModel = ViewModelProvider(this).get(FirstScreenViewModel::class.java)

        _binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUiController()

        return root
    }

    private fun setUiController() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.tvNext1.setOnClickListener{
            viewPager?.currentItem=1
        }
    }

}