package main.java.com.epam.homework;

import main.java.com.epam.homework.domain.Book;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<Book, int[], Integer> {


    @Override
    public Supplier<int[]> supplier() {
        return () -> new int[1];
    }

    @Override
    public BiConsumer<int[], Book> accumulator() {
        return (result, book) -> result[0] += book.getNumberOfPages();
    }

    @Override
    public BinaryOperator<int[]> combiner() {
        return (result1, result2) -> {
            result1[0] += result2[0];
            return result1;
        };
    }

    @Override
    public Function<int[], Integer> finisher() {
        return total -> total[0];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>() {{
            add(Characteristics.UNORDERED);
        }};
    }
}
