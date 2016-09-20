package person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 *
 * This application is supposed to enable an administrator to filter his personnel
 * based on various criteria, for example their age or gender.
 */
public class Main {
    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        printPersonsOlderThan(persons, 30);
    }

    public static void printPersonsOlderThan(List<Person> persons, int age){
        // TODO: Exercise 1.1.
        // Implement this method to print Persons older than a certain age
    }

    // TODO: Exercise 1.2.
    // The method you implemented in exercise 1 is a method that filters the list of persons.
    // Come up with some drawbacks to this approach. Think about the brittleness and
    // flexibility of this approach. You may write down your answer in the comment down below.

    /**
     * MY ANSWER
     */
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