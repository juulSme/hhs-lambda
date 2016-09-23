package person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        // Only use Streams and lambdas for all exercises.
        // TODO: Exercise 5.1. Print the names of all adults sorted in reversed alphabetical order
        persons.stream()
                .filter(p -> p.age >= 18)
                .sorted((p,q) -> q.name.compareTo(p.name))  // note the reversal. Alternatively: -> -p.name.compareTo(q.name)
                .forEach(p -> System.out.println(p.name));

        // TODO: Exercise 5.2. Print the sum of all ages of males.
        System.out.println(persons.stream()
                .filter(p -> p.gender == Gender.MALE)
                .map(p -> p.age) // This is necessary because a direct Person to int reduction is not possible
                .reduce(0, (i, j) -> i + j));

        // TODO: Exercise 5.3. Create a List of lengths in meters of all minors
        List<Double> minorLengths = persons.stream()
                .filter(p -> p.age < 18)
                .map(p -> p.length / 100.0)     // p.length / 100.0 implicitly casts p.length to a double
                .collect(Collectors.toList());
        minorLengths.forEach(d -> System.out.println(d));
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