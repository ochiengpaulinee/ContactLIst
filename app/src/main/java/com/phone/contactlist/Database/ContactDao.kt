package com.phone.contactlist.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.phone.contactlist.model.ContactData
import java.sql.RowId

@Dao
interface ContactDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun insertContact(contact: ContactData)

    @Query("SELECT * FROM Contacts ORDER BY name")
    fun getAllContacts():LiveData<List<ContactData>>

    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
    fun getContactById(contactId: Int):LiveData<ContactData>
}
