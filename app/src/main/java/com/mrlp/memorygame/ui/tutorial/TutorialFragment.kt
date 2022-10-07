package com.mrlp.memorygame.ui.tutorial

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mrlp.memorygame.R
import com.mrlp.memorygame.databinding.FragmentInfosBinding
import com.mrlp.memorygame.databinding.FragmentTutorialBinding
import com.mrlp.memorygame.viewmodel.TutorialViewModel

class TutorialFragment : Fragment() {

    private var _binding: FragmentTutorialBinding? = null
    private lateinit var mTutorialViewModel: TutorialViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mTutorialViewModel = ViewModelProvider(this).get(TutorialViewModel::class.java)

        _binding = FragmentTutorialBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTutorial
        mTutorialViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }

        return root
    }

}