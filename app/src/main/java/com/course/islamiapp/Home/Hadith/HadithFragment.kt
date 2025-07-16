package com.course.islamiapp.Home.Hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.islamiapp.databinding.FragmentHadithBinding

class HadithFragment: Fragment() {
    lateinit var binding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadithBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadithLineByLine()
    }


    private fun readAhadithLineByLine() {
        val allContent: String =
            requireContext().assets.open("ahadeth.txt")
                .bufferedReader().use { it.readText() }
        val listOfSeparatedAhadeth = allContent.split("#")
        bindAhadithInRecyclerView(listOfSeparatedAhadeth)
//        listOfSeparatedAhadeth.forEach { hadeth ->
//
//
//        }
    }

    private fun bindAhadithInRecyclerView(listOfSeparatedAhadeth: List<String>) {
        val adapter = AhadethAdapter(listOfSeparatedAhadeth)
        binding.ahadithRv.adapter = adapter
    }

}