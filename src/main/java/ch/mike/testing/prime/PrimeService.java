package ch.mike.testing.prime;

import java.util.List;

public interface PrimeService {
    Boolean isPrime(int i);

    List<Integer> getPrimesUntil(int i);

    List<Integer> getFibonacciSequence(int i);

    List<Integer> getFibonacciSequenceCount(int i);
}
