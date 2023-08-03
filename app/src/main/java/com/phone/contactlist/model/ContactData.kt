package com.phone.contactlist.model
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class ContactData(
    @PrimaryKey(autoGenerate = true) @NonNull
    var contactId: Int,
    var avatar:String?,
    var name:String,
    var phone:String,
    var email:String
)


