package io.github.mufasa1976.springframework.webservice.example.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class LocalDateAdapter {

  public static LocalDateTime unmarshal(String xmlGregorianCalendar) {
    return Optional.ofNullable(xmlGregorianCalendar)
        .map(DateTimeFormatter.ISO_DATE_TIME::parse)
        .map(LocalDateTime::from)
        .orElse(null);
  }

  public static String marshal(LocalDateTime localDateTime) {
    return Optional.ofNullable(localDateTime)
        .map(DateTimeFormatter.ISO_DATE_TIME::format)
        .orElse(null);
  }
}
