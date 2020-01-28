package edu.uph.ii.platformy.controllers.commands;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;


public class TerminarzFilter {

    private Date data;

    public boolean isEmpty(){
        return StringUtils.isEmpty(data);
    }

    public void clear(){
        this.data = null;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
