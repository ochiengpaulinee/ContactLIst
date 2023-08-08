package com.phone.contactlist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.phone.contactlist.AddContact
import com.phone.contactlist.databinding.ActivityMainBinding
import com.phone.contactlist.model.ContactData
import com.phone.contactlist.ui.ContactAdapter
import com.phone.contactlist.viewModel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts().observe(this, Observer { contList-> displayContacts(contList) })
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddContact::class.java)
            startActivity(intent)
        }
    }
     fun displayContacts(contList:List<ContactData>){
        val tvAdapter= ContactAdapter(contList,this)
        binding.rvNames.layoutManager=LinearLayoutManager(this)
        binding.rvNames.adapter=tvAdapter
    }
}

