package com.course.islamiapp.Home.ChapterDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.course.islamiapp.R

class ChaptersDetailsActivity : AppCompatActivity() {
    var position: Int = -1
    lateinit var versesRecycler: RecyclerView
    lateinit var title: String
    lateinit var toolbar: Toolbar
    lateinit var tvTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapters_details)
        initParam()
        initView()
        readVersesLineByLine()
    }

    private fun initAdapterViews(listOfVerses: List<String>) {
        var versesAdapter = VersesAdapter(listOfVerses)
        versesRecycler.adapter = versesAdapter
    }

    private fun readVersesLineByLine() {
        val allContent: String = assets.open("${position + 1}.txt")
            .bufferedReader().use { it.readText() }
        val listOfVerses = allContent.split("\n")
        initAdapterViews(listOfVerses)
    }

    private fun initView() {
        toolbar = findViewById(R.id.chapters_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = null
        tvTitle = findViewById(R.id.sura_name)
        tvTitle.text = title
        versesRecycler = findViewById(R.id.verses_rv)
    }

    private fun initParam() {
        position = intent.getIntExtra(EXTRA_POSITION, -1)
        title = intent.getStringExtra(EXTRA_TITLE) ?: ""

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }


    companion object {
        const val EXTRA_POSITION = "Position"
        const val EXTRA_TITLE = "TITLE"
    }
}

