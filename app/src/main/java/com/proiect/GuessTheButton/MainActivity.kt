package com.proiect.GuessTheButton

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var buttonsAdapter:ButtonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showButtons=findViewById<Button>(R.id.start_button)
        buttonsAdapter= ButtonAdapter(mutableListOf())
        val rvButtons=findViewById<RecyclerView>(R.id.rvButtons)
        rvButtons.adapter=buttonsAdapter
        rvButtons.layoutManager=GridLayoutManager(this,4)


        showButtons.setOnClickListener { startGame() }

    }

    private fun startGame(){
        val buttonsNr:Int=findViewById<EditText>(R.id.bNumbers).text.toString().toInt()-1
        val generatedNr:Int=(0..buttonsNr).random()
        for(i in 0..buttonsNr){
            val auxButton=ButtonItem(i,generatedNr)
            buttonsAdapter.addButton(auxButton)
        }

    }



}