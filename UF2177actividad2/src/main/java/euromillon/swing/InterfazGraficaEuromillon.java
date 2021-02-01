package euromillon.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import euromillon.accesodatos.SorteosDaoJdbc;
import euromillon.modelo.Sorteos;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class InterfazGraficaEuromillon{

	private SorteosDaoJdbc dao = SorteosDaoJdbc.getInstancia();
	
	private JFrame frame;
	private JTextField Num1;
	private JTextField Num2;
	private JTextField Num3;
	private JTextField Num4;
	private JTextField Num5;
	private JTextField Star1;
	private JTextField Star2;
	private JTextField fechasorteo;

	private JTable table;
	private DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGraficaEuromillon window = new InterfazGraficaEuromillon();
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
	public InterfazGraficaEuromillon() {
		initialize();
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Num1", "Num2", "Num3", "Num4", "Num5", "Star1", "Star2", "Fecha"});

		table.setModel(modelo);
		//Despues de cargar todo el formulario
	}
	
	/**
	 * implementación tareas de los botones
	 */
	private void btnGuardarClick() {
		int num1, num2, num3, num4, num5, star1, star2;
		Date fecha = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
		
		num1 = Integer.parseInt(Num1.getText());
		num2 = Integer.parseInt(Num2.getText());
		num3 = Integer.parseInt(Num3.getText());
		num4 = Integer.parseInt(Num4.getText());
		num5 = Integer.parseInt(Num5.getText());
		star1 = Integer.parseInt(Star1.getText());
		star2 = Integer.parseInt(Star2.getText());
		
		try {
			System.out.println(fecha);
			fecha = formato.parse(fechasorteo.getText());
			Sorteos sorteo = new Sorteos(null, num1, num2, num3, num4, num5, star1, star2, fecha);

			dao.agregar(sorteo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnConsultarClick() {
		modelo.setRowCount(0);

		modelo.addRow(new Object[] { "Id", "Num1", "Num2", "Num3", "Num4", "Num5", "Star1", "Star2", "Fecha" });

		for (Sorteos sorteo : dao.obtenerTodos()) {

			modelo.addRow(new Object[] { sorteo.getId(), sorteo.getNum1(), sorteo.getNum2(), sorteo.getNum3(), sorteo.getNum4(), sorteo.getNum5(),
					sorteo.getStar1(), sorteo.getStar2(), sorteo.getFechasorteo() });
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¡¡¡EUROMILLÓN!!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(228, 10, 200, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduzca los nº del sorteo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 56, 193, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Introduzca las estrellas:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 102, 193, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número 1:");
		lblNewLabel_2.setBounds(10, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		Num1 = new JTextField();
		Num1.setBounds(72, 79, 49, 19);
		frame.getContentPane().add(Num1);
		Num1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Número 2:");
		lblNewLabel_2_1.setBounds(131, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		Num2 = new JTextField();
		Num2.setColumns(10);
		Num2.setBounds(197, 76, 49, 19);
		frame.getContentPane().add(Num2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Número 3:");
		lblNewLabel_2_2.setBounds(256, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		Num3 = new JTextField();
		Num3.setColumns(10);
		Num3.setBounds(314, 76, 49, 19);
		frame.getContentPane().add(Num3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Número 4:");
		lblNewLabel_2_3.setBounds(383, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		Num4 = new JTextField();
		Num4.setColumns(10);
		Num4.setBounds(441, 76, 49, 19);
		frame.getContentPane().add(Num4);
		
		JLabel lblNewLabel_2_4 = new JLabel("Número 5:");
		lblNewLabel_2_4.setBounds(500, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		Num5 = new JTextField();
		Num5.setColumns(10);
		Num5.setBounds(566, 76, 49, 19);
		frame.getContentPane().add(Num5);
		
		JLabel lblNewLabel_2_5 = new JLabel("Estrella 1:");
		lblNewLabel_2_5.setBounds(10, 128, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		Star1 = new JTextField();
		Star1.setColumns(10);
		Star1.setBounds(72, 125, 49, 19);
		frame.getContentPane().add(Star1);
		
		JLabel lblNewLabel_2_6 = new JLabel("Estrella 2:");
		lblNewLabel_2_6.setBounds(144, 128, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_6);
		
		Star2 = new JTextField();
		Star2.setColumns(10);
		Star2.setBounds(207, 125, 49, 19);
		frame.getContentPane().add(Star2);
		
		JButton Guardar = new JButton("Guardar sorteo");
		Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardarClick();
			}
		});
		Guardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		Guardar.setBounds(131, 163, 155, 32);
		frame.getContentPane().add(Guardar);
		
		JButton Consultar = new JButton("Historial sorteos");
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarClick();
			}
		});
		Consultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		Consultar.setBounds(338, 163, 155, 32);
		frame.getContentPane().add(Consultar);
		
		table = new JTable();
		table.setBounds(10, 205, 605, 222);
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(441, 128, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		fechasorteo = new JTextField();
		fechasorteo.setBounds(483, 125, 132, 19);
		frame.getContentPane().add(fechasorteo);
		fechasorteo.setColumns(10);
	}
}
