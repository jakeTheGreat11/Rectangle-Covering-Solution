import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rectangle[] rectangles = {
                new Rectangle(6.0, 8.0),
                new Rectangle(0.5, 6.0),
                new Rectangle(1.0, 5.0),
                new Rectangle(3.0, 5.5),
                new Rectangle(1.0,3.1)
        };

        // Test the RectangleCovering function
        List<Double> lines = rectangleCovering(rectangles);

        // Print the result
        System.out.println("Lines:");
        for (Double line : lines) {
            System.out.println(line);
        }

    }

    //      THIS WAS MY FIRST ANSWER
//    public static List<Double> rectangleCovering(Rectangle[] rectangles){
//        List<Double> lines = new ArrayList<>();
//        for (int i = 0; i < rectangles.length; i++) {
//            boolean isCovered = false;                  // a flag to check if there is a rectangle touching or inside rectangle i
//            for (int j = 0; j < rectangles.length; j++) {
//                if (i!=j && (rectangles[j].getLeft()>=rectangles[i].getLeft() && rectangles[j].getLeft()<= rectangles[i].getRight())){ //checks if the left of rectangle j is in between rectangle i's left and right
//                    isCovered = true;
//                    break;
//                }
//            }
//            if (!isCovered){ //if the rectangle is not covered by other rectangles then add line in the beginning of the rectangle
//                lines.add(rectangles[i].getLeft());
//            }
//        }return lines;
//    }

    public static List<Double> rectangleCovering(Rectangle[] rectangles){
        List<Double> lines = new ArrayList<>();
        Arrays.sort(rectangles, Comparator.comparingDouble(Rectangle::getRight));
        double maxRight = Double.NEGATIVE_INFINITY;
        for (Rectangle rectangle: rectangles) {
            if (rectangle.getLeft()> maxRight){
                lines.add(rectangle.getRight());
                maxRight = rectangle.getRight();
            }
        }
        return lines;
    }
}