package me.evercx.utils;
import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {

    public Date convert(String source){

        if(source == null){
            throw new RuntimeException("null data");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            throw  new RuntimeException("error");
        }
    }
}

