package cg.park.springlotto.utils;

import cg.park.springlotto.comm.constant.MessageEnum;
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

    public String toEnum(String codeType) {
        if (
            codeType == null
            || (codeType.length() <= 0 && 5 < codeType.length())
        ) return "";
        try {
            return String.valueOf(MessageEnum.valueOf(codeType));
        }
        catch (Exception e) {
            return "";
        }
    }

}
