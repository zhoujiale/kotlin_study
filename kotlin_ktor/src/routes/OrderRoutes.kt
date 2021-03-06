package com.zjl.routes

import com.zjl.models.orderStorage
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing

/**
 * @className OrdeRoutes
 * @descrption TODO
 * @date 2022/7/18 13:48
 * @author zhou
 */
fun Route.listOrdersRoute() {
    get("/order") {
        if(orderStorage.isNotEmpty()){
            call.respond(orderStorage)
        }
    }
}

fun Route.getOrderRoute(){
    get("/order/{id}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request",status = HttpStatusCode.BadRequest)
        val order = orderStorage.find { it.number == id }?: return@get call.respondText(
            "Not Found",
                status = HttpStatusCode.NotFound
        )
       call.respond(order)
    }
}
//
//fun Route.totalizeOrderRoute(){
//    get("/order/{id}/total"){
//        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request",status = HttpStatusCode.BadRequest)
//        val order = orderStorage.find { it.number == id }?: return@get call.respondText(
//                "Not Found",
//                status = HttpStatusCode.NotFound
//        )
//        val total = order.contents.map { it.price * it.amount }
//    }
//}

fun Application.registerOrderRoutes() {
    routing {
        listOrdersRoute()
        getOrderRoute()
    }
}