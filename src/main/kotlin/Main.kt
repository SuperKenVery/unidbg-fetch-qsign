import ch.qos.logback.classic.Logger
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import moe.fuqiuluo.api.configIndex
import moe.fuqiuluo.comm.invoke
import moe.fuqiuluo.ext.toInt

fun main(args: Array<String>) {
    var port = 0

    args().also {
        port = it["port", "Not init server.port."]
            .toInt(1 .. 65535) { "Port is out of range." }
    }

    embeddedServer(Netty, port = port, module = Application::init)
        .start(wait = true)
}

fun Application.init() {

    routing {
        configIndex()

    }
}