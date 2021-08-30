package br.com.androidkarlos.simplecrudandroidkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class ContactAdapter(var listener: ClickItemContactList):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

     private val list: MutableList<Contact> = mutableListOf()

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.item_contact, parent ,false)
        return ContactViewHolder(view, list, listener)
     }

     override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
         holder.bind(list[position])
     }

     override fun getItemCount(): Int {
        return list.size
     }

     fun updateList(list: List<Contact>){
         this.list.clear()
         this.list.addAll(list)
         notifyDataSetChanged()
     }

     class ContactViewHolder(itemView: View, var list: List<Contact>, private var listener: ClickItemContactList)
          : RecyclerView.ViewHolder(itemView){
         private val tvName: TextView = itemView.findViewById(R.id.tvName)
         private val tvPhoneNumber: TextView = itemView.findViewById(R.id.tvPhoneNumber)
         private val ivPhotograph: ImageView = itemView.findViewById(R.id.ivPhotograph)

         init {
             itemView.setOnClickListener{
                 listener.clickItemContact(list[adapterPosition])
             }
         }

         fun bind(contact: Contact){
             tvName.text = contact.name
             tvPhoneNumber.text = contact.phone
         }
     }
 }




