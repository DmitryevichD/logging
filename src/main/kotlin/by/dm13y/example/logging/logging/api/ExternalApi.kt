package by.dm13y.example.logging.logging.api

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Api for external platform services
 */
@FeignClient(name = "inner-service-city", url = "https://openbank.demohoster.com")
interface ExternalApi {

    @GetMapping("/api/public/cities/{kladrId}")
    fun getValidCity(@PathVariable(name = "kladrId") kladrId: String = "1900000100000")

    @GetMapping("/api/public/cities/{kladrId}")
    fun getInvalidCity(@PathVariable(name = "kladrId") kladrId: String = "0000000100000")

    @GetMapping("/api/public/cities/some-url")
    fun getUnknownUrl()
}