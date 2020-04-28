package persons;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.ZoneId;
import java.util.Date;

public class Main {

    Faker faker = new Faker(new Locale("hu"));

    private Person randomPerson()
    {
        Person person = new Person();
        person.setGender(faker.options().option(Person.Gender.FEMALE, Person.Gender.MALE));
        person.setName(faker.name().fullName());
        person.setDob(localDate);
        person.setAddress(address);
        person.setEmail(faker.internet().emailAddress());
        person.setProfession(faker.company().profession());


        java.util.Date date = new Date();
        java.time.LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Address address = new Address();
        address.setCountry(faker.address().country());
        address.setState(faker.address().state());
        address.setCity(faker.address().city());
        address.setStreetAddress(faker.address().streetAddress());
        address.setZip(faker.address().zipCode());

        return person;
    }

    public static void main (String[] args)
    {

        Main main = new Main();

        List<Person> person = new ArrayList<Person>();

        for (int i = 0; i < 1000; i++) {

            person.add(main.randomPerson());
        }




    }

}
