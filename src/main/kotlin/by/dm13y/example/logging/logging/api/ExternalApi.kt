package by.dm13y.example.logging.logging.api

import by.dm13y.example.logging.logging.model.dto.SearchDto
import by.dm13y.example.logging.logging.model.dto.CityDto
import by.dm13y.example.logging.logging.model.dto.GeoCatalogCityDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

/**
 * Api for external platform services
 */
@FeignClient(name = "external-service-city", url = "https://openbank.demohoster.com")
interface ExternalApi {

    @PostMapping("/api/public/geo-catalog/v1/cities")
    fun searchCity(searchDto: SearchDto): List<GeoCatalogCityDto>

    @GetMapping("/api/public/cities/{kladrId}")
    fun getInvalidCity(@PathVariable(name = "kladrId") kladrId: String = "0000000100000"): CityDto

    @GetMapping("/api/public/cities/some-url")
    fun getUnknownUrl(): CityDto
}
