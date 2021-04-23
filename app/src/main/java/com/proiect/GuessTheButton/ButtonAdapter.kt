package com.proiect.GuessTheButton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ButtonAdapter(
        private val buttons:MutableList<ButtonItem>
):RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>(){

    class ButtonViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        return ButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.button_view,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val curButton=buttons[position]
        holder.itemView.apply{
            findViewById<Button>(R.id.button_view_item).text=(curButton.returnvalue+1).toString()
            findViewById<Button>(R.id.button_view_item).setOnClickListener{
                if(curButton.returnvalue==curButton.rightAnswer){
                    buttons.clear()
                    notifyDataSetChanged()

                    Toast.makeText(holder.itemView.context,"Right Button",Toast.LENGTH_SHORT).show()
                }else{
                    buttons.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position,buttons.size)

                }
            }
        }

    }

    override fun getItemCount(): Int {
        return buttons.size
    }

    fun addButton(button:ButtonItem){
        buttons.add(button)
        notifyItemInserted(buttons.size-1)
    }



}