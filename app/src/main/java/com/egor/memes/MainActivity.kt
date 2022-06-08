package com.egor.memes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.egor.memes.databinding.ActivityMainBinding
import com.egor.memes.util.ProgressStatus
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setLiveDataObserver()
    }

    private fun initView() {
        binding.rvFeed.layoutManager = LinearLayoutManager(this)
        viewModel.fetchMemesList()
    }

    private fun setLiveDataObserver() {
        viewModel.memeLiveData.observe(this) {
            when(it) {
                is ProgressStatus.Loading -> {}
                is ProgressStatus.Success -> {
                    binding.rvFeed.adapter = FeedAdapter(it.data)
                }
                is ProgressStatus.Error -> {
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}