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