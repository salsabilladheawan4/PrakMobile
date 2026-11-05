package com.example.saturnus_salsa.message

data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarUrl: String,
    val timeOrAge: String // Parameter ke-4 yang baru ditambahkan ("25")
)