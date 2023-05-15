import java.io.File;
import java.io.FileNotFoundException;
import java.util.EventListener;
import java.util.Scanner;

public class Main {
    /*
    TODO Add tokens, Add riddles,  Implement fill algorithm, Implement line algorithm, Add score, Add lives, *Optional*, Code cleanup, Comments
     */
    public static void main(String[] args) {
//        Renderer renderer = new Renderer();
        Obstacle.generateObstacles();
        Renderer.initialize();
    }
    

}


