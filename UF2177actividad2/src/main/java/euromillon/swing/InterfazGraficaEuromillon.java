package euromillon.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import euromillon.Actividad2Application;
import euromillon.accesodatos.SorteosDao;
import euromillon.accesodatos.SorteosMySqlDao;
import euromillon.modelo.Sorteos;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SpringBootApplication
public class InterfazGraficaEuromillon implements CommandLineRunner{

	private SorteosMySqlDao dao = SorteosMySqlDao.getInstancia();
	private Long id = null;
	
	private JFrame frame;
	private JTextField Num1;
	private JTextField Num2;
	private JTextField Num3;
	private JTextField Num4;
	private JTextField Num5;
	private JTextField Star1;
	private JTextField Star2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Actividad2Application.class, args);
		
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
		
		//Despues de cargar todo el formulario
	}
	
	
	/**
	 * implementación tareas dem los botones
	 */
	private void btnGuardarClick() {
		Sorteos sorteo = new Sorteos(null, Num1.getText(), Num2.getText(), Num3.getText(), Num4.getText(), Num5.getText(),
				Star1.getText(), Star2.getText(), new BigDecimal(tfPrecio.getText()));

			dao.agregar(sorteo);

		cargarTabla();
	}
	
	private void btnConsultarClick() {
		Sorteos sorteo: dao.obtenerTodos()
		
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
		Num1.setBounds(58, 76, 49, 19);
		frame.getContentPane().add(Num1);
		Num1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Número 2:");
		lblNewLabel_2_1.setBounds(131, 76, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		Num2 = new JTextField();
		Num2.setColumns(10);
		Num2.setBounds(179, 73, 49, 19);
		frame.getContentPane().add(Num2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Número 3:");
		lblNewLabel_2_2.setBounds(238, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		Num3 = new JTextField();
		Num3.setColumns(10);
		Num3.setBounds(286, 76, 49, 19);
		frame.getContentPane().add(Num3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Número 4:");
		lblNewLabel_2_3.setBounds(363, 79, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		Num4 = new JTextField();
		Num4.setColumns(10);
		Num4.setBounds(411, 76, 49, 19);
		frame.getContentPane().add(Num4);
		
		JLabel lblNewLabel_2_4 = new JLabel("Número 5:");
		lblNewLabel_2_4.setBounds(500, 76, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		Num5 = new JTextField();
		Num5.setColumns(10);
		Num5.setBounds(548, 73, 49, 19);
		frame.getContentPane().add(Num5);
		
		JLabel lblNewLabel_2_5 = new JLabel("Estrella 1:");
		lblNewLabel_2_5.setBounds(10, 128, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		Star1 = new JTextField();
		Star1.setColumns(10);
		Star1.setBounds(58, 125, 49, 19);
		frame.getContentPane().add(Star1);
		
		JLabel lblNewLabel_2_6 = new JLabel("Estrella 2:");
		lblNewLabel_2_6.setBounds(131, 128, 59, 13);
		frame.getContentPane().add(lblNewLabel_2_6);
		
		Star2 = new JTextField();
		Star2.setColumns(10);
		Star2.setBounds(179, 125, 49, 19);
		frame.getContentPane().add(Star2);
		
		JButton Guardar = new JButton("Guardar sorteo");
		Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardarClick();
			}
		});
		Guardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		Guardar.setBounds(273, 117, 155, 32);
		frame.getContentPane().add(Guardar);
		
		JButton Consultar = new JButton("Historial sorteos");
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarClick();
			}
		});
		Consultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		Consultar.setBounds(442, 117, 155, 32);
		frame.getContentPane().add(Consultar);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
