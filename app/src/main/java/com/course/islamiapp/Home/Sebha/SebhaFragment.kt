package com.course.islamiapp.Home.Sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    var counter: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSebhaClick()
    }


    private fun onSebhaClick() {
        binding.bodyOfSebha.setOnClickListener {
            changeZekrAndRotateImg()
        }

    }
}

private fun SebhaFragment.changeZekrAndRotateImg() {
    counter++
    binding.bodyOfSebha.animate().rotationBy(45f).setDuration(300).start()
    binding.counter.text = counter.toString()
    when (counter) {
        in 1..33 -> binding.zekr.text = "سبحان الله"
        in 34..66 -> binding.zekr.text = "الحمد لله"
        in 67..99 -> binding.zekr.text = "الله أكبر"
        100 -> binding.zekr.text = "لا اله الا الله"

        else -> {
            counter = 0
            binding.counter.text = "0"
            binding.zekr.text = "سبحان الله"
        }


    }
}






