package br.com.androidkarlos.simplecrudandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val contacts = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = findViewById(R.id.rvListContact)
        customAdapter = CustomAdapter(contacts)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareContacts()
    }

    private fun prepareContacts(){
        contacts.add("Marinilza")
        contacts.add("Marinaldo")
        contacts.add("Marta")
        customAdapter.notifyDataSetChanged()
    }
}