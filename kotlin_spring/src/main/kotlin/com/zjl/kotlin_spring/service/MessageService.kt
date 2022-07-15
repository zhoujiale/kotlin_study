package com.zjl.kotlin_spring.service

import com.zjl.kotlin_spring.Message
import com.zjl.kotlin_spring.repository.MessageRepository
import org.springframework.stereotype.Service

/**
 * @className MessageService
 * @descrption TODO
 * @date 2022/7/15 14:22
 * @author zhou
 */
@Service
class MessageService (val db: MessageRepository){

    fun findMessage(): List<Message> = db.findMessages()

    fun post(message: Message){
        db.save(message)
    }
}