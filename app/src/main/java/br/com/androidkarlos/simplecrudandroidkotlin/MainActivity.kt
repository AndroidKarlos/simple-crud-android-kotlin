package br.com.androidkarlos.simplecrudandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ClickItemContactList {
    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rvListContact)
    }
    private var contactAdapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews(){
        rvList.adapter = contactAdapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }

    private fun updateList(){
        contactAdapter.updateList(
            arrayListOf(
                Contact("Marinaldo", "(81) 98727-4322", ""),
                Contact("Marinilza", "(81) 98727-4322", ""),
                Contact("Marta", "(81) 98727-4322", "")
            )
        )
    }

    override fun clickItemContact(contact: Contact) {
        val  i = Intent(this, ContactDetail::class.java)
        startActivity(i)
    }


}