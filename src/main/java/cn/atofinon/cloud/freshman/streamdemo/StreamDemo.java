package cn.atofinon.cloud.freshman.streamdemo;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Author atofinon
 * @Date 2019/8/26 3:42 PM
 * @Descrition
 */


public class StreamDemo {

    public static void main(String[] args) {

//        reduceFc();
//
//
//        List<String> words = new ArrayList<>();
//
//        words.add("my cat");
//        words.add("duoyu qian");
//
//        List<String> strings = words.stream().flatMap(s -> toFlatMapStr(s)).collect(Collectors.toList());
//        System.out.println(strings);
//
//        Set<String> ss1 = words.stream().flatMap(s -> Arrays.stream(s.split(" "))).map(s->s.toUpperCase()).collect(Collectors.toSet());
//        System.out.println(ss1);

        userFc();
    }

    public static void flapMapFnc() {
        String[][] data = new String[][]{{"1", "a"}, {"2", "b"}};
        Stream<String[]> st1 = Arrays.stream(data);
        st1.forEach(System.out::print);

        Stream<String> st2 = Arrays.stream(data).flatMap(x -> Arrays.stream(x)).filter(x -> "1".equals(x));
        st2.forEach(System.out::print);
    }

    public static void reduceFc() {
        System.out.println(Stream.of(1, 3, 4, 5, 7).reduce((x, y) -> x + y));

        String s1 = "dsflhsdfoer";
        String s2 = "sghghytwr";
        Set<String> sets = Arrays.stream(s1.split("")).collect(Collectors.toSet());
        System.out.println(sets);
        List<String> ss2 = Arrays.stream(s2.split("")).collect(Collectors.toList());


    }

    public static Stream<String> toFlatMapStr(String s) {
        List<String> result = new ArrayList<>();
        for (String s1 : s.split(" ")) {
            result.add(s1);
        }
        return result.stream();
    }

    public static void userFc() {
        List<User> users = new ArrayList<>();
        User u1 = new User("Joy", 21);
        u1.addBook("Java 8 in Action");
        u1.addBook("think in Java");
        u1.addBook("Spring");
        User u2 = new User("Tony", 20);
        u2.addBook("Spring");
        u2.addBook("MapReduce");

        users.add(u1);
        users.add(u2);
        List<String> books = users.stream()
                .map(x -> x.getBook())
                .flatMap(x -> x.stream())
                .distinct()
                .collect(Collectors.toList());

        books.forEach(System.out::println);
    }

    static class User {
        private String name;
        private Integer age;
        private Set<String> book;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public void addBook(String book) {
            if (this.book == null) {
                this.book = new HashSet<>();
            }
            this.book.add(book);

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Set<String> getBook() {
            return book;
        }

        public void setBook(Set<String> book) {
            this.book = book;
        }
    }

}
