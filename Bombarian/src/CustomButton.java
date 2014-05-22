
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;



public class CustomButton extends JButton implements MouseListener {
	Dimension size = new Dimension(250, 150);
	
	boolean hover =  false;
	boolean click = false;
	Image startButton;
	Image startButtonHover;
	
	
	String text = "";
	
	public CustomButton() {
		setVisible(true);
		setFocusable(true);
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		ImageIcon start = new ImageIcon(this.getClass().getResource("button.png"));
        startButton = start.getImage();
        
        ImageIcon startHover = new ImageIcon(this.getClass().getResource("button-hover.png"));
        startButtonHover = startHover.getImage();
		
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		if (hover){
			g.drawImage(startButtonHover, 50, 50, this);
		}
		else {
			g.drawImage(startButton, 50, 50, this);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return size;
	}
	
	@Override
	public Dimension getMaximumSize() {
		return size;
	}
	
	@Override
	public Dimension getMinimumSize() {
		return size;
	}
	
	public void setButtonText(String text) {
		this.text = text;
	}
	
	public String getButtonText() {
		return text;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		hover = true;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		hover = false;
	} 
	
	@Override
	public void mousePressed(MouseEvent e) {
		click = true;
	} 
	
	@Override
	public void mouseReleased(MouseEvent e) {
		click = false;
	} 
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	} 

}
