import java.util.LinkedList;

public class Number {
    Visualization v;
    int num; 
    int index; 

    float x1; 
    float x2; 
    float y1 = 480;
    float y2; 

    float gap = 5; // Space between numbers  
    float lenFactor = 20; // Scales number visuals higher  
    float width = 10; // Width of number column 

    public Number(int num, int index, Visualization v) {
        this.num = num;
        this.index = index;
        this.v = v; 

        if (index == 0) {
            x1 = gap + index;
            x2 = x1 + width;
        } else {
            x1 = (float) gap + v.getNumber(index - 1).x2; // Gap + x2 of previous number.
            x2 = x1 + width;
        }
        y2 = this.num * lenFactor;  
    }

    public void update() {

    }

    public void show() {
        
        v.rect(x1, y1, width, -y2);

        
        //v.line();
    }
    
}
