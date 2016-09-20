package person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 *
 * This application is supposed to enable an administrator to filter his personnel
 * based on various criteria, for example their age or gender.
 */
// an interface that provides a generic test method
interface PersonTester {
    boolean test(Person p);
}

// We eliminated the MasculinityTester class

public class Main {
    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        // We implemented the interface PersonTester directly, using a
        // lambda expression. The expression "p -> p.gender == Gender.MALE"
        // is fully equivalent to the entire eliminated class. You'll have noticed
        // it is much more compact.
        printPersons(persons, p -> p.gender == Gender.MALE);
    }

    // Prints persons when they match the provided PersonTester
    public static void printPersons(List<Person> persons, PersonTester tester){
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