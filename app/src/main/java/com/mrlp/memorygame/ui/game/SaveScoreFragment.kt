package com.mrlp.memorygame.ui.game

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
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
        binding.etPlayerName.doAfterTextChanged {
            if(binding.etPlayerName.text.toString().length > 6){
                Toast.makeText(requireContext(), getString(R.string.playernametoolong), Toast.LENGTH_LONG).show()
                binding.etPlayerName.setText("")
            }
        }
        binding.btnSave.setOnClickListener {
            if(inputCheck()){
                mSaveScoreViewModel.saveScore(binding.etPlayerName.text.toString(), binding.tvScore.text.toString().toInt(), args.errors, args.timeToShow)
                closeSoftKeyboard(requireContext(), binding.etPlayerName)
                Toast.makeText(requireContext(), getString(R.string.scoresaved), Toast.LENGTH_LONG).show()
                val navToScore = SaveScoreFragmentDirections.actionSaveScoreFragmentToNavigationScoreboard()
                Navigation.findNavController(binding.root).navigate(navToScore)
            }else{
                Toast.makeText(requireContext(), getString(R.string.insertplayername), Toast.LENGTH_LONG).show()
                closeSoftKeyboard(requireContext(), binding.etPlayerName)
            }
        }
    }

    private fun inputCheck(): Boolean {
        return binding.etPlayerName.text.toString() != ""
    }

    private fun closeSoftKeyboard(context: Context, v: View) {
        val iMm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        iMm.hideSoftInputFromWindow(v.windowToken, 0)
        v.clearFocus()
    }

}