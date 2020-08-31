package by.dm13y.example.logging.logging.config

import mu.KotlinLogging
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class RequestLoggingInterceptorConfig: WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(RequestLoggingInterceptor())
    }
}

class RequestLoggingInterceptor: HandlerInterceptorAdapter() {
    private val log = KotlinLogging.logger {}

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        log.info { "------> ${buildRequestDetailsLog(request)}" }
        request.setAttribute(REQUEST_START_TIME_ATTRIBUTE, System.currentTimeMillis())
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        val requestTime = request.getAttribute(REQUEST_START_TIME_ATTRIBUTE) as Long
        val responseTime = System.currentTimeMillis() - requestTime
        val msg = "<------ ${request.protocol} ${response.status} (${responseTime}ms)"
        when {
            (responseTime < RESPONSE_MAX_NORMAL_TIME) -> log.info { msg }
            (responseTime < RESPONSE_MAX_WARN_TIME) -> log.warn { msg }
            else -> log.error { msg }
        }
    }

    private fun buildRequestDetailsLog(request: HttpServletRequest): String {
        return "${request.method} ${request.requestURI} ${request.queryString.orEmpty()}"
    }

    companion object {
        const val REQUEST_START_TIME_ATTRIBUTE = "startTime"
        const val RESPONSE_MAX_NORMAL_TIME = 300
        const val RESPONSE_MAX_WARN_TIME = 1000
    }
}