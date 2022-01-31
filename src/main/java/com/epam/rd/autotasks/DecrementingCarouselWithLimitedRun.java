package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {

    private int i = 0;
    private boolean runEd = false;
    protected int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        DecrementingCarouselWithLimitedRun.this.arr = new int[capacity];
        DecrementingCarouselWithLimitedRun.this.actionLimit = actionLimit;
    }

    @Override
    public int next() {
        if (arr.length == 0 || Arrays.stream(arr).sum() == 0 || actionLimit == 0)
            return -1;

        if (i >= capacity)
            while (arr[i] == 0) {
                i++;
                if (i > arr.length - 1)
                    i = 0;
            }

        if (arr[i] > 0 && actionLimit > 0) {
            actionLimit--;
            return arr[i++]--;
        }
        return 0;
    }

    @Override
    public DecrementingCarouselWithLimitedRun run() {
        if (!runEd) {
            runEd = true;
            return DecrementingCarouselWithLimitedRun.this;
        } else
            return null;
    }

    @Override
    public boolean isFinished() {
        return Arrays.stream(arr).sum() == 0 || actionLimit == 0;
    }
}
