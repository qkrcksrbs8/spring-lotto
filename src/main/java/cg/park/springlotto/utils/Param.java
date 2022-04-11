package cg.park.springlotto.utils;

import java.util.HashMap;
import java.util.List;

public class Param extends HashMap {

    public Param () {
        super();
    }
    public Param(String key, Object value) {
        super();
        super.put(key, value);
    }

    public Param set(String column, Object value) {
        super.put(column, value);
        return this;
    }

    public Param set(String column, int value) {
        super.put(column, Integer.toString(value));
        return this;
    }

    public Param set(String column, long value) {
        super.put(column, Long.toString(value));
        return this;
    }

    public Param set(String column, float value) {
        super.put(column, Float.toString(value));
        return this;
    }

    public Param set(String column, double value) {
        super.put(column, Double.toString(value));
        return this;
    }

    public Param set(String column, List<Param> value) {
        super.put(column, value);
        return this;
    }

    public Param set(String column, String[] value) {
        super.put(column, value);
        return this;
    }
}
