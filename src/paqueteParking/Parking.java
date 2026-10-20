package paqueteParking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Parking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int coches;
	private JLabel etiCoches;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parking frame = new Parking();
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
	public Parking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntro = new JButton("Entró un coche");
		btnEntro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Le suma 1 a la variable global
				coches = coches + 1;
				// Muestra el nuevo número en la etiqueta (se pone ""+ para convertir el número a texto)
				etiCoches.setText("" + coches);
			}
		});
		btnEntro.setBounds(10, 32, 116, 22);
		contentPane.add(btnEntro);
		
		JButton btnSalio = new JButton("Salió un coche");
		btnSalio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// El if evita que el contador baje a números negativos (no puede haber -1 coches)
				if (coches > 0) {
				    coches = coches - 1;
				    etiCoches.setText("" + coches);
				}
			}
		});
		btnSalio.setBounds(10, 70, 116, 22);
		contentPane.add(btnSalio);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Devuelve el contador a cero directamente
				coches = 0;
				etiCoches.setText("0");
			}
		});
		btnReiniciar.setBounds(10, 110, 116, 22);
		contentPane.add(btnReiniciar);
		
		JLabel lblNewLabel = new JLabel("Coches en el parking");
		lblNewLabel.setBounds(10, 206, 140, 46);
		contentPane.add(lblNewLabel);
		
		etiCoches = new JLabel("0");
		etiCoches.setBorder(new LineBorder(new Color(0, 0, 0)));
		etiCoches.setBounds(153, 206, 50, 46);
		contentPane.add(etiCoches);
		coches = 0;
	}
}
