import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class Boton 
{
	public JToggleButton boton;
	public int id;
	
	public Boton (int n)
	{
		id = n;
		boton = new JToggleButton();
	}
	
	public static void setImagen(JToggleButton b, Image i)
	{
		ImageIcon imagen = new ImageIcon(i);
		b.setIcon(imagen);
		b.setSelectedIcon(imagen);
	}
}