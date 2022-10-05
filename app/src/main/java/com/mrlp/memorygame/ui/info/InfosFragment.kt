package com.mrlp.memorygame.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mrlp.memorygame.databinding.FragmentInfosBinding
import com.mrlp.memorygame.viewmodel.InfosViewModel

class InfosFragment : Fragment() {

    private var _binding: FragmentInfosBinding? = null
    private lateinit var mInfosViewModel: InfosViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        mInfosViewModel = ViewModelProvider(this).get(InfosViewModel::class.java)

        _binding = FragmentInfosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        mInfosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}