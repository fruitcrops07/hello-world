package com.fimc.hello.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fimc.hello.exception.InvalidDateformatException;

public class DateHelper {

    public static Date parse(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String[] slicedDate = dateString.split("-");
        if (slicedDate.length != 3)
            throw new InvalidDateformatException("Invalid date format");
        if (slicedDate[0].length() != 2 || slicedDate[1].length() != 2 || slicedDate[2].length() != 4) {
            throw new InvalidDateformatException("Invalid date format");
        }
        return formatter.parse(dateString);
    }
}
