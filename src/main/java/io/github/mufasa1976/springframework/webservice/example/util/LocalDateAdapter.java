package io.github.mufasa1976.springframework.webservice.example.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class LocalDateAdapter {

  public static LocalDate unmarshal(String xmlGregorianCalendar) {
    return Optional.ofNullable(xmlGregorianCalendar)
        .map(DateTimeFormatter.ISO_DATE::parse)
        .map(LocalDate::from)
        .orElse(null);
  }

  public static String marshal(LocalDate localDate) {
    return Optional.ofNullable(localDate)
        .map(DateTimeFormatter.ISO_DATE::format)
        .orElse(null);
  }

  public static void main(String... args) {
    log.info("LocalDateTime of String {}: {}", "1976-03-03", unmarshal("1976-03-03"));
  }
}
