package by.dm13y.example.logging.logging.exception

import by.dm13y.example.logging.logging.helpers.logInfo
import by.dm13y.example.logging.logging.model.dto.ErrorDto
import feign.FeignException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ExceptionAdvice {

    private val log = KotlinLogging.logger {}

    @ExceptionHandler(FeignException::class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    fun handleUnknown(request: HttpServletRequest, response: HttpServletResponse, exception: FeignException): ErrorDto {
        log.error("Integration error. Error: ${exception.message}", exception)
        response.logInfo(request, HttpStatus.UNPROCESSABLE_ENTITY)
        return ErrorDto(HttpStatus.UNPROCESSABLE_ENTITY.value())
    }
}
