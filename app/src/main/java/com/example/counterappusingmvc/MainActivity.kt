package com.example.counterappusingmvc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counterappusingmvc.databinding.ActivityMainBinding
import com.example.counterappusingmvc.models.CounterModel
import java.util.Observable
import java.util.Observer

class MainActivity : AppCompatActivity(), Observer {
    private lateinit var binding: ActivityMainBinding
    private var counterModel = CounterModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        counterModel.addObserver(this)
        loadUI()
    }

    private fun loadUI() {
        binding.button.setOnClickListener { counterModel.decrement() }
        binding.button2.setOnClickListener { counterModel.decrement() }
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("SetTextI18n")
    override fun update(p0: Observable?, p1: Any?) {
        binding.textView.text = counterModel.getCount().toString()
    }
}
