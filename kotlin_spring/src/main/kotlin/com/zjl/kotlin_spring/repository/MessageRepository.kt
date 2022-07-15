package com.zjl.kotlin_spring.repository

import com.zjl.kotlin_spring.Message
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * @className MessageRepository
 * @descrption TODO
 * @date 2022/7/15 14:18
 * @author zhou
 */
interface MessageRepository : CrudRepository<Message,String>{

    @Query("select * from messages",nativeQuery = true)
    fun findMessages(): List<Message>
}