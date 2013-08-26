import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;



public class Window extends JFrame implements KeyListener, MouseListener {

	private int yvalue  = 200;
	private int xvalue  = 100;
	private int mouse_X = 0;
	private int mouse_Y = 0;

	boolean up 			= false;
	boolean down 		= false;
	boolean left 		= false;
	boolean right 		= false;

	JComponent drawing;
	// Display display

	public Window(){
		initialize();
		this.setSize(1900, 1080 );
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initialize(){

		drawing = new JComponent() {
			protected void paintComponent(Graphics g) {
				redraw(g);
			}


		};
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		add(drawing);
		drawing.repaint();


	}


	private void redraw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		//Bottom pane
		g.fillRect(0,getHeight()-(getHeight()/4),getWidth(),getHeight()/4);
		//left hand pane
		g.fillRect(0, 0, 25, getHeight()-(getHeight()/4));
		//right hand pane
		g.fillRect(getWidth() - 25, 0, 25, getHeight()-(getHeight()/4));
		g.fillRect(25, 0, getWidth(), 25);
		g.fillOval(mouse_X - 10, mouse_Y - 20, 20, 20);
	}

	/*private void panMap(){
		if(up)
			display.setCameraY(display.getY--);
		if(down)
			display.setCameraY(display.getY++);
		if(right)
			display.setCameraX(display.getX()++);
		if(left)
			display.setCameraX(display.getX()--);

	}*/

	public static void main(String[] args) {
		new Window();

	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		switch (code) {
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_KP_RIGHT:
			case KeyEvent.VK_D:
				right = true;
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_KP_LEFT:
			case KeyEvent.VK_A:
				left = true;
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
			case KeyEvent.VK_W:
				up = true;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
			case KeyEvent.VK_S:
				down = true;
				break;
		}
	//	panMap();
		repaint();
		//display.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		int code = e.getKeyCode();

		switch (code) {
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_KP_RIGHT:
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_KP_LEFT:
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_KP_UP:
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_KP_DOWN:
		case KeyEvent.VK_S:
			down = false;
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouse_X = e.getPoint().x;
		mouse_Y = e.getPoint().y;
		drawing.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}




