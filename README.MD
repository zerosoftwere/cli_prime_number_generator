# Prime Number Generator

## About

Command line prime number generator

## Requirements

- java version 8+
- gradle version 4+

## Build

- `gradle build` compiles, test and builds the jar file in *build/libs* directory

## Usage

`java Primes [strategy] <start> <end>`

Example: `java prime --concurrent-divide 12 230`

Start:

    -number greater than 1 less than max integer

Stop:

    -number greater than start less than max integer

Strategies:

    -td --test-divide        generates prime numbers using repeated divide

    -sv --sieve              generates prime numbers using sieve of eratosthenes

    -sd --sieve-divide       generates prime numbers using repeated prime division

    -cd --concurrent-divide  concurrent test-divide

    -cs --concurrent-sieve   concurrent sieve-divide

## Execute

- `gradle build` build the application
- `cd build/libs` navigate to the *libs* folder of the *build*
- `java -jar primes.jar --help` displays program usage
- `java -jar primes sv 10 200` run program using *sieve generator* with starting at *10* stoping at *200*