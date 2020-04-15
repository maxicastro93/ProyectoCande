import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

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
		frame.setSize(1100, 1000);
		
		//CREA EL PANEL
		this.panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(100, 100, 901, 650);
		this.frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//TITULO DE LA VENTANA
		JLabel tituloVentana = new JLabel("Seleccionar las imagenes relacionadas");
		tituloVentana.setBounds(170, -100, 400, 300);
		tituloVentana.setFont(new Font("Consolas", Font.PLAIN, 30));
		tituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		tituloVentana.setForeground(Color.BLACK);
		panel.add(tituloVentana);
		
		this.frame.setVisible(true);
		
		imagenA = new Boton(0);
		imagenB = new Boton(1);
		imagenC = new Boton(2);
		// UBICAR BOTONES EN EL JPANEL
		this.imagenA.boton.setBounds(42, 109, 212, 149);
		this.imagenB.boton.setBounds(271, 109, 212, 149);
		this.imagenC.boton.setBounds(498, 109, 212, 149);
		
		panel.add(imagenA.boton);
		panel.add(imagenB.boton);
		panel.add(imagenC.boton);
		

        // ItemListener is notified whenever you clcik on the ToggleButton 
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

        
        
        
        
//		JButton botonColores = new JButton("Colores");
//		botonColores.setBounds(84, 109, 157, 102);
//		botonColores.setIcon(null);
//		panel.add(botonColores);
//		
//		JButton botonAparear = new JButton("Aparear");
//		botonAparear.setBounds(271, 109, 157, 102);
//		panel.add(botonAparear);
//		ArrayList<Boton> x = ventanaOpcion2();
//		panel.add(x.get(0).boton);
//		panel.add(x.get(1).boton);
//		panel.add(x.get(2).boton);
		
		
			
			

	}
	public boolean checkEsCorrecto(Boton a, Boton b, Boton c)
	{
		if (a.boton.isSelected() && b.boton.isSelected() && c.boton.isSelected()==false)
		{
			System.out.println("Ganaste perri");
			return true;
		}
		System.out.println("Loseer");
		return false;
	// COMPLETAR CON LA ACCION DE FINALIZAR LA VENTANA Y CARGAR NUEVAS IMAGENES 
	
	
	}



	
}


