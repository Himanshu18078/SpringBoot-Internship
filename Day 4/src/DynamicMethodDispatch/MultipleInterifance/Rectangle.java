package DynamicMethodDispatch.MultipleInterifance;

public class Rectangle implements Shape1, Shape2 {

    @Override
    public void area() {
//        Here we have resolved the ambiguity problem of variables.
        int area1 = Shape1.length * Shape1.length;
        int area2 = Shape2.length * Shape2.length;
        System.out.println("Area of Rectangle 1  is: " + area1 + " and of Rectangle 2 is :  " + area2);
    }

    static void main() {
        Rectangle r1 = new Rectangle();
        r1.area();
    }
}
