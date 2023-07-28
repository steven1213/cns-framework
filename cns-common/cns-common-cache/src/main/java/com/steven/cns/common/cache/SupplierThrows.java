package com.steven.cns.common.cache;

import java.util.function.Supplier;

@FunctionalInterface
public interface SupplierThrows<T> {
    T get() throws Throwable;
}
