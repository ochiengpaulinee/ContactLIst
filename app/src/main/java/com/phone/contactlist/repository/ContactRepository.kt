package com.phone.contactlist.repository

import androidx.lifecycle.LiveData
import com.phone.contactlist.Database.ContactDB
import com.phone.contactlist.MyContactsApp
import com.phone.contactlist.model.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository {
    private val database = ContactDB.getDatabase(MyContactsApp.appContext)

    suspend fun saveContact(contact: ContactData) {
        withContext(Dispatchers.IO) {
            database.getContactDao().insertContact(contact)
        }
    }

    fun getAllContacts():LiveData<List<ContactData>>{
        return database.getContactDao().getAllContacts()
    }
    fun getContactById(contactId:Int):LiveData<ContactData>{
        return database.getContactDao().getContactById(contactId)
    }
}