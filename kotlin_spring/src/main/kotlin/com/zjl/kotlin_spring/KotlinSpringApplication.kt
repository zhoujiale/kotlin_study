package com.zjl.kotlin_spring

import com.zjl.kotlin_spring.service.MessageService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.persistence.*

@SpringBootApplication
class KotlinSpringApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringApplication>(*args)
}
@Entity
@Table(name = "messages")
data class Message(@Id val id: String = "1", val text: String = "1")


@RestController
class MessageResource(val service: MessageService){

    @GetMapping
    fun index(): List<Message> = service.findMessage()

    @PostMapping
    fun post(@RequestBody message: Message){
        service.post(message)
    }
}