package ch.mike.testing.prime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;

import java.util.List;

@RunWith(SpringRunner.class)
class PrimeServiceImplTest {

    @InjectMocks
        PrimeServiceImpl primeServiceImpl = new PrimeServiceImpl();

    @Test
    public void is9Prime() {
        Boolean isPrime = primeServiceImpl.isPrime(107);
        Assertions.assertThat(isPrime).isTrue();
    }

    @Test
    public void is7Prime() {
        Boolean isPrime = primeServiceImpl.isPrime(7);
        Assertions.assertThat(isPrime).isEqualTo(true);
    }

    @Test
    void getPrimesUntil12() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getPrimesUntil(12);
        Assertions.assertThat(collectionOfPrimes).containsExactly(2,3,5,7,11);
    }

    @Test
    void getPrimesUntil1() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getPrimesUntil(1);
        Assertions.assertThat(collectionOfPrimes).containsExactly();
    }

    @Test
    void getPrimesUntil0() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getPrimesUntil(0);
        Assertions.assertThat(collectionOfPrimes).containsExactly();
    }

    @Test
    void getPrimesUntilMinus1() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getPrimesUntil(-1);
        Assertions.assertThat(collectionOfPrimes).containsExactly();
    }

    @Test
    void getFibonacciSequenceUnder0() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getFibonacciSequence(0);
        Assertions.assertThat(collectionOfPrimes).containsExactly(1,2);
    }

    @Test
    void getFibonacciSequenceUnderMinus1() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getFibonacciSequence(-1);
        Assertions.assertThat(collectionOfPrimes).containsExactly(1,2);
    }

    @Test
    void getFibonacciSequenceUnder1() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getFibonacciSequence(1);
        Assertions.assertThat(collectionOfPrimes).containsExactly(1,2);
    }

    @Test
    void getFibonacciSequenceUnder200() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getFibonacciSequence(200);
        Assertions.assertThat(collectionOfPrimes).containsExactly(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }

    @Test
    void getFibonacciSequenceUnder11() {
        List<Integer> collectionOfPrimes = primeServiceImpl.getFibonacciSequence(11);
        Assertions.assertThat(collectionOfPrimes).containsExactly(1, 2, 3, 5, 8);
    }

//    @Test
//    void getFibonacciSequenceCountTo10() {
//        List<Integer> collectionOfPrimes = primeServiceImpl.getFibonacciSequenceCount(10);
//        Assertions.assertThat(collectionOfPrimes).containsExactly(1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
//    }
}