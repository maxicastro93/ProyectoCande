package game;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AparearGame {

	public ArrayList<ArrayList<Boton>> imagenes; // almacena todas las imagenes en grupos para mostrar
	public Boton imagenA;
	public Boton imagenB;
	public Boton imagenC;
	public JFrame frame;
	public JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AparearGame window = new AparearGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AparearGame()
	{
		frame = new JFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	public void ventanaAparearInicial ()
	{
		//CREA EL FRAME
		
		frame.setBounds(400, 40, 403, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1090, 700);
		
		//CREA EL PANEL
		this.panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(100, 100, 890, 450);
		this.frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//TITULO DE LA VENTANA
		JLabel tituloVentana = new JLabel("Seleccionar las imagenes relacionadas");
		tituloVentana.setBounds(40, -100, 900, 300);
		tituloVentana.setFont(new Font("Consolas", Font.PLAIN, 40));
		tituloVentana.setHorizontalAlignment(SwingConstants.LEFT);
		tituloVentana.setForeground(Color.BLACK);
		panel.add(tituloVentana);
		
		this.frame.setVisible(true);
		
		imagenA = new Boton();
		imagenB = new Boton();
		imagenC = new Boton();
		
		
		// UBICAR BOTONES EN EL JPANEL
		this.imagenA.boton.setBounds(142, 109, 212, 149);
		this.imagenB.boton.setBounds(371, 109, 212, 149);
		this.imagenC.boton.setBounds(598, 109, 212, 149);
			
		ventanaOpcion1(panel, imagenA, imagenB, imagenC);
		
		panel.add(imagenA.boton);
		panel.add(imagenB.boton);
		panel.add(imagenC.boton);
		

        avisoPresionaBoton();

	}

	private void avisoPresionaBoton() {
		// ItemListener es notificado cuando presionan un ToggleButton 
        ItemListener itemListener = new ItemListener() 
        { 
            // itemStateChanged() method is nvoked automatically 
            // whenever you click or unlick on the Button. 
            public void itemStateChanged(ItemEvent itemEvent) 
            { 
  
                // event is generated in button 
                int state = itemEvent.getStateChange(); 
  
                // if selected print selected in console 
                if (state == ItemEvent.SELECTED) 
                { 
                	checkEsCorrecto(imagenA, imagenB, imagenC);
                    System.out.println("Selected"); 
                } 
                else
                { 
                	checkEsCorrecto(imagenA, imagenB, imagenC);
                    // else print deselected in console 
                    System.out.println("Deselected"); 
                } 
            }

			
        }; 
  
        // Attach Listeners 
        imagenA.boton.addItemListener(itemListener);
        imagenB.boton.addItemListener(itemListener);
        imagenC.boton.addItemListener(itemListener);
	}
	
	
	public boolean checkEsCorrecto(Boton a, Boton b, Boton c)
	{
		if (a.boton.isSelected() && b.boton.isSelected() && c.boton.isSelected()==false && a.id==1 && b.id==1)
		{
			System.out.println("Ganaste perri");
			return true;
		}
		
		else if (a.boton.isSelected() && c.boton.isSelected() && b.boton.isSelected()==false && a.id==1 && c.id==1 )
		{
			System.out.println("Ganaste perri");
			return true;
		}
		
		else if (b.boton.isSelected() && c.boton.isSelected() && a.boton.isSelected()==false && b.id==1 && c.id==1)
		{
			System.out.println("Ganaste perri");
			return true;
		}
		
		System.out.println("Loseer");
		return false;
		
	// COMPLETAR CON LA ACCION DE FINALIZAR LA VENTANA Y CARGAR NUEVAS IMAGENES 
	
	
	}
	
	
	public void ventanaOpcion1(JPanel p, Boton a, Boton b, Boton c)
	{
//		CREA IMAGENES
		ImageIcon icon = new ImageIcon("comer.jpg");
		a.setId(1);
		ImageIcon icon2 = new ImageIcon("neumatico.jpg");
		b.setId(0);
		ImageIcon icon3 = new ImageIcon("hamburguesa.jpg");
		c.setId(1);
//		ASIGNA IMAGENES AL JTOGGLEBUTTON
		Boton.setImagen(imagenA.boton, icon);
		imagenA.boton.setSize(icon.getIconWidth()+25, icon.getIconHeight()+25);
		
		Boton.setImagen(imagenB.boton, icon2);
		imagenB.boton.setSize(icon2.getIconWidth()+25, icon2.getIconHeight()+25);
		
		Boton.setImagen(imagenC.boton, icon3);
		imagenC.boton.setSize(icon3.getIconWidth()+25, icon3.getIconHeight()+25);
	}



	
}


