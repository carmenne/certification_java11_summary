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

#### [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)
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

#### [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html)
Is the duration between two temporal objects. The `between` static factory method of the Duration class is used two creation a duration between two LocalTimes, two LocalDateTimes or two Instants objects as follow:

```
Duration.between(time1, time2);
Duration.between(dateTime1, dateTime2);
Duration.between(instant1, instant2);
```
Because LocalDateTime (LocalTime) are designed for humand and Instant is desinged for machines, you cannot mix them in the `Duration.between` method. </br>
Because Duration is designed to express an amount of time in seconds and eventually in nanoseconds, you can't pass a LocalDate method to `Duration.between` either. Period can be used for expressing an amount of time in terms of years, months and days.

#### [Period](https://docs.oracle.com/javase/8/docs/api/java/time/Period.html)
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

##### Common methods of date-time classes representing an interval
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

##### Common methods of date-time classes representing a point in time
|Method|Static|Description|
|-------------|-------------|----|
|from|Yes| Creates an instance of this class from the passed temporal object|
|now|Yes| Creates a temporal object from the system clock|
|of|Yes| Creates an instance of this temporal object from its constituent parts|
|parse|Yes| Creates an instance of this temporal object from a String|
|atOffset|No|Combines this temporal object with a zone offset|
|atZone|No|Combines this temporal object with a time zone|
|format|No|Converts this temporal object into a String using the specified formatter (not available for Instant)|
|get|No|Reads part of the state of this temporal object|
|minus|No|Creates a copy of this temporal object with an amount of time subtracted|
|plus|No|Creates a copy of this temporal object with an amount of time added|
|with|No|Creates a copy of this temporal object with part of the state changed|


#### Complex date time manipulation ([TemporalAdjuster](https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjuster.html))
Complex data manipulations can be done with predefined TemporalAdjusters (static methods in [java.time.temporal.TemporalAsjusters](https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjuster.html)) or you can provide your own implementation. Actually TemporalAdjuster is a functional interface.
```
Temporal adjustInto(Temporal temporal)
```

Use of predefined TemporalAdjusters
```
import static java.time.temporal.TemporalAdjusters.*;
LocalDate date1 = LocalDate.of(2014, 3, 18); // 18-03-2014
var date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY)); // 23-03-2014
var date3 = date2.with(lastDayOfMonth()); // 31-03-2014
```

##### The factory methods of the TemporalAdjusters class

|Method|Description|
|-------------|-------------|
|dayOfWeekInMonth|Creates a new date in the same month with the ordinal day of week  |
|firstDayOfMonth|Creates a new date set to the first day of the current month   |
|firstDayOfNextMonth|Creates a new date set to the first day of the next month   |
|firstDayOfNextYear|Creates a new date set to the first day of the next year   |
|firstDayOfYear|Creates a new date set to the first day of the current year   |
|firstInMonth|Creates a new date in the same month with the first matching day of week |
|lastDayOfMonth|Creates a new date set to the last day of the current month   |
|lastDayOfNextMonth|Creates a new date set to the last day of the next month   |
|lastDayOfNextYear|Creates a new date set to the last day of the next year   |
|lastDayOfYear|Creates a new date set to the last day of the current year   |
|lastInMonth|Creates a new date in the same month with the last matching day of week |
|next </br>  previous|Creates a new date set to the first occurrence of the specified day of week after/before the date being adjusted|
|nextOrSame </br> previousOrSame| Creates a new date set to the first occurrence of the specified day of week after/before the date being adjusted unless it’s already on that day, in which case the same object is returned|

#### Working with different time zones and calendars
A time zone is a set of rules corresponding to a region in which the standard time is the same.
There are about 40 of them held in instances of the [ZoneRules](https://docs.oracle.com/javase/8/docs/api/java/time/zone/ZoneRules.html) class. You can simply call
getRules() on a ZoneId to obtain the rules for that given time zone. A specific ZoneId is
identified by a region ID, for example:
```
ZoneId romeZone = ZoneId.of("Europe/Rome");
```
The region IDs are all in the format “{area}/{city}” and the set of available locations is the one
supplied by the IANA Time Zone Database. You can also convert an old TimeZone object to a
ZoneId by using the new method toZoneId:
```
ZoneId zoneId = TimeZone.getDefault().toZoneId();
```

Once you have a ZoneId object, you can combine it with a LocalDate, a LocalDateTime, or an
Instant, to transform it into ZonedDateTime instances, which represent points in time relative
to the specified time zone
```
LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
ZondeDateTime zdt2 = dateTime.atZone(romeZone);

Instant instant = Instant.now();
ZonedDateTime zdt3 = instant.atZone(romeZone);
```

##### Convert from a LocalDateTime to an Instant using ZoneId
```
LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45); // 2014-03-18T13:45
localDateTime.toInstant(ZoneOffset.of("+02:00")); //  2014-03-18T11:45:00Z

```
Instant represents time at UTC. It is not adjusted for the timeZone. LocalDateTime is the UTC time adjusted for the timeZone.

#### Fixed offset from UTC/Greenwich
FixedOffset can be retrieved via `ZoneOffset.of("+02:00")` corresponding to `ZoneId.of("Europe/Amsterdam")` when it is summer time.
A ZoneOffset defined in this way does not have Daylight Saving Time management, and for this reason it is not suggested in the majority of casses.
[ZoneOffset](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html) extands [ZoneId](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html)

```
LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
OffsetDateTime dateTimeAmsterdam = OffsetDateTime.of(dateTime, ZoneOffset.of("+02:00"))
```
#### using alternative calendar systems
You can create any Temporal instance from their `from` static method as below:
```
LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
JapaneseDate japaneseDate = JapaneseDate.from(date);
```

Alternatively, you can explicitly create a calendar system for a specific Locale and create an
instance of a date for that Locale.
```
Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
ChronoLocalDate now = japaneseChronology.dateNow();
```

The designers of the Date and Time API advise using LocalDate instead of Chrono-LocalDate for
most cases; this is because a developer could make assumptions in their code that unfortunately
aren’t true in a multicalendar system. Such assumptions might include that the value of a day or
month will never be higher than 31, that a year contains 12 months, or even that a year has a
fixed number of months. For these reasons, it’s recommended to use LocalDate throughout your
application, including all storage, manipulation, and interpretation of business rules, whereas
you should employ Chrono-LocalDate only when you need to localize the input or output of your
program.


