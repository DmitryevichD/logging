package by.dm13y.example.logging.logging.config

import feign.RequestInterceptor
import feign.RequestTemplate

class RequestFeignInterceptorConfig: RequestInterceptor {
    override fun apply(template: RequestTemplate) {
//        TODO()
    }

    companion object {
        const val SHOW_BODY_HEADER = "X-Show-Body"
    }
}