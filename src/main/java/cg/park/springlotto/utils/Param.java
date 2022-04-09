package cg.park.springlotto.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Builder
public class Param extends HashMap {

    public Param () {
        super();
    }
    public Param(final String key, final Object value) {
        super();
        super.put(key, value);
    }

    public Param set(final String column, final String value) {
        super.put(column, value);
        return this;
    }

    public Param set(final String column, final Object value) {
        super.put(column, value);
        return this;
    }

    public Param set(final String column, final int value) {
        super.put(column, Integer.toString(value));
        return this;
    }

    public Param set(final String column, final long value) {
        super.put(column, Long.toString(value));
        return this;
    }

    public Param set(final String column, final float value) {
        super.put(column, Float.toString(value));
        return this;
    }

    public Param set(final String column, final double value) {
        super.put(column, Double.toString(value));
        return this;
    }

    public Param set(final String column, final List<Param> value) {
        super.put(column, value);
        return this;
    }

    public Param set(final String column, final String[] value) {
        super.put(column, value);
        return this;
    }
}
