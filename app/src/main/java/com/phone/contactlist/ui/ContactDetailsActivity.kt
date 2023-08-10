package com.phone.contactlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.phone.contactlist.R
import com.phone.contactlist.databinding.ActivityContactDetailsBinding
import com.phone.contactlist.model.ContactData
import com.phone.contactlist.viewModel.ContactsViewModel
import com.squareup.picasso.Picasso

class ContactDetailsActivity : AppCompatActivity() {
    var contactsId = 0
    lateinit var viewModel: ContactsViewModel
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.btnDelete.setOnClickListener {

       }
        viewModel = ContactsViewModel()
        val contactsId = intent.getIntExtra("CONTACT_ID",0)
        viewModel.getContactsById(contactsId).observe(this, Observer { contact ->
            if (contact != null){
                displayContactDetail(contact)
            }
            else{
                Toast.makeText(this,"contact not found",Toast.LENGTH_LONG).show()
            }
        })
        }

    fun displayContactDetail(contacts:ContactData){
        binding.tvName.text = contacts.name
        binding.tvPhone.text = contacts.phone
        binding.tvEmail.text = contacts.email
        if (!contacts.avatar.isNullOrEmpty()){
            Picasso
                .get()
                .load(contacts.avatar)
                .resize(80,80)
                .centerCrop()
                .into(binding.ivImage)
        }
    }
    }
