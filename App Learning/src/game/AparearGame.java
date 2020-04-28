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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AparearGame {

	public ArrayList<ArrayList<Boton>> imagenes; // almacena todas las imagenes en grupos para mostrar
//	public Boton imagenA;
//	public Boton imagenB;
//	public Boton imagenC;
	public JFrame frame;
//	public JPanel panel;

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
	 * Initialize the contents of the frame.
	 */

	
	public void ventanaAparearInicial ()
	{
		
		//CREA EL FRAME
		frame = new JFrame();
		frame.setBounds(400, 40, 403, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1090, 700);
		
		//CREA EL PANEL
		JPanel panel = new JPanel();
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
		

		Boton imagenA = new Boton();
		Boton imagenB = new Boton();
		Boton imagenC = new Boton();
		
		imagenA.boton.setBackground(Color.white);
		imagenB.boton.setBackground(Color.white);
		imagenC.boton.setBackground(Color.white);
		
		
		// UBICAR BOTONES EN EL JPANEL
		imagenA.boton.setBounds(142, 109, 212, 149);
		imagenB.boton.setBounds(371, 109, 212, 149);
		imagenC.boton.setBounds(598, 109, 212, 149);
		
//		CREA IMAGENES
		ImageIcon icon = new ImageIcon("comer.jpg");
		imagenA.setId(1);
		ImageIcon icon2 = new ImageIcon("neumatico.jpg");
		imagenB.setId(0);
		ImageIcon icon3 = new ImageIcon("hamburguesa.jpg");
		imagenC.setId(1);
//		ASIGNA IMAGENES AL JTOGGLEBUTTON
		Boton.setImagen(imagenA.boton, icon);
		imagenA.boton.setSize(icon.getIconWidth()+25, icon.getIconHeight()+25);
		
		Boton.setImagen(imagenB.boton, icon2);
		imagenB.boton.setSize(icon2.getIconWidth()+25, icon2.getIconHeight()+25);
		
		Boton.setImagen(imagenC.boton, icon3);
		imagenC.boton.setSize(icon3.getIconWidth()+25, icon3.getIconHeight()+25);

		
		panel.add(imagenA.boton);
		panel.add(imagenB.boton);
		panel.add(imagenC.boton);
		
		avisoPresionaBotonInicial(panel, imagenA, imagenB, imagenC);

	}
	
	public void checkEsCorrecto1(JPanel panel, Boton a, Boton b, Boton c)
	{
		if (a.boton.isSelected() && b.boton.isSelected() && c.boton.isSelected()==false && a.id==1 && b.id==1)
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
				frame.removeAll();
				frame.dispose();
				ventanaAparear2();
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		
		else if (a.boton.isSelected() && c.boton.isSelected() && b.boton.isSelected()==false && a.id==1 && c.id==1 )
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				frame.removeAll();
				frame.dispose();
				ventanaAparear2();
				
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		
		else if (b.boton.isSelected() && c.boton.isSelected() && a.boton.isSelected()==false && b.id==1 && c.id==1)
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
				frame.removeAll();
				ventanaAparear2();
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		

	// COMPLETAR CON LA ACCION DE FINALIZAR LA VENTANA Y CARGAR NUEVAS IMAGENES 
	
	}

	private void avisoPresionaBotonInicial(JPanel panel, Boton a, Boton b, Boton c) {
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
                	checkEsCorrecto1(panel, a, b, c);
                    System.out.println("Selected"); 
                } 
                else
                { 
                	checkEsCorrecto1(panel, a, b, c);
                    // else print deselected in console 
                    System.out.println("Deselected"); 
                } 
            }

			
        }; 
  
        // Attach Listeners 
        a.boton.addItemListener(itemListener);
        b.boton.addItemListener(itemListener);
        c.boton.addItemListener(itemListener);
        
	}

	public void ventanaAparear2()
	{
		
		//CREA EL FRAME
		frame = new JFrame();
		frame.setBounds(400, 40, 403, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1090, 700);
		
		//CREA EL PANEL
		JPanel panel = new JPanel();
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
		

		Boton imagenA = new Boton();
		Boton imagenB = new Boton();
		Boton imagenC = new Boton();
		
		imagenA.boton.setBackground(Color.white);
		imagenB.boton.setBackground(Color.white);
		imagenC.boton.setBackground(Color.white);
		
		
		// UBICAR BOTONES EN EL JPANEL
		imagenA.boton.setBounds(142, 109, 212, 149);
		imagenB.boton.setBounds(371, 109, 212, 149);
		imagenC.boton.setBounds(598, 109, 212, 149);
		
//		CREA IMAGENES
		ImageIcon icon = new ImageIcon("arco.jpg");
		imagenA.setId(1);
		ImageIcon icon2 = new ImageIcon("pelota.jpg");
		imagenB.setId(1);
		ImageIcon icon3 = new ImageIcon("dormir.jpg");
		imagenC.setId(0);
//		ASIGNA IMAGENES AL JTOGGLEBUTTON
		Boton.setImagen(imagenA.boton, icon);
		imagenA.boton.setSize(icon.getIconWidth()+25, icon.getIconHeight()+25);
		
		Boton.setImagen(imagenB.boton, icon2);
		imagenB.boton.setSize(icon2.getIconWidth()+25, icon2.getIconHeight()+25);
		
		Boton.setImagen(imagenC.boton, icon3);
		imagenC.boton.setSize(icon3.getIconWidth()+25, icon3.getIconHeight()+25);

		
		panel.add(imagenA.boton);
		panel.add(imagenB.boton);
		panel.add(imagenC.boton);
		
		avisoPresionaBoton2(panel, imagenA, imagenB, imagenC);

	}
	
	public void checkEsCorrecto2(JPanel panel, Boton a, Boton b, Boton c)
	{
		if (a.boton.isSelected() && b.boton.isSelected() && c.boton.isSelected()==false && a.id==1 && b.id==1)
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
				frame.removeAll();
				frame.dispose();
				ventanaAparear3();
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		
		else if (a.boton.isSelected() && c.boton.isSelected() && b.boton.isSelected()==false && a.id==1 && c.id==1 )
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				frame.removeAll();
				frame.dispose();
				ventanaAparear3();
				
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		
		else if (b.boton.isSelected() && c.boton.isSelected() && a.boton.isSelected()==false && b.id==1 && c.id==1)
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
				frame.removeAll();
				ventanaAparear3();
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		

	// COMPLETAR CON LA ACCION DE FINALIZAR LA VENTANA Y CARGAR NUEVAS IMAGENES 
	
	}

	private void avisoPresionaBoton2(JPanel panel, Boton a, Boton b, Boton c) {
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
                	checkEsCorrecto2(panel, a, b, c);
                    System.out.println("Selected"); 
                } 
                else
                { 
                	checkEsCorrecto2(panel, a, b, c);
                    // else print deselected in console 
                    System.out.println("Deselected"); 
                } 
            }

			
        }; 
  
        // Attach Listeners 
        a.boton.addItemListener(itemListener);
        b.boton.addItemListener(itemListener);
        c.boton.addItemListener(itemListener);
        
	}
	
	public void ventanaAparear3()
	{
		
		//CREA EL FRAME
		frame = new JFrame();
		frame.setBounds(400, 40, 403, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1090, 700);
		
		//CREA EL PANEL
		JPanel panel = new JPanel();
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
		

		Boton imagenA = new Boton();
		Boton imagenB = new Boton();
		Boton imagenC = new Boton();
		
		imagenA.boton.setBackground(Color.white);
		imagenB.boton.setBackground(Color.white);
		imagenC.boton.setBackground(Color.white);
		
		
		// UBICAR BOTONES EN EL JPANEL
		imagenA.boton.setBounds(142, 109, 212, 149);
		imagenB.boton.setBounds(371, 109, 212, 149);
		imagenC.boton.setBounds(598, 109, 212, 149);
		
//		CREA IMAGENES
		ImageIcon icon = new ImageIcon("avion.jpg");
		imagenA.setId(0);
		ImageIcon icon2 = new ImageIcon("perro 1.jpg");
		imagenB.setId(1);
		ImageIcon icon3 = new ImageIcon("perro 2.jpg");
		imagenC.setId(1);
//		ASIGNA IMAGENES AL JTOGGLEBUTTON
		Boton.setImagen(imagenA.boton, icon);
		imagenA.boton.setSize(icon.getIconWidth()+25, icon.getIconHeight()+25);
		
		Boton.setImagen(imagenB.boton, icon2);
		imagenB.boton.setSize(icon2.getIconWidth()+25, icon2.getIconHeight()+25);
		
		Boton.setImagen(imagenC.boton, icon3);
		imagenC.boton.setSize(icon3.getIconWidth()+25, icon3.getIconHeight()+25);

		
		panel.add(imagenA.boton);
		panel.add(imagenB.boton);
		panel.add(imagenC.boton);
		
		avisoPresionaBoton3(panel, imagenA, imagenB, imagenC);

	}
	
	public void checkEsCorrecto3(JPanel panel, Boton a, Boton b, Boton c)
	{
		if (a.boton.isSelected() && b.boton.isSelected() && c.boton.isSelected()==false && a.id==1 && b.id==1)
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
				frame.removeAll();
				frame.dispose();
				ventanaAparear3();
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		
		else if (a.boton.isSelected() && c.boton.isSelected() && b.boton.isSelected()==false && a.id==1 && c.id==1 )
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				frame.removeAll();
				frame.dispose();
				ventanaAparear3();
				
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		
		else if (b.boton.isSelected() && c.boton.isSelected() && a.boton.isSelected()==false && b.id==1 && c.id==1)
		{
			int n = JOptionPane.showConfirmDialog
			(panel, "Ganaste!!","Deseas continuar jugando?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
				frame.removeAll();
				ventanaAparear2();
			}
			else
			{
				frame.dispose();
				frame.removeAll();
			}
		}
		

	// COMPLETAR CON LA ACCION DE FINALIZAR LA VENTANA Y CARGAR NUEVAS IMAGENES 
	
	}

	private void avisoPresionaBoton3(JPanel panel, Boton a, Boton b, Boton c) {
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
                	checkEsCorrecto3(panel, a, b, c);
                    System.out.println("Selected"); 
                } 
                else
                { 
                	checkEsCorrecto3(panel, a, b, c);
                    // else print deselected in console 
                    System.out.println("Deselected"); 
                } 
            }

			
        }; 
  
        // Attach Listeners 
        a.boton.addItemListener(itemListener);
        b.boton.addItemListener(itemListener);
        c.boton.addItemListener(itemListener);
        
	}
	
	
	
}


