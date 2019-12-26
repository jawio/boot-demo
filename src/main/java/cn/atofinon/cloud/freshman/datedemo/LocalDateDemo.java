package cn.atofinon.cloud.freshman.datedemo;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author yangjw@tuya.com
 * @Date 2019/12/26 7:15 PM
 * @Descrition
 */


@Slf4j
public class LocalDateDemo {


    public static void main(String[] args) {

        // LocalDate
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.ofYearDay(2019, 100);


        // LocalTime

        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);


        //LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.of(2019, Month.DECEMBER, 20, 15, 34, 23);
        System.out.println(localDateTime2);


        // instant 2019-12-26T19:38:53.965
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1577360333965L), ZoneId.systemDefault());

        System.out.println(localDateTime);

        System.out.println(Instant.ofEpochSecond(1577360333L));
        System.out.println(Instant.now());
        System.out.println(Instant.now().toEpochMilli());


        System.out.println(localDateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(System.currentTimeMillis());


        LocalDateTime copyLocal = localDateTime.withYear(2020);
        System.out.println(localDateTime.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));
        System.out.println(copyLocal);



        LocalDate date = LocalDate.now();
        DayOfWeek dotw = date.getDayOfWeek();
        System.out.printf("%s is on a %s%n", date, dotw);         // 2016-07-11 is on a MONDAY
        System.out.printf("Next Monday: %s%n",
                date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));// Next Monday: 2016-07-18
        System.out.printf("First day of Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfMonth()));  // First day of Month: 2016-07-01
        System.out.printf("First Monday of Month: %s%n",
                date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));// First Monday of Month: 2016-07-04


        System.out.println(localDateTime.with(new PurchaseAdjuster()));
    }

}
