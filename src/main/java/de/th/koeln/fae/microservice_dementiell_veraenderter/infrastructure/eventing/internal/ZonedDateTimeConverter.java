package de.th.koeln.fae.microservice_dementiell_veraenderter.infrastructure.eventing.internal;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime entityValue) {
       return Timestamp.from(entityValue.toInstant());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp databaseValue) {
        LocalDateTime localDateTime = databaseValue.toLocalDateTime();
        return localDateTime.atZone(ZoneId.systemDefault());
    }

}