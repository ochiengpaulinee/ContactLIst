package com.phone.contactlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.phone.contactlist.R
import com.phone.contactlist.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    var contactsId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var bundle = intent.extras
        if (bundle!=null){
            contactsId = bundle.getInt("CONTACT_ID",0)
            Toast.makeText(this,"$contactsId",Toast.LENGTH_LONG).show()
        }
    }
}