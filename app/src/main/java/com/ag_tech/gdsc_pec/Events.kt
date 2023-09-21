package com.ag_tech.gdsc_pec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ag_tech.gdsc_pec.databinding.ActivityEventsBinding
import com.google.firebase.database.*


class Events : AppCompatActivity() {
    lateinit var  eventsBinding: ActivityEventsBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myreference : DatabaseReference = database.reference.child("events")
    val eventlist = ArrayList<eventslist>()
    lateinit var eventsAdapter : eventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventsBinding = ActivityEventsBinding.inflate(layoutInflater)
        val view = eventsBinding.root
        setContentView(view)
        retrieveDataFromDatabase()

    }

    private fun retrieveDataFromDatabase() {
      myreference.addValueEventListener(object : ValueEventListener{
          override fun onDataChange(snapshot: DataSnapshot) {
              eventlist.clear()
              for(eachevent in snapshot.children) {

                  val event = eachevent.getValue(eventslist::class.java)
                  if (event != null) {
                        println("eventdate :${event.eventdate}")
                      println("eventmonth :${event.eventmonth}")
                      println("eventheading :${event.eventheading}")
                      println("eventdescription :${event.eventdescription}")
                      eventlist.add(event)

                  }
                  eventsAdapter = eventsAdapter(this@Events,eventlist)
                 eventsBinding.recyclerview.layoutManager =LinearLayoutManager(this@Events)
                  eventsBinding.recyclerview.adapter=eventsAdapter

              }

          }

          override fun onCancelled(error: DatabaseError) {

          }
      })
    }
}