import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
public class GameFrame extends JFrame implements ActionListener{
    Timer timer;
	public int xVelocity = (int)Math.floor(Math.random()*(3)+1);
	public int yVelocity = (int)Math.floor(Math.random()*(3)+1);
	public int x = 0;
	public int y = 0;
    ImageIcon img = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\ScreenSaver 2\\DVD.png");
    JLabel image = new JLabel(img);
    GameFrame() {
        add(image);
        setSize(700, 700);
        image.setBackground(new Color((int) Math.floor(Math.random() * (256)), (int) Math.floor(Math.random() * (256)), (int) Math.floor(Math.random() * (256))));
		image.setOpaque(true);
        getContentPane().setBackground(Color.BLACK);
        image.setBounds(x, y, 100, 70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
        timer = new Timer(10, this);
		timer.start();
		getRootPane().addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				setLocation();
			}
		});
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		setLocation();
	}
	public void setLocation() {
		if(x>=getWidth()-112 || x<0) {
			image.setBackground(new Color((int) Math.floor(Math.random() * (256)), (int) Math.floor(Math.random() * (256)), (int) Math.floor(Math.random() * (256))));
			xVelocity *= -1;
		}
		x += xVelocity;
		
		if(y>=getHeight()-105 || y<0) {
			image.setBackground(new Color((int) Math.floor(Math.random() * (256)), (int) Math.floor(Math.random() * (256)), (int) Math.floor(Math.random() * (256))));
			yVelocity *= -1;
		}
		y += yVelocity;
		image.setBounds(x, y, 100, 70);
		
		repaint();
	}
}