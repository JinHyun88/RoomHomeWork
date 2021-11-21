package com.example.roomhomeworkdefaultrepo.listener

import com.example.roomhomeworkdefaultrepo.database.Memo

interface OnItemClick {
    fun deleteMemo(memo : Memo)
}
