package com.example.ecommerce;

import java.util.Comparator;

public class ComparePrice implements Comparator<ModelSort> {
    @Override
    public int compare(ModelSort o1, ModelSort o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return 1;
        }
        return 0;
    }
}
