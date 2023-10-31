package com.smu.smartspend.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Date;
import java.time.YearMonth;
import java.time.YearMonth;
import java.sql.Date;

@Converter(autoApply = true)
public class YearMonthAttributeConverter implements AttributeConverter<YearMonth, Date> {

    @Override
    public Date convertToDatabaseColumn(YearMonth yearMonth) {
        if (yearMonth != null) {
            return Date.valueOf(yearMonth.atDay(1));
        }
        return null;
    }

    @Override
    public YearMonth convertToEntityAttribute(Date date) {
        if (date != null) {
            return YearMonth.from(date.toLocalDate());
        }
        return null;
    }
}
