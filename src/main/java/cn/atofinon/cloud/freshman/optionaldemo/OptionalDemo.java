package cn.atofinon.cloud.freshman.optionaldemo;

import java.util.Optional;

/**
 * @Author:atofinon
 * @Date:2019-07-30 23:12
 * @Descrition:
 */


public class OptionalDemo {


    public static void main(String[] args) {

        /**
         * not null optional
         */
        Optional<String> noEmptyOpt = Optional.of("optional");


        /**
         * may be null may be not
         */
        Optional<String> mayBeNullOpt = Optional.ofNullable(null);


        /**
         * null optional
         */
        Optional<String> nullOpt = Optional.empty();


        /**
         * api {isPresent()} if the optional contain the value return true else return false
         */
        System.out.println(noEmptyOpt.isPresent());
        System.out.println(mayBeNullOpt.isPresent());
        System.out.println(nullOpt.isPresent());

        /**
         * api {ifPresent()} if the optional contain the value
         * run consumer
         * otherwise return
         */
        noEmptyOpt.ifPresent(x -> {
            System.out.println(x);
        });
        mayBeNullOpt.ifPresent(x -> {
            System.out.println(x);
        });

        /**
         * api {get()}
         * if the optional contain the value
         * return value
         * otherwise throw {NoSuchElementException}
         */
        System.out.println(noEmptyOpt.get());
//        System.out.println(mayBeNullOpt.get());


        /**
         * api {orElse()}
         * if the optional contain the value
         * return the value
         * otherwise return the default value
         */
        System.out.println(noEmptyOpt.orElse("default value"));
        System.out.println(mayBeNullOpt.orElse("default value"));


        /**
         * api {orElseGet()}
         * 如果没有值将执行传入参数 Supplier 函数接口
         * if the value present return the value
         */
        System.out.println(noEmptyOpt.orElseGet(()-> "other value"));
        System.out.println(mayBeNullOpt.orElseGet(() -> "other value"));


        /**
         * api {map()}
         * If a value is present , return true
         * otherwise return an empty optional
         */
        System.out.println(noEmptyOpt.map(x -> x.length() > 3));
        System.out.println(mayBeNullOpt.map(x -> x.length() > 3));

        /**
         * api {flatMap()}
         */
        System.out.println(noEmptyOpt.flatMap(x -> Optional.of(x.toUpperCase())));
        System.out.println(mayBeNullOpt.flatMap(x -> Optional.ofNullable(x.toUpperCase())));


        /**
         * api {filter()}
         */
        System.out.println(noEmptyOpt.filter(x -> x.length() > 3));
        System.out.println(mayBeNullOpt.filter(x -> x.length() > 3));
    }


}
