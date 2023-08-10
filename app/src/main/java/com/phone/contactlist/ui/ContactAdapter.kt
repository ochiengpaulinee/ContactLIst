package com.phone.contactlist.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phone.contactlist.databinding.ContactListItemBinding
import com.phone.contactlist.model.ContactData
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactAdapter(var contactList: List<ContactData>, var context:Context):RecyclerView.Adapter<ContactViewHolder>(){
//    lateinit var contactListItemBinding: ContactListItemBinding
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
        binding.tvPhoneNumber.text=currentContact.phone.toString()
        binding.tvEmail.text=currentContact.email
        if (!currentContact.avatar.isNullOrEmpty()) {
            Picasso
                .get()
                .load(currentContact.avatar)
                .transform(CropCircleTransformation())
                .into(binding.ivDiana)
        }
        binding.cvContact.setOnClickListener{
            val intent = Intent(context,ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID",currentContact.contactId)
            context.startActivity(intent)
        }
    }

}
class ContactViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root)