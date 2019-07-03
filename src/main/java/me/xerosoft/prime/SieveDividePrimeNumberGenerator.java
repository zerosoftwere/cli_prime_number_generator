package me.xerosoft.prime;

public class SieveDividePrimeNumberGenerator extends TestDividePrimeNumberGenerator {
    private static final PrimeNumberGenerator primeGenerator = new SievePrimeNumberGenerator();

    @Override
    protected boolean isPrime(int number) {
        // make the end inclusive
        int end = (int) Math.sqrt(number) + 1;

        if (end < 2) { return false; }

        // instead of going through all number <= sqrt(n)
        // since all numbers can be represented as multiples of prime
        // this method uses only prime numbers <= sqrt(n)
        return primeGenerator.generate(2, end)
            .stream()
            .allMatch(n -> number % n != 0);
    }
}
