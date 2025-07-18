package com.course.islamiapp.Home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.course.islamiapp.Home.Hadith.Hadeth
import com.course.islamiapp.R
import com.course.islamiapp.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var hadeth: Hadeth
    lateinit var content: TextView
    lateinit var binding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initParams()
        initViews()
    }


    private fun initParams() {
        hadeth = (intent.getParcelableExtra(EXTRA_HADETH) as Hadeth?)!!
    }

    private fun initViews() {
        setSupportActionBar(binding.ahadethToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = null
        content = findViewById(R.id.hadeth_detail_tv)
        content.text = hadeth.content
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    companion object {
        val EXTRA_HADETH = "Hadeth"
    }
}
