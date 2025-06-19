Polymorphism = Many Forms.
- Compile Time Polymorhphism
- Run Time Polymorphism













class A {
    protected Object getData() {
        return "data";
    }
}

class B extends A {
    public String getData() {
        return "more data";
    }
}

overriding methods can increase visibility but not reduce it
