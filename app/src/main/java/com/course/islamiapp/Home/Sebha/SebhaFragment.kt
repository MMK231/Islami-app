package com.course.islamiapp.Home.Sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.course.islamiapp.R

class SebhaFragment : Fragment() {
    lateinit var sebhaImg: ImageView
    lateinit var zekrTv: TextView
    lateinit var counterTv: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        onSebhaClick()
    }



    private fun onSebhaClick() {
        sebhaImg.setOnClickListener { view ->
            increaseCounter()
            return@setOnClickListener
        }
    }

    private fun initViews(view: View) {
        sebhaImg = view.findViewById(R.id.sebha_image)
        zekrTv = view.findViewById(R.id.zekr)
        counterTv = view.findViewById(R.id.counter)
    }

}

private fun SebhaFragment.increaseCounter() {
    for (i in 0 until 99) {
        if (i <= 32){
            zekrTv.text = "سبحان الله"
            counterTv.text ="$i"
        } else if (i <= 65) {
            zekrTv.text = "الحمد لله"
            counterTv.text ="$i"
        }else{
            zekrTv.text = "الله أكبر"
            counterTv.text ="$i"
        }
    }
}
