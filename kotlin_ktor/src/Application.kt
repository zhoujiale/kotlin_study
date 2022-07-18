package com.zjl

import com.zjl.routes.*
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.serialization.json
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
fun main(){
    embeddedServer(Netty,port = 8080,configure = {
        connectionGroupSize = 2
    }){
        routing {
            get("/"){
                call.respondText("Hello,world")
            }
        }
    }.start(wait = true)
}
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
        install(ContentNegotiation){
            json()
        }
        registerCustomerRoutes()
        registerOrderRoutes()
    }
}


