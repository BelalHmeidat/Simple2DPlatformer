import java.io.File;
import java.io.FileNotFoundException;
import java.util.EventListener;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
//        Renderer renderer = new Renderer();
        Obstacle.generateObstacles();
        Renderer.initialize();
    }
    

}


