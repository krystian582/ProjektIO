package edu.uph.ii.platformy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such item")
public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(String.format("Item nie istnieje"));
    }

    public NotFoundException(Long id){
        super(String.format("Item o id %d nie istnieje", id));
    }
}
