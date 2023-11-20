import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    void testValidTriangle() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(3.0);
        sides.add(4.0);
        sides.add(5.0);
        assertDoesNotThrow(() -> new Triangle(sides));
    }

    @Test
    void testSidesAmountIsGreaterThanThree() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(3.4);
        sides.add(4.5);
        assertThrows(TriangleError.class, () -> new Triangle(sides));
    }

    @Test
    void testSidesAmountIsLessThanThree() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(3.0);
        sides.add(4.0);
        assertThrows(TriangleError.class, () -> new Triangle(sides));
    }

    @Test
    void testNegativeSideLength() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(3.0);
        sides.add(-4.0);
        sides.add(5.0);
        assertThrows(TriangleError.class, () -> new Triangle(sides));
    }

    @Test
    void testInvalidSideLengths() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(1.0);
        sides.add(1.0);
        sides.add(10.0);
        assertThrows(TriangleError.class, () -> new Triangle(sides));
    }

    @TestFactory
    public Stream<DynamicTest> testTriangleCreation() {
        Collection<ArrayList<Double>> sidesList = Arrays.asList(
                new ArrayList<>(Arrays.asList(3.0, 4.0, 5.0)),
                new ArrayList<>(Arrays.asList(5.0, 12.0, 13.0)),
                new ArrayList<>(Arrays.asList(8.0, 15.0, 17.0))
        );

        ThrowingConsumer<ArrayList<Double>> testTriangleCreation = sides -> {
            try {
                Triangle triangle = new Triangle(sides);
            } catch (TriangleError e) {
                assertEquals("", e.getMessage(), "Error message should be empty for valid sides");
            }
        };

        return sidesList.stream()
                .map(sides -> dynamicTest("Test triangle creation for sides " + sides,
                        () -> testTriangleCreation.accept(sides)));
    }
    @ParameterizedTest
    @CsvSource({
            "3.0, 4.0, 5.0",
            "6.0, 8.0, 10.0",
            "5.0, 12.0, 13.0"
    })
    void testValidTriangle(double side1, double side2, double side3) {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        assertDoesNotThrow(() -> new Triangle(sides));
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 4.0, 7.0",
            "2.0, 2.0, 4.0",
            "1.0, 1.0, 2.0"
    })
    void testInvalidTriangle(double side1, double side2, double side3) {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        assertThrows(TriangleError.class, () -> new Triangle(sides));
    }
}