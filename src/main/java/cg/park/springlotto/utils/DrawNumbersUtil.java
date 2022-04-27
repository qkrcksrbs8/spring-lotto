package cg.park.springlotto.utils;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class DrawNumbersUtil {
    public List<Set<Integer>> getLottos(int count) {
        List<Set<Integer>> lotto = new ArrayList<>();
        while (count --> 0) lotto.add(getLotto());
        return lotto;
    }
//    public List<Set<Integer>> getLottos() {
//        List<Set<Integer>> lotto = new ArrayList<>();
//        lotto.add(getLotto());
//        return lotto;
//    }

    private Set<Integer> getLotto() {
        Set<Integer> number = new HashSet<>();
        while (number.size() < 6) number.add((int)(Math.random() * 45)+1);
        return number;
    }
}
