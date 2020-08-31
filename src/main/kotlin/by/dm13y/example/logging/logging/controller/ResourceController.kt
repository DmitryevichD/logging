package by.dm13y.example.logging.logging.controller

import by.dm13y.example.logging.logging.model.dto.ResourceDto
import by.dm13y.example.logging.logging.service.ResourceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/resource/logging")
class ResourceController(
    private val resoureService: ResourceService
) {
    @GetMapping("/platform/valid")
    fun getValidPlatformResource(): ResourceDto {
        return resoureService.getPlatformValidResource()
    }

    @GetMapping("/platform/invalid")
    fun getInvalidPlatformResource(): ResourceDto {
        return resoureService.getPlatformInvalidResource()
    }

    @GetMapping("/platform/unknown")
    fun getUnknownPlatformResource(): ResourceDto {
        return resoureService.getPlatformValidResource()
    }

    @GetMapping("/external/valid")
    fun getValidExternalResource(): ResourceDto {
        return resoureService.getExternalValidResource()
    }

    @GetMapping("/external/invalid")
    fun getInvalidExternalResource(): ResourceDto {
        return resoureService.getExternalInvalidResource()
    }

    @GetMapping("/external/unknown")
    fun getUnknownExternalResource(): ResourceDto {
        return resoureService.getEternalUnknownResource()
    }
}
