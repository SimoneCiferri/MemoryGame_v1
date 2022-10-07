package com.mrlp.memorygame.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mrlp.memorygame.MainActivity
import com.mrlp.memorygame.databinding.FragmentGameBinding
import com.mrlp.memorygame.viewmodel.GameViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private lateinit var mGameViewModel: GameViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        mGameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUiController()

        val textView: TextView = binding.textGame
        mGameViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    private fun setUiController() {
        MainActivity.showBottomNav(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}