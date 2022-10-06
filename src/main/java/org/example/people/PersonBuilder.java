package org.example.people;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected boolean hasAge;
    protected String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException ("Указан некорректный возраст ("+age+")!");
        this.age = age;
        this.hasAge = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (name == null || name.equals("")) throw new IllegalStateException("Не указано обязательное поле 'Имя'!");
        if (surname == null || surname.equals("")) throw new IllegalStateException("Не указана обязательное поле 'Фамилия'!");

        Person person;
        if (hasAge) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(city);
        return person;
    }
}
