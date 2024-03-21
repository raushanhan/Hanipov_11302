package org.example;


import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Gulnaz", "Vahitova", 65.7);
        Student s2 = new Student("Masha", "Ivanova", 45.9);
        Student s3 = new Student("Pavel", "Kalinovic", 62);
        Student s4 = new Student("Naira", "Berdimuhametova", 72);
        Student s5 = new Student("Cholka", "Li", 46);

        Student[] array = new Student[]{s1, s2, s3, s4, s5};

        Student[] filteredArr = Arrays.stream(array)
                .filter(x -> x.getScore() >= 56)
                .toArray(Student[]::new);

        Arrays.stream(filteredArr).forEach(x -> System.out.println(x.getName() + " " + x.getSurname())); // task 16

        //Arrays.stream(filteredArr).map(Student::getScore).

        System.out.println(Arrays.stream(filteredArr)
                .max((x1, x2) -> Integer.compare(x1.getSurname().length(), x2.getSurname().length()))
                .get().getSurname()); // task 18

    }
}