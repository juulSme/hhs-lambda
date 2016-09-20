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
    // This version of filterAndProcess uses generics so that it can be
    // used with any class instead of just Persons.
    public static <T> void filterAndProcess(List<T> list,
                                               Predicate<T> tester,
                                               Consumer<T> consumer){
        for (T t : list){
            if (tester.test(t)) consumer.accept(t);
        }
    }

    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        // As you can see, the method adapts to the type of the applied List.
        // The type of p is inferred automatically. This implementation
        // prints the name of every adult non-male.
        filterAndProcess(persons,
                p -> p.age > 18 && p.gender != Gender.MALE,
                p -> System.out.println(p.name));

        // But now it also works with animals! These lambda's print the name
        // of each animal that starts with a "C".
        List<Animal> animals = Arrays.asList(
                new Animal("Dog"),
                new Animal("Camel"),
                new Animal("Turkey"));
        filterAndProcess(animals,
                a -> a.name.startsWith("C"),
                a -> System.out.println(a));

    }
}

class Animal {
    public String name;

    public Animal(String name){ this.name = name; }

    public String toString(){ return name; }
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