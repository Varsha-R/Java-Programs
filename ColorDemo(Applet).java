import java.awt.*;
import java.applet.*;
public class ColorDemo extends Applet {
    public void paint(Graphics g)
    {
        setBackground(Color.cyan);
        setForeground(Color.red);
        g.drawString("ABC", 50,50);
        Color newcolor=new Color(29,10, 10);
        g.setColor(newcolor);
        g.drawString("123",50,70);
    }
}
