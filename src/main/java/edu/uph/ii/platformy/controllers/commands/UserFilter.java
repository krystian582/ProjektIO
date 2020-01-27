package edu.uph.ii.platformy.controllers.commands;

import org.springframework.util.StringUtils;

import javax.validation.constraints.PositiveOrZero;

public class UserFilter {

    private String pesel;

    public boolean isEmpty(){
        return StringUtils.isEmpty(pesel);
    }

    public void clear(){
        this.pesel = "";
    }

    public String getPhraseLIKE(){
        if(StringUtils.isEmpty(pesel)) {
            return null;
        }else{
            return "%"+pesel+"%";
        }
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
