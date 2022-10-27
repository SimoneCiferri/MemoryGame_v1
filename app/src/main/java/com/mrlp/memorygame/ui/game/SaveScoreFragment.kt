package com.mrlp.memorygame.ui.game

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mrlp.memorygame.R
import com.mrlp.memorygame.databinding.FragmentSaveScoreBinding
import com.mrlp.memorygame.viewmodel.SaveScoreViewModel

class SaveScoreFragment : Fragment() {

    private var _binding: FragmentSaveScoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var mSaveScoreViewModel: SaveScoreViewModel
    private val args: SaveScoreFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mSaveScoreViewModel = ViewModelProvider(this).get(SaveScoreViewModel::class.java)
        _binding = FragmentSaveScoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUiController()

        return root
    }

    private fun setUiController() {

        binding.tvScore.text = mSaveScoreViewModel.getScore(args.errors, args.totalTime).toString()
        binding.tvErrorReview.text = args.errors.toString()
        binding.tvTimeReview.text = args.timeToShow
    }

}