package com.caseykulm.incnullaway.unsafe;

import com.caseykulm.incnullaway.unsafe.safe.NullSafe;

public class UnsafeInputter {
    public void useNullSafe() {
        NullSafe nullSafe = new NullSafe();

        // This is fine
        nullSafe.doSomething("foo");

        /*
         * This is not, and will cause an NPE to **happen** in the com.caseykulm.incnullaway.unsafe.safe package,
         * even though this package is the **actual** culprit. Putting com.caseykulm.incnullaway.unsafe.safe
         * under NullAway will not solve the problem.
         */
        nullSafe.doSomething(null);
    }
}
