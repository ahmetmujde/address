package com.cloudsoftware.address.exception;

import com.cloudsoftware.address.dto.response.ErrorResponse;
import com.cloudsoftware.address.exception.customexception.CityAlreadyExistException;
import com.cloudsoftware.address.exception.customexception.CountryAlreadyExistException;
import com.cloudsoftware.address.exception.customexception.CountryNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class AddressExceptionHandler {

    @ExceptionHandler(value = {CountryAlreadyExistException.class})
    public ResponseEntity<ErrorResponse> handeCountryAlreadyExistException(CountryAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception.getMessage());
        return ResponseEntity.of(Optional.of(errorResponse));
    }

    @ExceptionHandler(value = {CountryNotFoundException.class})
    public ResponseEntity<ErrorResponse> handeCountryNotFoundException(CountryNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception.getMessage());
        return ResponseEntity.of(Optional.of(errorResponse));
    }

    @ExceptionHandler(value = {CityAlreadyExistException.class})
    public ResponseEntity<ErrorResponse> handeCityAlreadyExistException(CityAlreadyExistException exception){
        ErrorResponse errorResponse = ErrorResponse.create(exception.getMessage());
        return  ResponseEntity.of(Optional.of(errorResponse));
    }
}
