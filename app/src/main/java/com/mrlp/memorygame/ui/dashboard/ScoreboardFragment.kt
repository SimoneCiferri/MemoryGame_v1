package com.mrlp.memorygame.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mrlp.memorygame.databinding.FragmentScoreboardBinding
import com.mrlp.memorygame.viewmodel.ScoreboardViewModel

class ScoreboardFragment : Fragment() {

    private var _binding: FragmentScoreboardBinding? = null
    private lateinit var mScoreboardViewModel: ScoreboardViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        mScoreboardViewModel = ViewModelProvider(this).get(ScoreboardViewModel::class.java)

        _binding = FragmentScoreboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setRecyclerAndUserVM()

        return root
    }

    private fun setRecyclerAndUserVM() {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}