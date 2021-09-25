package com.poc.audiodiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.poc.audiodiary.R

class Diary : AppCompatActivity() {
    lateinit var recyclerDiary: RecyclerView
    lateinit var micDiary: ImageView
    lateinit var  imgSave : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)


        recyclerDiary = findViewById(R.id.recyclerDiary)
        micDiary = findViewById(R.id.micDiary)
        imgSave = findViewById(R.id.imgSave)

     micDiary.setOnClickListener(View.OnClickListener {
         Toast.makeText(this,"recording statement",Toast.LENGTH_LONG).show()
     })


        imgSave.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show()
        })


    }
}