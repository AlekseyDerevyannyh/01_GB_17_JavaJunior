package ru.gb;

import java.lang.reflect.Method;

public class OrderMethod implements Comparable<OrderMethod> {
    private final int order;
    private final Method method;

    public OrderMethod(int order, Method method) {
        this.order = order;
        this.method = method;
    }

    public int getOrder() {
        return order;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public int compareTo(OrderMethod o) {
        return this.getOrder() - o.getOrder();
    }
}
