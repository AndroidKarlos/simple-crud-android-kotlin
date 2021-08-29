package br.com.androidkarlos.simplecrudandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rvListContact)
    }
    private var contactAdapter = ContactAdapter()

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


}