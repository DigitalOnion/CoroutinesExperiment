package com.outerspace.coroutines_experiment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.outerspace.coroutines_experiment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this as ViewModelStoreOwner)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.infoLiveData.observe(this as LifecycleOwner) {
            val txt = "${binding.contentTextView.text}\n${it}"
            binding.contentTextView.text = txt
        }

        binding.startButton.setOnClickListener {
            viewModel.getFreshData()
        }

        // ---------------------------------------------------

        binding.nextButton.setOnClickListener {
            startActivity(Intent(this as Context, WebActivity::class.java))
        }

    }
}



/*

        binding.startButton.setOnClickListener {

            lifecycleScope.launch(Dispatchers.Main) {  // suspend scope (function)
                delay(1000)
                val txt = "${binding.contentTextView.text.toString()}\nMy cat is asleep"
                binding.contentTextView.text = txt
            }

            val txtDog = "${binding.contentTextView.text.toString()}\nMy dog is asleep"
            binding.contentTextView.text = txtDog

            val txtParrot = "${binding.contentTextView.text.toString()}\nMy parrot is asleep"
            binding.contentTextView.text = txtParrot

        }

 */