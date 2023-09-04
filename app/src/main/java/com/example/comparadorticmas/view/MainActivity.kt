package com.example.comparadorticmas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.comparadorticmas.databinding.ActivityMainBinding;


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCompare.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()
            mainViewModel.compareText(text1, text2);
        }

        mainViewModel.compare.observe(this) {
            println("Nuevo valor de comparación: $it")
            binding.textResult.text = "${it.text1}"
        }
    }
}