package com.outerspace.coroutines_experiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.outerspace.coroutines_experiment.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this as ViewModelStoreOwner)[MainViewModel::class.java]

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.infoObservable.observe(this as LifecycleOwner) {
            binding.contentTextView.text = it
        }

        binding.startButton.setOnClickListener {
            viewModel.getFreshData()
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