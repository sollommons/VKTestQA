package test;

import main.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void getAge()
    {
        Person person = new Person(21, "Testovik");
        Assert.assertEquals(21,person.getAge());
    }
}
