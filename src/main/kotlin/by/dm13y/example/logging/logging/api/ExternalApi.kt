package by.dm13y.example.logging.logging.api

import by.dm13y.example.logging.logging.model.dto.CityDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Api for external platform services
 */
@FeignClient(name = "external-service-city", url = "https://openbank.demohoster.com")
@RequestMapping(value = ["/"], headers = ["sfsdfsdfsdf"])
interface ExternalApi {

    @GetMapping("/api/public/cities/{kladrId}", headers = ["Test: Test"])
    fun getValidCity(@PathVariable(name = "kladrId") kladrId: String = "1900000100000"): CityDto

    @GetMapping("/api/public/cities/{kladrId}", headers = ["Test: Test"])
    fun getInvalidCity(@PathVariable(name = "kladrId") kladrId: String = "0000000100000"): CityDto

    @GetMapping("/api/public/cities/some-url", headers = ["Test: Test"])
    fun getUnknownUrl(): CityDto
}
