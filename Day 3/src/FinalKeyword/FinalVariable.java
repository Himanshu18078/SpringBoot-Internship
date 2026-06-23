package FinalKeyword;

class FinalVariable {
    public static void main(String[] args) {
        final int x = 10;

        System.out.println("Value of x = " + x);

        // x = 20; // Error: cannot change final variable
    }
}
