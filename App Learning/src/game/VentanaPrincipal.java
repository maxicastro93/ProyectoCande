package game;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentanaPrincipal {

	private JFrame frame;
	public Colors juegoColor;
	private AparearGame juegoAparear;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaPrincipal() 
	{
		initialize();
	}

	private void initialize() 
	{
		juegoColor = new Colors();
		juegoAparear = new AparearGame();
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton botonColores = new JButton("Colores");
		botonColores.setBounds(84, 109, 157, 102);
		botonColores.setIcon(null);
		
		// COLOCAR EL PRIMER COLOR
		juegoColor.cargaColores();
				
		botonColores.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				juegoColor.ventana1(juegoColor.colorAleatorio());
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(botonColores);
		
		JLabel tituloPrincipal = new JLabel("Seleccione el Juego");
		tituloPrincipal.setBounds(59, 31, 661, 62);
		tituloPrincipal.setForeground(Color.RED);
		tituloPrincipal.setFont(new Font("Consolas", Font.PLAIN, 30));
		tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(tituloPrincipal);
		
		JButton botonAparear = new JButton("Aparear");
		botonAparear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				juegoAparear.ventanaAparearInicial();
			}
		});
		botonAparear.setBounds(271, 109, 157, 102);
		frame.getContentPane().add(botonAparear);
		
		JButton button = new JButton("x");
		button.setBounds(460, 109, 157, 102);
		frame.getContentPane().add(button);
		

		
	}
}
	
