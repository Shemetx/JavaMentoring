package com.epam.homework.task1;

import java.util.ArrayList;
import java.util.List;

public class Chain {

    private List<Handler> handlers = new ArrayList<>();
    private int n = 0;

    public void setHandlers(int count) {
        int i = 0;
        while (i++ < count) {
            handlers.add(new Handler());
        }
    }

    public void process() {
        if (n < handlers.size()) {
            Handler handler = handlers.get(n++);
            handler.handle(this);
        }
    }
}
