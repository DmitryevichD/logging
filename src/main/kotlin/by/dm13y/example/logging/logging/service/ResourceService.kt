package by.dm13y.example.logging.logging.service

import by.dm13y.example.logging.logging.model.dto.CityDto
import by.dm13y.example.logging.logging.model.dto.GeoCatalogCityDto
import by.dm13y.example.logging.logging.model.dto.ResourceDto

interface ResourceService {
    fun getPlatformValidResource(): ResourceDto
    fun getPlatformInvalidResource(): CityDto
    fun getPlatformUnknownResource(): ResourceDto
    fun getExternalValidResource(): List<GeoCatalogCityDto>
    fun getExternalInvalidResource(): ResourceDto
    fun getEternalUnknownResource(): ResourceDto
}
