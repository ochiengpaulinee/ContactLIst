package com.phone.contactlist.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.phone.contactlist.model.ContactData


@Database(entities = arrayOf(ContactData::class), version = 1)
abstract class ContactDB: RoomDatabase() {
    abstract fun getContactDao():ContactDao

    companion object{
        private var database:ContactDB?=null

        fun getDatabase(context: Context):ContactDB{
            if(database==null){
                database= Room.databaseBuilder(context,ContactDB::class.java,"ContactsDB")
                    .build()
            }
            return database as ContactDB
        }
    }
}