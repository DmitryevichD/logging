package by.dm13y.example.logging.logging.api

import by.dm13y.example.logging.logging.model.dto.CityDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Api for internal platform services
 */
@FeignClient(name = "inner-service-city", url = "https://openbank.demohoster.com")
interface PlatformApi {

    @GetMapping("/api/public/cities/{kladrId}")
    fun getValidCity(@PathVariable(name = "kladrId") kladrId: String = "1900000100000"): CityDto

    @GetMapping("/api/public/cities/{kladrId}")
    fun getInvalidCity(@PathVariable(name = "kladrId") kladrId: String = "asdfsasdfsdf"): CityDto

    @GetMapping("/api/public/cities/some-url")
    fun getUnknownUrl(): CityDto
}
