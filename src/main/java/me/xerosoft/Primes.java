package me.xerosoft;

import me.xerosoft.prime.*;

import java.util.List;

public class Primes {
    public static void main(String... args) {
        if (args.length < 3 || args[0].equals("-h") || args[0].equals("--help")) {
            printUsage();
        } else {
            try {
                final int start = Integer.parseInt(args[1]);
                final int end = Integer.parseInt(args[2]);
                final String strategy = args[0];

                if (validRange(start, end)) {
                    List<Integer> primes = generatePrimes(strategy, start, end);
                    System.out.println(primes);
                } else {
                    System.err.println("Invalid range supplied: '" + start + " - " + end + "' a lesser start perhaps");
                }
            } catch (NumberFormatException ex) {
                System.err.print("Invalid range supplied: '" + args[1] + " - " + args[2] + "' are you sure they are numbers?");
            } catch (IllegalArgumentException ex) {
                System.err.println("Invalid strategy: '" + args[0] + "' see help");
                printUsage();
                ex.printStackTrace();
            }
        }
    }

    public static List<Integer> generatePrimes(String strategy, int start, int end) {
        switch (strategy) {
            case "-td":
            case "--test-divide":
                return new TestDividePrimeNumberGenerator().generate(start, end);
            case "-sv":
            case "--sieve":
                return new SievePrimeNumberGenerator().generate(start, end);
            case "-cd":
            case "--concurrent-divide":
                return new ConcurrentTestDividePrimeNumberGenerator().generate(start, end);
        }
        throw new IllegalArgumentException();
    }

    public static boolean validRange(int start, int end) {
        if (start < 1 || start >= end) return false;
        return true;
    }

    public static void printUsage() {
        StringBuilder builder = new StringBuilder();
        builder.append("Usage java Primes [strategy] <start> <end>\n");
        builder.append("Example: java prime --concurrent-divide 12 230\n");
        builder.append("Strategies:\n");
        builder.append("    -td --test-divide        generates prime numbers using repeated divide\n");
        builder.append("    -sv --sieve              generates prime numbers using sieve of eratosthenes\n");
        builder.append("    -cd --concurrent-divide  concurrent test-divide\n");
        System.out.println(builder.toString());
    }
}
