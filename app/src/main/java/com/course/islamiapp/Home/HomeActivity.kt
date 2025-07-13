package com.course.islamiapp.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.course.islamiapp.Home.Hadith.HadithFragment
import com.course.islamiapp.Home.Quran.QuranFragment
import com.course.islamiapp.R
import com.course.islamiapp.Home.Radio.RadioFragment
import com.course.islamiapp.Home.Sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
   lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.navigation_buttons)
        bottomNavigationView.setOnItemSelectedListener{item ->
           when(item.itemId){
               R.id.quran_navigation->{
                   showTab(QuranFragment())
               }
               R.id.hadith_navigation->{
                   showTab(HadithFragment())
               }
               R.id.sebha_navigation ->{
                   showTab(SebhaFragment())
               }
               R.id.radio_navigation->{
                   showTab(RadioFragment())
               }
           }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.quran_navigation


    }

    private fun showTab(fragment: Fragment) {
       supportFragmentManager
           .beginTransaction()
           .replace(R.id.fragment_container,fragment)
               .commit()
    }
}

