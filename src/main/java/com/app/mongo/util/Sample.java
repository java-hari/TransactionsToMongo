package com.app.mongo.util;

import java.time.LocalDate;

public class Sample {
	
	public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2024, 5, 29);
        LocalDate date2 = LocalDate.of(2024, 5, 3);
        LocalDate date3 = LocalDate.of(2024, 5, 29);

        System.out.println("date1 equals date2: " + date1.isEqual(date2)); // Output: false
        System.out.println("date1 equals date3: " + date1.isEqual(date3)); // Output: true
        System.out.println("date1 is before date2: " + date1.isBefore(date2)); // Output: true
        System.out.println("date2 is after date1: " + date2.isAfter(date1)); // Output: true
        System.out.println("date1 compareTo date2: " + date1.compareTo(date2)); // Output: -1
        System.out.println("date1 compareTo date3: " + date1.compareTo(date3)); // Output: 0
        System.out.println("date1 compareTo date3: " + date2.compareTo(date1)); // Output: 0
    }

}
