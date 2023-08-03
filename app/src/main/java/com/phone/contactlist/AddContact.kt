package com.phone.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.phone.contactlist.databinding.ActivityAddContactBinding
import com.phone.contactlist.model.ContactData
import com.phone.contactlist.ui.MainActivity
import com.phone.contactlist.viewModel.ContactsViewModel

class AddContact : AppCompatActivity() {
    lateinit var binding:ActivityAddContactBinding
    private val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnAddcontact.setOnClickListener {
            validateAdd()
//            clearError()
        }
    }

    fun validateAdd(){
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (name.isBlank()){
            binding.tilName.error = "Enter name"
            error = true
        }
        if (phone.isBlank()){
            binding.tilPhone.error = "Enter Phone number"
            error = true
        }

        if (email.isBlank()){
            binding.tilEmail.error = "Enter email adress"
            error = true
        }

        if(!error){
            val newContact=ContactData(0,name,email,phone,"")
            contactsViewModel.saveContact(newContact)
            Toast.makeText(this,"Contact added successfully", Toast.LENGTH_LONG).show()
            finish()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

//    fun clearError(){
//        binding.tilName.error = null
//        binding.tilPhone.error = null
//        binding.tilEmail.error = null
//    }
}




