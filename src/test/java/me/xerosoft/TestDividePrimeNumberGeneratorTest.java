package me.xerosoft;

import me.xerosoft.prime.PrimeNumberGenerator;
import me.xerosoft.prime.TestDividePrimeNumberGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestDividePrimeNumberGeneratorTest {
    PrimeNumberGenerator primeGenerator = new TestDividePrimeNumberGenerator();

    @Test
    public void testPrimeNumbersTo10() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        List<Integer> actual = primeGenerator.generate(1, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrimeNumberTo1000() {
        int expectedLength = 168;
        int actualLength = primeGenerator.generate(1, 1000).size();
        Assert.assertEquals(expectedLength, actualLength);
    }



    @Test
    public void testPrimeNumberTo10000() {
        int expectedLength = 1229;
        int actualLength = primeGenerator.generate(1, 10000).size();
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testPrimeNumberFrom500To10000() {
        int expectedLength = 1134;
        int actualLength = primeGenerator.generate(500, 10000).size();
        Assert.assertEquals(expectedLength, actualLength);
    }


}
