package com.phone.contactlist.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phone.contactlist.model.ContactData
import com.phone.contactlist.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    val contactsRepo= ContactRepository()

    fun saveContact(contact: ContactData){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }

    fun getContacts():LiveData<List<ContactData>>{
        return contactsRepo.getAllContacts()
    }
    fun getContactsById(contactId:Int):LiveData<ContactData>{
        return contactsRepo.getContactById(contactId)
    }
}