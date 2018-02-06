import java.awt.*;
import java.applet.Applet;
import java.util.*;
public class Manchester_Encoding extends Applet
{
    public void paint(Graphics g)
    {
        int y11 = 10;
        int y12 = 50;
        int y21 = 10;
        int y22 = 150;
        g.drawLine(y11,y12,y21,y22);
        int x11 = 10;
        int x12 = 100;
        int x21 = 500;
        int x22 = 100;
        g.drawLine(x11,x12,x21,x22);
        int i = 0;
        drawManchesterEncoding(g, i);
    }
    private void drawManchesterEncoding(Graphics g, int i)
    {
        Scanner inscan = new Scanner(System.in);
        System.out.println("Enter the bit:");
        int bit = inscan.nextInt();
        g.setColor(Color.red);
        switch(bit)
        {
            case 1:     g.drawLine(10+i,150,35+i,150);
                        g.drawLine(35+i,150,35+i,50);
                        g.drawLine(35+i,50,60+i,50);
                        g.setColor(Color.BLACK);
                        g.drawLine(60+i,50,60+i,150);
                        break;
            case 0:     g.drawLine(10+i,50,35+i,50);
                        g.drawLine(35+i,50,35+i,150);
                        g.drawLine(35+i,150,60+i,150);
                        g.setColor(Color.BLACK);
                        g.drawLine(60+i,50,60+i,150);
                        break;
            case 2:   System.exit(0);
                        break;
        }
        i+=50;
        drawManchesterEncoding(g, i);
    }
}