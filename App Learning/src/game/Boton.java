package game;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class Boton 
{
	public JToggleButton boton;
	public int id;
	
	public Boton ()
	{
		id = 0;
		boton = new JToggleButton();
	}
	
	public static void setImagen(JToggleButton b, ImageIcon i)
	{
		
		b.setIcon(i);
		b.setSelectedIcon(i);
		int w = i.getIconWidth();
        int h = i.getIconHeight();
        b.setPreferredSize(new Dimension(w, h));
        
	}
	public void setId (int x)
	{
		this.id = x;
	}
	
	
}