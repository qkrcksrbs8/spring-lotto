package cg.park.springlotto.utils;

import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class DrawNumbersUtil {
    public ArrayList<List<Integer>> getLottos(int count) {
        ArrayList<List<Integer>> lotto = new ArrayList<>();
        while (count --> 0) lotto.add(getRandomSixNumber());
        return lotto;
    }

    private List<Integer> getRandomSixNumber() {
        Set<Integer> number = new HashSet<>();
        while (number.size() < 6) number.add((int)(Math.random() * 45)+1);
        return sortNumbers(number);
    }

    public List<Integer> sortNumbers(Set<Integer> number) {
        List<Integer> sortNumber = new ArrayList<>(number);
        Collections.sort(sortNumber);
        return sortNumber;
    }
}
