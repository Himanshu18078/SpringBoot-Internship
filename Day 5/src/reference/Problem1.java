package reference;

class A {
    void show() {
        System.out.println("A");
    }
}

class B extends A {
    void show() {
        System.out.println("B");
    }
}

class C extends B {
    void show() {
        System.out.println("C");
    }
}

public class Problem1 {
    public static void main(String[] args) {
        A obj = new C(); // since we have reference of parent then only method that A have can be printed
//        but we have passed object of C and C has overridden the show() method so C will be printed.
        obj.show();
    }
}
