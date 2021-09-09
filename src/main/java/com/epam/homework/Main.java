package main.java.com.epam.homework;

import main.java.com.epam.homework.domain.Author;
import main.java.com.epam.homework.domain.Book;
import main.java.com.epam.homework.domain.Person;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("===========TASK 1============");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(20, "Steve Carell"));
        personList.add(new Person(25, "Jim Halpert"));
        personList.add(new Person(34, "Pam Beesely"));
        personList.add(new Person(19, "Dwight Shrout"));

        Comparator<Person> compareName = Comparator.comparing(Person::getName);
        Comparator<Person> compareAge = Comparator.comparing(Person::getAge);

        personList.stream().sorted(compareName.thenComparing(compareAge)).forEach(System.out::println);
        System.out.println("===================================================");

        System.out.println("===========TASK 2+3============");
        Predicate<Person> personPredicate = p -> p.getAge() > 20;
        Consumer<Person> personConsumer = System.out::println;
        Supplier<Person> personSupplier = () -> new Person(new Random().nextInt(100), String.valueOf(Math.random()));
        Function<Integer, String> levelOfSkill = x -> " " + x + " skill";
        UnaryOperator<Integer> addAge = x -> x++;
        BinaryOperator<String> addSkill = (p, x) -> p + x;

        AdditionSkill additionSkillLambda = (person, level, add) -> person.setName(add.apply(person.getName(), level.apply(new Random().nextInt(5))));
        additionSkillLambda.addSkillLevel(personList.get(0), levelOfSkill, addSkill);
        System.out.println(personList.get(0));

        AdditionSkill additionSkillAnon = new AdditionSkill() {
            @Override
            public void addSkillLevel(Person person, Function<Integer, String> defineSkill, BinaryOperator<String> addSkill) {
                String skillLevel = defineSkill.apply(new Random().nextInt(5));
                String newSkillLevel = addSkill.apply(person.getName(), skillLevel);
                person.setName(newSkillLevel);
            }
        };
        additionSkillAnon.addSkillLevel(personList.get(1), levelOfSkill, addSkill);
        System.out.println(personList.get(1));

        additionSkillAnon.showDefault();
        AdditionSkill.showStatic();
        System.out.println("===================================================");

        System.out.println("===========TASK 4============");
        Author author1 = new Author("Bob Marley", (short) 54);
        Author author2 = new Author("Omar Su", (short) 34);
        Author author3 = new Author("Adam Sendler", (short) 24);

        List<Author> authors1 = new ArrayList<>();
        authors1.add(author1);
        authors1.add(author2);
        List<Author> authors2 = new ArrayList<>();
        authors2.add(author3);
        List<Author> authors3 = new ArrayList<>();
        authors3.add(author1);
        authors3.add(author3);

        Book book1 = new Book("1984", authors1, 400);
        Book book2 = new Book("Animal Farm", authors2, 199);
        Book book3 = new Book("Of Mice and Men", authors3, 205);

        Book[] booksArray = new Book[]{book1, book2, book3};

        //I. check if some/all book(s) have more than 200 pages;
        //II. find the books with max and min number of pages;
        boolean b1 = Arrays.stream(booksArray).allMatch((b) -> b.getNumberOfPages() > 200);
        Optional<Book> max = Arrays.stream(booksArray).max(Comparator.comparing(Book::getNumberOfPages));
        Optional<Book> min = Arrays.stream(booksArray).min(Comparator.comparing(Book::getNumberOfPages));
        System.out.println("Max: " + max.get().getNumberOfPages() +
                " Min: " + min.get().getNumberOfPages() +
                " All books have more than 200 pages: " + b1);

        //III. filter books with only single author;
        //IV. sort the books by number of pages/title;
        //V. get list of all titles;
        //VI. print them using forEach method;
        Arrays.stream(booksArray)
                .parallel()
                .filter((b) -> b.getAuthors().size() != 1)
                .sorted(Comparator.comparing(Book::getNumberOfPages).thenComparing(Book::getTitle))
                .forEach(System.out::println);


        //VII. get distinct list of all authors
        Arrays.stream(booksArray).flatMap((b) -> b.getAuthors().stream()).distinct().forEach(System.out::println);

        System.out.println("===================================================");

        System.out.println("===========TASK 5" + "============");

        Integer collect = Arrays.stream(booksArray).collect(new CustomCollector());
        System.out.println(collect);

        testCollector();
        System.out.println("===================================================");
    }

    public static void testCollector() {
        Book book1 = new Book("1984", null, 400);
        Book book2 = new Book("Animal Farm", null, 199);
        Book book3 = new Book("Of Mice and Men", null, 205);

        Book[] booksArray = new Book[]{book1, book2, book3};

        Integer collect = Arrays.stream(booksArray).collect(new CustomCollector());
        Integer sum = Arrays.stream(booksArray).mapToInt(Book::getNumberOfPages).sum();

        assert sum.equals(collect);
    }
}
