package person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 *
 * This application is supposed to enable an administrator to filter his personnel
 * based on various criteria, for example their age or gender.
 */

// We eliminated both PersonTester and MasculinityTester

public class Main {
    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        // Instead of implementing PersonTester, we implemented Predicate<Person>,
        // a generic interface that only declares method "boolean test()". These
        // generic interfaces can be used with any Object type.
        printPersons(persons, p -> p.gender == Gender.MALE);
    }

    // Prints persons when they match the criteria of the Predicate
    public static void printPersons(List<Person> persons, Predicate<Person> tester){
        for (Person p : persons) if (tester.test(p)) System.out.println(p);
    }
}

class Person {
    public String name;
    public int age;
    public int length;
    public Gender gender;


    public Person(String name, int age, int length, Gender gender){
        this.name = name; this.age = age; this.length = length; this.gender = gender;
    }

    @Override
    public String toString(){
        return name + " is " + age + " years old, " + length + " cm long and has gender \"" + gender.toString() + "\".";
    }
}

enum Gender {
    MALE, FEMALE, OTHER, PRIVATE
}