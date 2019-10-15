package ch13;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        final List<Resizable> resizableShapes = Arrays.asList(
                new Square(), new Triangle(), new Ellipse()
        );
        Utils.paint(resizableShapes);
    }
}
