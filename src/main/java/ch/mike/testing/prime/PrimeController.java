package ch.mike.testing.prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PrimeController {
    PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService){
        this.primeService = primeService;
    }

    @GetMapping(value="/primes/{maxNumber}")
    public List<Integer> primesUntil(@PathVariable int maxNumber) {
        return primeService.getPrimesUntil(maxNumber);
    }

    @GetMapping(value="/isprime/{number}")
    public String isPrime(@PathVariable int number) {
        if (primeService.isPrime(number)){
            return "Number is a Prime Number";
        }else {
            return "Number is NOT a Prime Number";
        }
    }

    @GetMapping(value="/fibonacci/{maxNumber}")
    public List<Integer> getFibonacciSequence(@PathVariable int maxNumber) {
        return primeService.getFibonacciSequence(maxNumber);
    }

    @GetMapping(value="/fibonaccicount/{maxNumber}")
    public List<Integer> getFibonacciSequenceCount(@PathVariable int maxNumber) {
        return primeService.getFibonacciSequenceCount(maxNumber);
    }
}
