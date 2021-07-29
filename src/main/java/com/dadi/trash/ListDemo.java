package com.dadi.trash;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDemo {
    public static void main(String[] args) throws IOException {


   /*     Stream<String> a = Stream.of("a", "b", "c ", "  d  ");

        String reduce = a.reduce("0", (acc, b) -> acc + b.trim());
        System.out.println(reduce);

        Optional<String> reduce1 = a.reduce((acc, b) -> acc + b.trim());
        String s = reduce1.get();*/

//        List<String> list = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");
//        list.add(null);
     /*   list.stream().map(x -> {
            String[] split = x.split("\\=");
            String key = split[0];
            String value = split[1];

        })*/



     /*   HashMap<String, String> reduce = list.stream().map(x -> {
            String[] split = x.split("\\=");
            String key = split[0];
            String value = split[1];
            HashMap<String, String> map = new HashMap<>();
            map.put(key, value);
            return map;
        }).reduce(new HashMap<String, String>(), (acc, n) -> {
            acc.putAll(n);
            return acc;
        });

        reduce.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });*/


        List<String> list = Arrays.asList("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");

        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));

        collect.forEach((k, v) -> {
            System.out.print(k + ":");
            System.out.println(Arrays.toString(v.toArray()));
        });

        list.stream()
                .skip(2)
                .limit(3)
                .forEach(System.out::println);

        List<String> collect1 = list.stream()
                .parallel()
                .sorted()
                .collect(Collectors.toList());

        list.stream().allMatch(x -> x.equals("a"));

        list.stream().anyMatch(x -> x.equals(""));


    }

    public static Path getPath(String fileName) {
        Path path = null;
//        path = ListDemo.class.getClassLoader().getResource(fileName).getPath();
        return path;
    }

}

class Gen implements Supplier<Integer> {
    int n = 0;

    @Override
    public Integer get() {
        n++;
        return n;
    }
}
