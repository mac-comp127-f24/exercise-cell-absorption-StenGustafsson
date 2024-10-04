package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class CellSimulation {

    private CanvasWindow canvas;
    private Random rand = new Random();
    private ArrayList<Cell> cells = new ArrayList<>();

    public static void main(String[] args) {
        new CellSimulation();
    }

    public CellSimulation() {
        canvas = new CanvasWindow("Cell Absorption", 800, 800);
        populateCells(10);

        //noinspection InfiniteLoopStatement
        while (true) {
            Point canvasCenter = new Point(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            for (Cell cell : cells) {
                cell.moveAround(canvasCenter);
                cell.grow(0.02);
            }
            canvas.draw();
            canvas.pause(10);
        }
    }

    private void populateCells(int cellCount) {
        for (int i = 0; i < cellCount; i++) {
            double size = rand.nextInt(5) + 2;
            cells.add(new Cell(
                rand.nextDouble() * (canvas.getWidth() - size),
                rand.nextDouble() * (canvas.getWidth() - size),
                size,
                Color.getHSBColor(rand.nextFloat(), rand.nextFloat() * 0.5f + 0.1f, 1)));

        }
        
        for (Cell cell : cells) {
            canvas.add(cell.shape);
        }
    }


    private static double sqr(double x) {
        return x * x;
    }
}
