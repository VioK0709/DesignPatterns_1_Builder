public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalStateException {
        if (name.isEmpty()) {
            throw new IllegalStateException("Не указано имя");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalStateException {
        if (surname.isEmpty()) {
            throw new IllegalStateException("Не указана фамилия");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalStateException {
        if (age <= 0) {
            throw new IllegalStateException("Возраст не указан или указан не верно");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) throws IllegalStateException {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Не указаны имя или фамилия");
        } else if (!name.isEmpty() && age > 0) {
            person = new Person(name, surname, age);
            person.setAddress(address);
        } else
            person = new Person(name, surname);
        return person;
    }
}
