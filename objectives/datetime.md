#### Instance creation for java.time classes
##### LocalDate  
```
LocalDate.now();
LocalDate.of(2020,6,3);
LocaLDate.parse("2020-06-03");
```
##### LocalTime  
```
LocalTime.now();
LocalTime.of(16,22,03);
LocalTime.parse("16:22:03");
```
##### LocalDateTime
```
LocalDateTime.now();
LocalDateTime.of(aDate, aTime);
LocalDateTime.parse("2020-06-03T16:22:03");
LocalDateTime.parse(aDateTime, aFormatter);
```
##### ZonedDateTime
```
ZonedDateTime.now();
ZonedDateTime.of(aDateTime, ZoneId.of(aZoneString));
ZonedDateTime.parse("2020-06-03T16:22:03+02:00");

```
##### format.DateTimeFormatter
```
DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(aLocale);
```
##### Instant
```
Instant.now()
aZonedDateTime.toInstant();
aDateTime.toInstant(ZoneOffset.of(+2));
```
##### Duration
```
Duration.between(aTime1, aTime2);
Duration.ofMinutes(5);
```
##### Period
```
Period.between(aDate1, aDate2);
Period.ofDays(5);
```
##### util.Locale
```
Locale.getDefault();
new Locale(String language);
new Locale(String language, String country);
```
