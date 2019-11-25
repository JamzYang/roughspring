package com.yang.roughspring;

import java.util.Objects;

/**
 * bean 属性
 * @author yang
 * Date 2019/11/25 0:46
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }


    //idea
   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyValue that = (PropertyValue) o;

        if (!name.equals(that.name)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyValue that = (PropertyValue) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
