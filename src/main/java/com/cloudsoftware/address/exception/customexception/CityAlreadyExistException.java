package com.cloudsoftware.address.exception.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CityAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = -6622819639213908191L;

    public CityAlreadyExistException() {
        super("İşlem yapmak istediğiniz sehir zaten bulunmaktadır!");
    }
}
