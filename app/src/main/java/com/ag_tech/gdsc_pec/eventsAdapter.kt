package com.ag_tech.gdsc_pec

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ag_tech.gdsc_pec.databinding.EventItemBinding

class eventsAdapter(var context : Context, var eventlist : ArrayList<eventslist>) : RecyclerView.Adapter<eventsAdapter.eventsViewHolder>(){
    inner class eventsViewHolder(val binding : EventItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eventsViewHolder {
        val view = EventItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return(eventsViewHolder(view))
    }

    override fun getItemCount(): Int {
       return eventlist.size
    }

    override fun onBindViewHolder(holder: eventsViewHolder, position: Int) {
        holder.binding.textViewdate.text=eventlist[position].eventdate
        holder.binding.textViewmonth.text = eventlist[position].eventmonth
        holder.binding.textViewheading.text = eventlist[position].eventheading
        holder.binding.textViewdescription.text=eventlist[position].eventdescription
    }


}