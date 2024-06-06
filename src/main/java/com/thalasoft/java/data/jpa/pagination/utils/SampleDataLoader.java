package com.thalasoft.java.data.jpa.pagination.utils;

import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.thalasoft.java.data.jpa.pagination.model.Address;
import com.thalasoft.java.data.jpa.pagination.model.Person;
import com.thalasoft.java.data.jpa.pagination.repository.PersonRepository;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository personRepository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository repository, Faker faker) {
        this.personRepository = repository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading sample data...");

        List<Person> people = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode())))
                .toList();

        personRepository.saveAll(people);
    }
}
