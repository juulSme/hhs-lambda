package person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 *
 * This application is supposed to enable an administrator to filter his personnel
 * based on various criteria, for example their age or gender.
 */
// an interface that compares two Persons and returns one
interface PersonComparator {
    Person compare(Person p1, Person p2);
}

public class Main {
    public static void main (String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Julien", 29, 189, Gender.MALE),
                new Person("Peter", 35, 172, Gender.PRIVATE),
                new Person("Abdul", 21, 180, Gender.MALE),
                new Person("Ilse", 13, 151, Gender.FEMALE),
                new Person("Jesse", 65, 190, Gender.OTHER));

        // In this case the lambda require two persons, p and q, and returns one.
        // The return statement is implicit. Notice how closely it resembles math functions.
        // For example, compare f(x, y) = 5x + 2y
        printPersons(persons, (p,q) -> p.age > q.age ? p : q );
    }

    // Prints persons when they match the provided PersonTester
    public static void printPersons(List<Person> persons, PersonComparator comparator){
        for (Person p : persons) {
            System.out.println(comparator.compare(p, persons.get(0)));
        }
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