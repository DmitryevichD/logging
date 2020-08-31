package by.dm13y.example.logging.logging.service.impl

import by.dm13y.example.logging.logging.api.PlatformApi
import by.dm13y.example.logging.logging.model.dto.ResourceDto
import by.dm13y.example.logging.logging.service.ResourceService
import org.springframework.stereotype.Service

@Service
class ResourceServiceImpl(
    private val platformApi: PlatformApi
) : ResourceService {
    override fun getPlatformValidResource(): ResourceDto {
        return platformApi.getValidCity().let {
            ResourceDto(it.id)
        }
    }

    override fun getPlatformInvalidResource(): ResourceDto {
        TODO("Not yet implemented")
    }

    override fun getPlatformUnknownResource(): ResourceDto {
        TODO("Not yet implemented")
    }

    override fun getExternalValidResource(): ResourceDto {
        TODO("Not yet implemented")
    }

    override fun getExternalInvalidResource(): ResourceDto {
        TODO("Not yet implemented")
    }

    override fun getEternalUnknownResource(): ResourceDto {
        TODO("Not yet implemented")
    }
}