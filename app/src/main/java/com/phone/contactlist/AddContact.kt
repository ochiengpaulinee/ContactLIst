package com.phone.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.phone.contactlist.databinding.ActivityAddContactBinding

class AddContact : AppCompatActivity() {
    lateinit var binding:ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnAddcontact.setOnClickListener {
            validateAdd()
            clearError()
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
            Toast.makeText(this,"Contact added successfully", Toast.LENGTH_LONG)
                .show()
        }

    }

    fun clearError(){
        binding.tilName.error = null
        binding.tilPhone.error = null
        binding.tilEmail.error = null
    }
}




