package moe.fuqiuluo.api

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class APIResult<T>(val code: Int,
                        val msg: String = "",
                        @Contextual
                        val data: T? = null)

fun Routing.index() {
    get("/") {
        call.respondTextWriter {
            write("IAA 云天明\n")
            write("Time: ")
            write(System.currentTimeMillis().toString())
        }
    }
}
