package me.xerosoft.prime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelSieveDividePrimeNumberGenerator extends SieveDividePrimeNumberGenerator {

    @Override
    public List<Integer> generate(int start, int end) throws IndexOutOfBoundsException {
        if (start < 0) throw new IndexOutOfBoundsException();
        else if (start < 2) start = 2;

        return IntStream.range(start, end)
                .parallel()
                .filter(this::isPrime).boxed()
                .collect(Collectors.toList());
    }
}
