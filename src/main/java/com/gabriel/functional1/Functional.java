package com.gabriel.functional1;

import java.util.function.Function;

public class Functional {

    protected static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.name + " | " + this.age;
        }
    }

    protected static class DataLoader {
        public final Function<String, Person> loadPerson;

        public DataLoader(Boolean isDevelop) {
            this.loadPerson = isDevelop
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }

        private Person loadPersonReal(String name) {
            System.out.println("Loading person...");
            return new Person(name, 30);
        }

        private Person loadPersonFake(String name) {
            System.out.println("Loading fake person...");
            return new Person(name, 100);
        }

    }

    public static void main(String[] args) {

        DataLoader dataLoader = new DataLoader(false);
        System.out.println(dataLoader.loadPerson.apply("Gabriel").toString());

    }

}
