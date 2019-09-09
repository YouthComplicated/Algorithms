package jdk.jdk8.lambaTest.filter;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {


    static void printLine(String ... args){
        if(args.length > 0){
            System.out.println("===============" + args[0]);
        }else{
            System.out.println("===============");
        }

    }

    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest test = new PersonTest();

        printLine("getPersonsByUsername");
        List<Person> personResult1 = test.getPersonsByUsername("zhangsan", persons);
        personResult1.forEach(person -> System.out.println(person.getUsername()));


        printLine("getPersonsByAge");
        List<Person> personResult2 = test.getPersonsByAge(20, persons);
        personResult2.forEach(person -> System.out.println(person.getAge()));


        printLine("getPersonsByAge2");
        List<Person> personResult3 = test.getPersonsByAge2(20, persons, (age, personList) ->
             personList.stream().filter(person -> person.getAge() > age).
                     collect(Collectors.toList())
        );
        personResult3.forEach(person -> System.out.println(person.getAge()));


        printLine("getPersonsByAge2");
        List<Person> personResult4 = test.getPersonsByAge2(20, persons, (age, personList) ->
                personList.stream().filter(person -> person.getAge() <= age).collect(Collectors.toList())
        );
        personResult4.forEach(person -> System.out.println(person.getAge()));


        printLine("getStringName");
        Person person5 = test.getStringName(null,persons, (name, personList)->
                personList.stream().filter(person -> person.getUsername().equals(name))
                        .collect(Collectors.toList()).get(0));
        System.out.println(person5.toString());

    }

    /**
     * stream->filter(行为)->collect()
     * @param username
     * @param persons
     * @return
     */
    public List<Person> getPersonsByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).
                collect(Collectors.toList());
    }

    public List<Person> getPersonsByAge(int age, List<Person> persons) {

        BiFunction<Integer, List<Person>, List<Person>> biFunction =
            (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());

        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonsByAge2(int age, List<Person> persons,
                                         BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }


    public Person getStringName(String name, List<Person> personList, BiFunction<String, List<Person>, Person> biFunction){

        return biFunction.apply(name, personList);
    }


























}
