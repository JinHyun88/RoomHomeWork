package com.example.roomhomeworkdefaultrepo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class Memo(
    var title : String,
    var content : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}
