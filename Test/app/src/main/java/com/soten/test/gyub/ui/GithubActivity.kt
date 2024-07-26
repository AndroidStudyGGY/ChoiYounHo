package com.soten.test.gyub.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.soten.test.databinding.ActivityGithubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGithubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}