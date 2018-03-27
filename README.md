# Incrementally adding NullAway

Too often static code analysis tools are ignored because their default mode is 
all or nothing. This project demonstrates an incremental approach to adding NullAway 
to your existing project package by package.

## Important Notes

NullAway only validates that, a package listed under NullAway **ONLY** ensures that 
the package listed does not pass a `null` value to a `@NonNull` method.

e.g.

```java
package com.foo;

public class Foo {
    public void doSomething(String foo) {
        System.out.println(foo.length());
    }
    
    public void useBar() {
        Bar bar = new Bar();
        bar.doSomething("");
    }
} 
```

```java
package com.bar;

public class Bar {
    public void doSomething(String bar) {
        System.out.println(bar.length());
    }
    
    public void useFoo() {
        Foo foo = new Foo();
        foo.doSomething(null);
    }
}
```

In the above code examples, if `bar.useFoo()` is called, then the NPE will show 
`com.foo` as the package where it happened. Adding `com.foo` to NullAway will still 
allow the problem to happen though since the actual source is `com.bar.Bar`, so the 
solution is to add both `com.foo` and `com.bar` to NullAway. 

The reason this exists is that a package listed in NullAway assumes that everything is 
`@NonNull` by default, and therefore that each value passed to it by some other 
package will be `@NonNull`. 

This problem is not something to worry about if every package is under NullAway, but 
is important to keep in mind for incrementally adding it to your project.
