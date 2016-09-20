package person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 *
 * This application is supposed to enable an administrator to filter his personnel
 * based on various criteria, for example their age or gender.
 */
// an interface that "consumes" a Person (it does not return a value)
interface PersonConsumer {
    // TODO: Exercise 2.1. Define a method "apply"
}

public class Main {
    // TODO: Exercise 2.2. Adapt this method to use the Functional Interface
    public static void ConsumePersons(List<Person> persons){
        for (Person p : persons) /**DO SOMETHING WITH p*/;
    }

    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        // TODO: Exercise 2.3. Implement PersonConsumer using a lambda expression.
        ConsumePersons(persons/**, LAMBDA EXPRESSION*/);
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

// Hint: your lambda should not return a value, so feed a Person to some void.
// For example one that prints something to the console...