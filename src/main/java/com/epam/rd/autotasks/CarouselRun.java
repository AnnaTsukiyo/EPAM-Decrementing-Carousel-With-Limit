package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {

    protected int[] arr;
    protected int capacity;
    private int i = 0;

    public int next() {
        if (arr.length == 0 || Arrays.stream(arr).sum() == 0)
            return -1;

        if (i >= capacity)
            i = 0;

        while (arr[i] == 0) {
            i++;
            if (i > arr.length - 1)
                i = 0;
        }

        if (arr[i] > 0)
            return arr[i++]--;

        return 0;
    }

    public boolean isFinished() {
        return Arrays.stream(arr).sum() == 0;
    }
}