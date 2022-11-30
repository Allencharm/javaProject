package com.blog.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/3 15:05
 * @Description:
 */
//自定义日期类型转换器
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
