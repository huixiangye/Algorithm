package javaClasses.多线程;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by yehuixiang on 8/21/18.
 */
public class SleepMethodTest extends JFrame {
    private Thread t;

    private static Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.ORANGE,
                                    Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY};

    private static final Random rand = new Random();

    public SleepMethodTest(){
        t = new Thread(new Runnable() {


            int x = 30;
            int y = 50;

            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    Graphics graphics = getGraphics();
                    graphics.setColor(colors[rand.nextInt(colors.length-1)]);

                    graphics.drawLine(x,y,100,y++);
                    if(y>=80){
                        y = 50;
                    }

                }
            }
        });
        t.start();
    }

    public static void main(String[] args){
        init(new SleepMethodTest(),100,100);
    }

    public static void init(JFrame frame, int width,int heigth){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,heigth);
        frame.setVisible(true);
    }
}
