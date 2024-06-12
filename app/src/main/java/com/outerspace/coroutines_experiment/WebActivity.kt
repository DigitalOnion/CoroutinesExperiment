package com.outerspace.coroutines_experiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.outerspace.coroutines_experiment.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    private lateinit var webViewModel: WebViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)

        webViewModel = ViewModelProvider(this as ViewModelStoreOwner)[WebViewModel::class.java]

        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            webViewModel.getFreshData()
        }
    }
}