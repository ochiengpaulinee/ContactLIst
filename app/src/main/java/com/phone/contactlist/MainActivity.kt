package com.phone.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.phone.contactlist.databinding.ActivityMainBinding
import com.phone.contactlist.databinding.ContactListItemBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayContacts()
    }
    private fun displayContacts(){
        val contact1=ContactData("","Pauline","072345145","pauline@gmail.com")
        val contact2=ContactData("","Brenda","072145642","brenda@gmail.com")
        val contact3=ContactData("","Victoria","0712421451","vicky@gmail.com")
        val contact4=ContactData("","Brian","0732412126","brian@gmail.com")
        val contact5=ContactData("","Victor","0712514215464","victor@gmail.com")
        val contact6=ContactData("","Bahati","0721432542","fred@gmail.com")
        val contact7=ContactData("","Collins","0715435632","collins@gmail.com")
        val contList= listOf(contact1,contact2,contact3,contact4,contact5,contact6,contact7)
        val tvAdapter=ContactAdapter(contList)
        binding.rvNames.layoutManager=LinearLayoutManager(this)
        binding.rvNames.adapter=tvAdapter
    }
}








