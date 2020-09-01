package by.dm13y.example.logging.logging.helpers

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

const val REQUEST_START_TIME_ATTRIBUTE = "startTime"
const val RESPONSE_MAX_NORMAL_TIME = 300
const val RESPONSE_MAX_WARN_TIME = 1000
private val log = KotlinLogging.logger {}

fun HttpServletRequest.logInfo() {
    this.setAttribute(REQUEST_START_TIME_ATTRIBUTE, System.currentTimeMillis())
    log.info { "------> ${this.method} ${this.requestURI} ${this.queryString.orEmpty()}" }
}

fun HttpServletResponse.logInfo(request: HttpServletRequest, httpStatus: HttpStatus? = null) {
    val requestTime = request.getAttribute(REQUEST_START_TIME_ATTRIBUTE) as Long
    val responseTime = System.currentTimeMillis() - requestTime
    val status = httpStatus ?: this.status
    val msg = "<------ ${request.protocol} $status (${responseTime}ms)"
    when {
        (responseTime < RESPONSE_MAX_NORMAL_TIME) -> log.info { msg }
        (responseTime < RESPONSE_MAX_WARN_TIME) -> log.warn { msg }
        else -> log.error { msg }
    }
}
