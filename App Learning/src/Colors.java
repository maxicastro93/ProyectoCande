import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Colors {

	public JFrame frame;
	public ArrayList<HashMap<String, Color>> codigoColores;
	public Colors color;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Colors window = new Colors();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Colors() 
	{
		
		codigoColores = new ArrayList<HashMap<String, Color>> ();


	}

	
	public void ventana1 (String colorInicial)
	{

		frame = new JFrame();
		frame.setBounds(400, 40, 403, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1100, 1000);
		
		this.panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(100, 100, 901, 650);
		this.frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel nombreColor = new JLabel(colorInicial);
		nombreColor.setBounds(170, -100, 400, 300);
		nombreColor.setFont(new Font("Consolas", Font.PLAIN, 30));
		nombreColor.setHorizontalAlignment(SwingConstants.CENTER);
		nombreColor.setForeground(Color.BLACK);
		panel.add(nombreColor);
		
		JButton color1 = new JButton();
		JButton color2 = new JButton();
		
		color1.setBounds(405, 176, 266, 238);
		color2.setBounds(67, 176, 266, 238);
	
		Color c1 = buscaCodigoColor(colorInicial, this.codigoColores);
		Color c2 = null;
		
		while(c2 == c1 || c2 == null)
			c2 = buscaCodigoColor(colorAleatorio(), this.codigoColores);
			
		Random r = new Random();
		int numRand = r.nextInt(6);
		int a = numRand;
		if(a==0)
		{
			color1.setBackground(c2);
			color1.setForeground(c2);
			color2.setForeground(c1);
			color2.setBackground(c1);
		}
		else
		{
			color1.setBackground(c1);
			color1.setForeground(c1);
			color2.setForeground(c2);
			color2.setBackground(c2);
		}
		
		panel.add(color1);
		panel.add(color2);
		this.frame.setVisible(true);

		color1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(color1.getBackground() == buscaCodigoColor(nombreColor.getText(), codigoColores))
				{
					int n = JOptionPane.showConfirmDialog
					(panel, "Ganaste!!","Deseas intentarlo nuevamente?", JOptionPane.YES_NO_OPTION);
					if(n == JOptionPane.YES_OPTION)
					{
						frame.dispose();
						ventana1(colorAleatorio());
					}
					else
						frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Color Incorrecto, vuelve a intentarlo :) ");
					frame.repaint();
					frame.dispose();
					ventana1(colorAleatorio());
				}
			}
		});
		color2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(color2.getBackground() == buscaCodigoColor(nombreColor.getText(), codigoColores))
				{
					int n = JOptionPane.showConfirmDialog
					(panel, "Ganaste!!","Intentar nuevamente?", JOptionPane.YES_NO_OPTION);
					
					if(n == JOptionPane.YES_OPTION)
					{
						frame.repaint();
						frame.dispose();
						ventana1(colorAleatorio());
					}
					else
						frame.dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(panel, "Color Incorrecto, vuelve a intentarlo :) ");
					frame.repaint();
					frame.dispose();
					ventana1(colorAleatorio());
				
				}
			}
		});
		
	}
	
	
	public void cargaColores()
	{
		HashMap<String, Color> rojo = new HashMap<String,Color>();
		rojo.put("Rojo", Color.RED);
		HashMap<String, Color> azul = new HashMap<String,Color>();
		rojo.put("Azul", Color.BLUE);
		HashMap<String, Color> verde = new HashMap<String,Color>();
		rojo.put("Verde", Color.GREEN);
		HashMap<String, Color> amarillo = new HashMap<String,Color>();
		rojo.put("Amarillo", Color.YELLOW);
		HashMap<String, Color> naranja = new HashMap<String,Color>();
		rojo.put("Naranja", Color.ORANGE);
		HashMap<String, Color> rosa = new HashMap<String,Color>();
		rojo.put("Rosa", Color.PINK);
		HashMap<String, Color> negro = new HashMap<String,Color>();
		rojo.put("Negro", Color.BLACK);
		codigoColores.add(rojo);
		codigoColores.add(azul);
		codigoColores.add(verde);
		codigoColores.add(amarillo);
		codigoColores.add(naranja);
		codigoColores.add(rosa);
		codigoColores.add(negro);
	}
	
	public String colorAleatorio()
	{
		ArrayList<String> listaColores = new ArrayList<String>();
		listaColores.add("Rojo");
		listaColores.add("Azul");
		listaColores.add("Verde");
		listaColores.add("Amarillo");
		listaColores.add("Naranja");
		listaColores.add("Rosa");
		listaColores.add("Negro");
		
		Random r = new Random();
		int numAleatorio = r.nextInt(7);
		System.out.println(listaColores.get(numAleatorio));
		return listaColores.get(numAleatorio);
	}
	
	public Color buscaCodigoColor (String c, ArrayList<HashMap<String, Color>> paleta)
	{
		for (int i = 0; i < paleta.size(); i++)
		{
			if(paleta.get(i).containsKey(c))
			{
				return paleta.get(i).get(c);
			}
		}
		
		return null;
			
	}
}


