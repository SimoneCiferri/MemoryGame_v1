package com.mrlp.memorygame.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mrlp.memorygame.adapter.TutorialAdapter
import com.mrlp.memorygame.databinding.FragmentTutorialBinding
import com.mrlp.memorygame.ui.tutorial.screens.FirstScreenFragment
import com.mrlp.memorygame.ui.tutorial.screens.SecondScreenFragment
import com.mrlp.memorygame.ui.tutorial.screens.ThirdScreenFragment

class TutorialFragment : Fragment() {

    private var _binding: FragmentTutorialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorialBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setAdapter()

        return root
    }

    private fun setAdapter() {
        val fragmentList = arrayListOf( FirstScreenFragment(), SecondScreenFragment(), ThirdScreenFragment() )
        val adapter = TutorialAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
    }

}