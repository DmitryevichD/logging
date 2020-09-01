package by.dm13y.example.logging.logging.service.impl

import by.dm13y.example.logging.logging.api.ExternalApi
import by.dm13y.example.logging.logging.api.PlatformApi
import by.dm13y.example.logging.logging.model.dto.CityDto
import by.dm13y.example.logging.logging.model.dto.GeoCatalogCityDto
import by.dm13y.example.logging.logging.model.dto.ResourceDto
import by.dm13y.example.logging.logging.model.dto.SearchDto
import by.dm13y.example.logging.logging.service.ResourceService
import org.springframework.stereotype.Service

@Service
class ResourceServiceImpl(
    private val platformApi: PlatformApi,
    private val externalApi: ExternalApi
) : ResourceService {
    override fun getPlatformValidResource(): ResourceDto {
        return platformApi.getValidCity().let {
            ResourceDto(it.id)
        }
    }

    override fun getPlatformInvalidResource(): CityDto {
        return platformApi.getInvalidCity()
    }

    override fun getPlatformUnknownResource(): ResourceDto {
        TODO("Not yet implemented")
    }

    override fun getExternalValidResource(): List<GeoCatalogCityDto> {
        val searchDto = SearchDto("courier", "Москва")
        return externalApi.searchCity(searchDto)
    }

    override fun getExternalInvalidResource(): ResourceDto {
        TODO("Not yet implemented")
    }

    override fun getEternalUnknownResource(): ResourceDto {
        TODO("Not yet implemented")
    }
}