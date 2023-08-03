package com.phone.contactlist.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.phone.contactlist.model.ContactData

@Dao
interface ContactDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun insertContact(contact: ContactData)
}