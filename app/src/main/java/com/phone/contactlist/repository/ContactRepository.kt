package com.phone.contactlist.repository

import com.phone.contactlist.Database.ContactDB
import com.phone.contactlist.MyContactsApp
import com.phone.contactlist.model.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository {
    val database = ContactDB.getDatabase(MyContactsApp.appContext)

    suspend fun saveContact(contact: ContactData) {
        withContext(Dispatchers.IO) {
            database.getContactDao().insertContact(contact)
        }
    }
}