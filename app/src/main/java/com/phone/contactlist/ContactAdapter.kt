package com.phone.contactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phone.contactlist.databinding.ContactListItemBinding

class ContactAdapter(var contactList: List<ContactData>):RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding=
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        var binding=holder.binding
        binding.tvdisplayName.text=currentContact.name
        binding.tvPhoneNumber.text=currentContact.phone
        binding.tvEmail.text=currentContact.email
    }

}

class ContactViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root)


