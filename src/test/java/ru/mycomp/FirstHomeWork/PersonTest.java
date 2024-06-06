package ru.mycomp.FirstHomeWork;


import org.junit.Assert;
import org.junit.Test;
import ru.mycomp.Homework1.Person;

public class PersonTest {
    @Test
    public void getAge()
        {
        Person person = new Person(21, "Testovik");
        Assert.assertEquals(21,person.getAge());
    }
}
