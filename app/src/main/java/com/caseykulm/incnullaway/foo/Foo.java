package com.caseykulm.incnullaway.foo;

import com.caseykulm.incnullaway.bar.Bar;

public class Foo {
    public void doSomething(String foo) {
        System.out.println(foo.length());
    }

    public void useBar() {
        Bar bar = new Bar();
        bar.doSomething("bar");
    }
}

