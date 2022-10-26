package com.mrlp.memorygame

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mrlp.memorygame.databinding.ActivityMainBinding
import com.mrlp.memorygame.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mMainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNav()
        showBottomNav(false)
        setActionBar()
        setOST()
        setUiController()
    }

    private fun setBottomNav(){
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_game, R.id.navigation_scoreboard, R.id.navigation_info))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun showBottomNav(show: Boolean){
        binding.navView.isVisible = show
    }

    private fun setActionBar(){
        supportActionBar?.hide()
    }

    private fun setUiController() {
        ivAudioSet()
        binding.ivAudio1.setOnClickListener{
            if(mMainActivityViewModel.isOSTPlaying()){
                mMainActivityViewModel.setOSTState(false)
                binding.ivAudio1.setImageResource(R.drawable.ic_baseline_volume_off_24)
            }else{
                mMainActivityViewModel.setOSTState(true)
                binding.ivAudio1.setImageResource(R.drawable.ic_baseline_volume_up_24)
            }

        }
    }

    private fun ivAudioSet() {
        if(mMainActivityViewModel.isOSTPlaying()){
            binding.ivAudio1.setImageResource(R.drawable.ic_baseline_volume_up_24)
        }else{
            binding.ivAudio1.setImageResource(R.drawable.ic_baseline_volume_off_24)
        }
    }

    private fun setOST() {
        mMainActivityViewModel.setOST(this)
    }

    override fun onPause() {
        super.onPause()
        mMainActivityViewModel.mpPause()
    }

    override fun onResume() {
        super.onResume()
        mMainActivityViewModel.mpResume()
    }

}