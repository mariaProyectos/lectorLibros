import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LectorLibroUno extends JFrame {

	protected JPanel contentPane;
	protected JButton btnMarca;
	protected JButton adelante;
	protected JTextArea txtrLaMejorHistoria;
	protected JButton atras;
	
	File archivo=new File("JuegoTronos.txt");
	FileReader flujo=null;
	BufferedReader bufer=null;
	char[] lector=new char[110];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LectorLibroUno frame = new LectorLibroUno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LectorLibroUno() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtrLaMejorHistoria = new JTextArea();
		txtrLaMejorHistoria.setFont(new Font("Monospaced", Font.PLAIN, 17));
		panel.add(txtrLaMejorHistoria);
//		Hace un salto de linea si detecta que llega al borde del area
		txtrLaMejorHistoria.setLineWrap(true);
//		detecta si es una palabra o no
		txtrLaMejorHistoria.setWrapStyleWord(true);
		System.out.println(txtrLaMejorHistoria.getFont().getSize());
		System.out.println(txtrLaMejorHistoria.getHeight());
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnMarca = new JButton("marca");
		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnMarca);
		
		adelante = new JButton("adelante");
		adelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("el tamaño "+txtrLaMejorHistoria.getHeight());
//				System.out.println("lo ocupado actualmente "+txtrLaMejorHistoria.getPreferredSize().getHeight());
//				txtrLaMejorHistoria.append("la primera cosa que se escribee es la mejor y ademas quiero ocupar mas espacio en la ventana"
//						+ "ahora voy a escribir una linea mucho mas larga con la intencion de que sobrepase no solo el tamaño actual de la ventana si no que"
//						+ "ademas queremos sobrepasar con mucho lo que seria una pagina para poder probar que esta funcionalidad en realidad hace lo que"
//						+ " tiene que hacer");
				
				if(archivo.exists())
					try {
						
						bufer.reset();
						System.out.println("empieza la lectura");
						bufer.read(lector);
						txtrLaMejorHistoria.setText(new String(lector));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}catch (IOException e1) {
						e1.printStackTrace();
					}
			}
			
			
		});
		panel_1.add(adelante);
		
		atras = new JButton("atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(atras);
	}
}
