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

        // This code replaces an interface, a class, a method and an
        // enormous amount of unreadable boilerplate code with three concise lines.
        // The functionality is exactly the same as that of branch
        // "exampleFilterWithLocalClass".
        persons.stream()                                    // Source
                .filter(p -> p.gender == Gender.MALE)       // Intermediate op filter()
                .forEach(p -> System.out.println(p));       // Terminal op forEach()
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