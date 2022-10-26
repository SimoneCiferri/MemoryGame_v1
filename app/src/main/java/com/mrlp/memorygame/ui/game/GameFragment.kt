package com.mrlp.memorygame.ui.game

import android.animation.Animator
import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mrlp.memorygame.MainActivity
import com.mrlp.memorygame.R
import com.mrlp.memorygame.databinding.FragmentGameBinding
import com.mrlp.memorygame.model.Values
import com.mrlp.memorygame.viewmodel.GameViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val images = mutableListOf(R.drawable.pikachu, R.drawable.bulbasaur, R.drawable.charmander,
        R.drawable.gengar, R.drawable.squirtle, R.drawable.mew, R.drawable.pikachu, R.drawable.bulbasaur,
        R.drawable.charmander, R.drawable.gengar, R.drawable.squirtle, R.drawable.mew)
    private lateinit var mGameViewModel: GameViewModel
    private lateinit var buttons: List<ImageButton>
    private lateinit var zoom: Animator

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        mGameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        zoom = AnimatorInflater.loadAnimator(requireContext(), R.animator.zoom)
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
            btn.alpha = Values.ALPHA_BUTTON_DISABLED
        }
        buttons.forEachIndexed { index, btn ->
            btn.setOnClickListener{
                val checkRes = mGameViewModel.updateModel(index)
                if(checkRes == Values.CHECK_ERROR){
                    makeToast(getString(R.string.invalid_move))
                }else{
                    if (checkRes == Values.CARD_MATCHED){
                        flipImageButton(buttons[index])
                    }
                    if(checkRes == Values.CARD_NOT_MATCHED){
                        mGameViewModel.increaseErrors()
                    }
                }
                updateImageButtons()
                if(mGameViewModel.checkAllCards()){
                    mGameViewModel.setFinalTime()
                    binding.btnSaveScore.isVisible = true
                    zoomButton(binding.btnSaveScore)
                }
            }
        }
    }

    private fun setButtons() {
        binding.btnSaveScore.isVisible = false

        zoomButton(binding.btnNewGame)
        binding.btnNewGame.setOnClickListener {
            binding.btnSaveScore.isVisible = false
            images.shuffle()
            mGameViewModel.newGame(images, buttons)
            for(btn in buttons){
                btn.isEnabled = true
                btn.alpha = Values.ALPHA_BUTTON_ENABLED
                flipImageButton(btn)
            }
            updateImageButtons()
        }

        binding.btnSaveScore.setOnClickListener {
            mGameViewModel.increaseErrors()
            //here navigation to saveScoreFragment
        }
    }

    private fun zoomButton(btn: Button) {
        zoom.setTarget(btn)
        zoom.duration = Values.ZOOM_ANIM_DURATION
        zoom.start()
    }

    private fun flipImageButton(btn: ImageButton) {
        val flip = AnimatorInflater.loadAnimator(requireContext(), R.animator.flip)
        flip.duration = Values.FLIP_ANIM_DURATION
        flip.setTarget(btn)
        flip.start()
    }

    private fun updateImageButtons() {
        mGameViewModel.getCards().forEachIndexed { index, card ->
            val btn = buttons[index]
            if(card.isMatched){
                btn.alpha = Values.ALPHA_BUTTON_MATCHED
            }else{
                btn.alpha = Values.ALPHA_BUTTON_ENABLED
            }
            btn.setImageResource(if(card.isFaceUp) card.ID else R.drawable.quesmark)
        }
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}