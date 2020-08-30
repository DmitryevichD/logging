package by.dm13y.example.logging.logging.service

import by.dm13y.example.logging.logging.model.dto.ResourceDto

interface ResourceService {
    fun getPlatformValidResource(): ResourceDto
    fun getPlatformInvalidResource(): ResourceDto
    fun getPlatformUnknownResource(): ResourceDto
    fun getExternalValidResource(): ResourceDto
    fun getExternalInvalidResource(): ResourceDto
    fun getEternalUnknownResource(): ResourceDto
}
