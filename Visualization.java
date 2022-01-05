import processing.core.*;

public class Visualization extends PApplet {

    public static void main(String[] args) {
        String[] mainSketch = concat(new String[] { getSketchClassName() }, args);
        PApplet.main(mainSketch);
    }

    public static final String getSketchClassName() {
        return Thread.currentThread().getStackTrace()[1].getClassName();
    }

    @Override
    public void settings() { // Window size
        size(640, 480);
    }

    Number[] numbers;

    @Override
    public void setup() {
        new Sorting(); 
        numbers = new Number[Sorting.unsortedList.size()];

        int index = 0;
        for (int num : Sorting.unsortedList) { 
            numbers[index] = new Number(num, index, this);
            index++;
        }
        Sorting.sortingOptions();
    }

    public Number getNumber(int i) {
        return numbers[i];
    }

    @Override
    public void draw() {
        background(230, 230, 250);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i].update();
            numbers[i].show();
        }
    }

}