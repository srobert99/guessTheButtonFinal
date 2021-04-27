package com.proiect.GuessTheButton

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showButtons=findViewById<Button>(R.id.start_button)

        showButtons.setOnClickListener { initRecyclerView() }

    }


    private fun initRecyclerView(){
        val butRecyclerView=findViewById<RecyclerView>(R.id.rvButtons)
        val nr = findViewById<EditText>(R.id.bNumbers).text.toString().toInt()
        val guess=answer(nr)
        val buttonAdapter=ButtonAdapter(guess, mutableListOf())
        for(i in 0..nr-1){
            buttonAdapter.addButton(ButtonItem(i))
        }
        butRecyclerView.layoutManager=GridLayoutManager(this,4)
        butRecyclerView.adapter=buttonAdapter
    }

    private fun answer(counter: Int):Int{
        return (1..counter-1).random()
    }



}