package com.cloudsoftware.address.exception.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CountryAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = -6779368627904392212L;

    public CountryAlreadyExistException() {
        super("İşlem yapmak istediğiniz ülke zaten bulunmaktadır!");
    }
}
