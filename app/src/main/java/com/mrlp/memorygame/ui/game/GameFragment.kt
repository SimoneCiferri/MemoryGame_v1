package com.mrlp.memorygame.ui.game

import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mrlp.memorygame.MainActivity
import com.mrlp.memorygame.R
import com.mrlp.memorygame.databinding.FragmentGameBinding
import com.mrlp.memorygame.viewmodel.GameViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private lateinit var mGameViewModel: GameViewModel
    private lateinit var buttons: List<ImageButton>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        mGameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        showBottomNav()
        setUiController()

        return root
    }

    private fun showBottomNav() {
        MainActivity.showBottomNav(true)
    }

    private fun setUiController() {
        setTextViews()
        setImageButtons()
        setButtons()
    }

    private fun setTextViews() {
        mGameViewModel.error.observe(viewLifecycleOwner){
            binding.tvError.text = it.toString()
        }
    }

    private fun setImageButtons() {
        buttons = listOf(binding.ib1,binding.ib2,binding.ib3,binding.ib4,binding.ib5,
            binding.ib6,binding.ib7,binding.ib8,binding.ib9,binding.ib10,binding.ib11,
            binding.ib12 )
        for(btn in buttons){
            btn.isEnabled = false
            btn.alpha = 0.5f
            btn.setOnClickListener {

            }
        }
    }

    private fun setButtons() {
        //binding.btnSaveScore.isVisible = false

        binding.btnNewGame.setOnClickListener {
            binding.btnSaveScore.isVisible = false
            mGameViewModel.newGame()
            for(btn in buttons){
                btn.isEnabled = true
                btn.alpha = 1f
                flipImageButton(btn)
            }
            //updateImageButtons()

        }

        binding.btnSaveScore.setOnClickListener {
            mGameViewModel.increaseErrors()
        }
    }

    private fun flipImageButton(btn: ImageButton) {
        val flip = AnimatorInflater.loadAnimator(requireContext(), R.animator.flip)
        flip.duration = 350
        flip.setTarget(btn)
        flip.start()
    }

    private fun updateImageButtons() {
        //updateViews
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}