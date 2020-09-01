package by.dm13y.example.logging.logging.model.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class GeoCatalogCityDto(
    var id: String? = null,
    var name: String? = null,
    var region: String? = null
)
