package ch.mike.testing.prime;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeServiceImpl implements PrimeService {
    @Override
    public Boolean isPrime(int f){
        return f > 1 && IntStream.range(2,f).noneMatch(i -> f%i == 0);
    }

    @Override
    public List<Integer> getPrimesUntil(int f) {
        return IntStream.range(0, f)
                .filter(x -> isPrime((int) x))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getFibonacciSequence(int f){
        List<Integer> myList = new ArrayList<Integer>();
        int firstNum = 1;
        int secondNum = 2;
        myList.add(firstNum);
        myList.add(secondNum);
        while(firstNum + secondNum <= f) {
            int newNum = firstNum + secondNum;
            myList.add(newNum);
            firstNum = secondNum;
            secondNum = newNum;
        }
        return myList;
    }

    @Override
    public List<Integer> getFibonacciSequenceCount(int f){
        List<Integer> myList = new ArrayList<Integer>();
        int firstNum = 1;
        int secondNum = 2;
        myList.add(firstNum);
        myList.add(secondNum);
        for(int i = 0; i <= f; i++) {
            int newNum = firstNum + secondNum;
            myList.add(newNum);
            firstNum = secondNum;
            secondNum = newNum;
        }
        return myList;
    }
}
