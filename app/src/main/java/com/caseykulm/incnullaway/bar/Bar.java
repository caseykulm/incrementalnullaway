package com.caseykulm.incnullaway.bar;

import com.caseykulm.incnullaway.foo.Foo;

public class Bar {
    public void doSomething(String bar) {
        System.out.println(bar.length());
    }

    public void useFoo() {
        Foo foo = new Foo();
        foo.doSomething(null);
    }
}