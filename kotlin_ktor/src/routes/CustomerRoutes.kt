package com.zjl.routes

import com.zjl.models.Customer
import com.zjl.models.customerStorage
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*

fun Route.customerRouting() {
    route("/customer"){
        get {
            if (customerStorage.isNotEmpty()){
                call.respond(customerStorage)
            }else {
                call.respondText("No customers found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                    "Missing or malformed id",
                    status = HttpStatusCode.BadRequest
            )
            val customer =
                    customerStorage.find { it.id == id } ?: return@get call.respondText(
                            "No customer with id $id",
                            status = HttpStatusCode.NotFound
                    )
            call.respond(customer)
        }
        post {
            val customer = call.receive<Customer>()
            customerStorage.add(customer)
            call.respondText("Customer stored correctly",status = HttpStatusCode.Created)
        }
        delete("{id}"){
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if(customerStorage.removeIf { it.id == id}){
                call.respondText("Customer remove correctly",status = HttpStatusCode.Accepted)
            }else{
                call.respondText("Not Found",status = HttpStatusCode.NotFound)
            }
        }
    }
}


fun Application.registerCustomerRoutes(){
    routing { customerRouting() }
}