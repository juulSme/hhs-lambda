package person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 *
 * This application is supposed to enable an administrator to filter his personnel
 * based on various criteria, for example their age or gender.
 */
public class Main {
    // This is an adapted version of printPersons(). Instead of prescribing printing
    // behavior, you can now provide a Consumer lambda that determines what is done with
    // a Person object.
    public static void filterAndProcessPersons(List<Person> persons,
                                               Predicate<Person> tester,
                                               Consumer<Person> consumer){
        for (Person p : persons){
            // TODO: Exercise 3.1. Apply the consumer if the Person p is tested positively
        }
    }

    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        // The processPersons method needs a Predicate and a Consumer.
        // TODO: Exercise 3.2. Implement lambda's so that the length of
        // TODO: the name of everybody taller than 170 is printed.
        filterAndProcessPersons(persons,
                /**Predicate implementation here*/,
                /**Consumer implementation here*/);
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