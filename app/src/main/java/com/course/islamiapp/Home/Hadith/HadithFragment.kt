package com.course.islamiapp.Home.Hadith

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.islamiapp.Home.HadithDetails.HadethDetailsActivity
import com.course.islamiapp.databinding.FragmentHadithBinding

class HadithFragment : Fragment() {
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
        val allHadethList: MutableList<Hadeth> = mutableListOf()
        val allContent: String =
            requireContext().assets.open("ahadeth.txt")
                .bufferedReader().use { it.readText() }
        val listOfSeparatedAhadeth = allContent.split("#")
        listOfSeparatedAhadeth.forEach { hadeth ->
            val hadithLines = hadeth.trim().split("\n").toMutableList()
            val h = Hadeth(
                content = hadithLines.joinToString("\n")
            )
            allHadethList.add(h)
        }
        bindAhadithInRecyclerView(allHadethList)
    }

    private fun bindAhadithInRecyclerView(allHadethList: MutableList<Hadeth>) {
        val adapter = AhadethAdapter(allHadethList)
        adapter.onItemClickListener = AhadethAdapter.OnItemClickListener { position, hadeth ->
            startHadethDetailsActivity(hadeth)
        }
        binding.ahadithRv.adapter = adapter
    }


    private fun HadithFragment.startHadethDetailsActivity(hadeth: Hadeth) {
        var intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(HadethDetailsActivity.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

}

