package cg.park.springlotto.utils;

import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class PcgUtil {

    public int[][] setToArray(List<Set<Integer>> set) {
        int[][] result = new int[set.size()][5];
        int i = 0;
        int j = 0;
        for (Set<Integer> integers : set) {
            for (int num : integers) {
                result[i][j] = num;
                j++;
            }
            i++;
        }
        return result;
    }

}
