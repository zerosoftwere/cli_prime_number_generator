package me.xerosoft.prime;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class SievePrimeNumberGenerator implements PrimeNumberGenerator{

    public List<Integer> generate(int start, int end) throws IndexOutOfBoundsException {
        if (start < 0) throw new IndexOutOfBoundsException();


        BitSet primeBits = new BitSet();
        int stop = (int) Math.sqrt(end);

        for(int i = 2; i <= stop; i++) {
            if (!primeBits.get(i)) {
                for (int j = i * i; j < end; j = j + i) {
                    primeBits.set(j);
                }
            }
        }

        primeBits.flip(2, end);
        return primeBits.stream()
                    .filter(i -> i >= start).boxed()
                    .collect(Collectors.toList());
    }
}
