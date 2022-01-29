package com.example.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget.databinding.ActivityWebBinding

private lateinit var binding: ActivityWebBinding
class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var url:String="https://android-studio.ir"
        binding.webView.loadUrl(url)
    }
}