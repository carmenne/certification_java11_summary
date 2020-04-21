#### [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)

Different get methods: getYear, getMonth, getDayOfMonth or get that receives a [TemporalField](https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalField.html)
ChronoField enumeration implements TemporalField interface.

A date can be created:
- using a Factory method (of):
```
LocalDate.of(2014, 3, 18);
```
- by parsing a String:
```
LocalDate.parse("2014-03-18");
```
It is also possible to pass a [DateTimeFormatter](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html);

#### [LocalTime](https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html)

LocalTime is similar to LocalDate and can be create using both factory method (of) and parse.
```
LocalTime.of(13, 45, 20); // h=13, m=45, s=20
LocalTIme.parse("13:45:20");

```
#### Combining Date and Time. [LocalDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html)
```
LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
```
LocalDateTime can also be created by passing a time to LocalDate (atTime) or passing a date to LocalTime (atDate).
You can also extract LocalDate or LocalTime component from a LocalDateTime using toLocalDate or toLocalTime methods.

#### [Instant]: 
A date and time for machines - represents the number of seconds passed since the Unix epoch time: the midnight of January 1, 1970 UTC.
It can be created:
- by passing the number of seconds to the static factory method `ofEpochSecond`
- by passgin the number of seconds and the nanoseconds adjustments to an overloaded method `ofEpochSecond`

The following invocations Instant.ofEpochSecond will return exactly the same invocation:
```
Instant.ofEpochSecond(3);
Instant.ofEpochSecond(3, 0);
Instant.ofEpochSecond(2, 1_000_000_000);
Instant.ofEpochSecond(4, -1_000_000_000);
```
Instant also supports the method now.
It is important to state that Instant is intended for use only by a mchine. It consists of a number of seconds and nanoseconds. In consequence, the statement Instant.now().get(ChronoField.DAY_OF_MONTH) whill just throw UnsupportedTemporalTypeExcpetion.</br>
You can work with instant using Period and Duration

LocalDate, LocalTime and LocalDateTime implement the Temporal interface which defines how to read a point in time.

#### [Duration]
Is the duration between two temporal objects. The `between` static factory method of the Duration class is used two creation a duration between two LocalTimes, two LocalDateTimes or two Instants objects as follow:

```
Duration.between(time1, time2);
Duration.between(dateTime1, dateTime2);
Duration.between(instant1, instant2);
```
Because LocalDateTime (LocalTime) are designed for humand and Instant is desinged for machines, you cannot mix them in the `Duration.between` method. </br>
Because Duration is designed to express an amount of time in seconds and eventually in nanoseconds, you can't pass a LocalDate method to `Duration.between` either. Period can be used for expressing an amount of time in terms of years, months and days.

#### [Period]
You can find the difference between two LocalDates wiht the between factory method of the Period class.
```
Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
```

Both Duration and Period have other convenient static methods to create instances of them directly withouth defining them as the difference between two temporal objects.
```
Duration threeMinutes = Duration.ofMinutes(3);
Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
Period tenDays = Period.ofDays(10);
Period threeWeeks = Period.ofWeeks(3);
Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
```

#### Common methods of date-time classes representing an interval
|Method|Static|Description|
|-------------|-------------|-----|
|between|yes||
|from|yes||
|of|yes||
|parse|yes||
|addTo|no||
|get|no||
|isNegative|no||
|isZero|no||
|minus|no||
|multipledBy|no||
|negated|no||
|plus|no||
|substractFrom|no||
