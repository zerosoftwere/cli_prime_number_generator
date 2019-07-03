package me.xerosoft.prime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestDividePrimeNumberGenerator implements PrimeNumberGenerator{
    @Override
    public List<Integer> generate(int start, int end) throws IndexOutOfBoundsException {
        return IntStream.range(start, end)
                .filter(x -> x > 1)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
    }

    /**
     * Checks if the given number is prime or not
     * @param number
     * @return
     */
    protected boolean isPrime(int number) {
        // say a <= sqrt(n) and b < sqrt(n) then ab <= sqrt(n).sqrt(n)
        // which implies ab <= n. hence common multiples don't exceed sqrt(n)
        final int end = (int) Math.sqrt(number);

        return IntStream.rangeClosed(2, end)
                .allMatch(n -> number % n != 0);
    }
}
