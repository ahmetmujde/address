package com.cloudsoftware.address.exception.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CountryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2929235773694388439L;

    public CountryNotFoundException() {
        super("İşlem yapmak istediğiniz ülke bulunamadı!");
    }
}
