package euromillon.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import euromillon.modelo.Sorteos;

public class SorteosDaoJdbc implements Dao<Sorteos>{
	private String url, usuario, password;

	private static final SorteosDaoJdbc INSTANCIA = new SorteosDaoJdbc();

	private static final String SQL_SELECT = "SELECT * FROM sorteos";

	private static final String SQL_INSERT = "INSERT INTO sorteos (num1, num2, num3, num4, num5, star1, star2, fechasorteo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	private SorteosDaoJdbc() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			
			Class.forName(props.getProperty("jdbc.driver"));
			
			url = props.getProperty("jdbc.url");
			usuario = props.getProperty("jdbc.usuario");
			password = props.getProperty("jdbc.password");
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración jdbc.properties", e);
		}
	}

	public static SorteosDaoJdbc getInstancia() {
		return INSTANCIA;
	}

	private Connection getConexion() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Fallo de conexión", e);
		}
	}
	
	@Override
	public Iterable<Sorteos> obtenerTodos() {
		try (Connection con = getConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Sorteos> sorteos = new ArrayList<>();
			Sorteos sorteo;
			
			while(rs.next()) {
				sorteo = new Sorteos(rs.getLong("id"), rs.getInt("num1"), rs.getInt("num2"), rs.getInt("num3"), rs.getInt("num4"), rs.getInt("num5"), rs.getInt("star1"), rs.getInt("star2"), rs.getDate("fechasorteo"));
				
				sorteos.add(sorteo);
			}
			
			return sorteos;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los registros de medicamentos", e);
		}
	}
	
	@Override
	public Sorteos agregar(Sorteos sorteo) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			
			pst.setInt(1, sorteo.getNum1());
			pst.setInt(2, sorteo.getNum2());
			pst.setInt(3, sorteo.getNum3());
			pst.setInt(4, sorteo.getNum4());
			pst.setInt(5, sorteo.getNum5());
			pst.setInt(6, sorteo.getStar1());
			pst.setInt(7, sorteo.getStar2());
			pst.setDate(8, new java.sql.Date(sorteo.getFechasorteo().getTime()));
			
			int num = pst.executeUpdate();
			
			if(num != 1) {
				throw new AccesoDatosException("Se ha insertado más/menos de un registro");
			}
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				sorteo.setId(rs.getLong(1));
			} else {
				throw new AccesoDatosException("No se han podido obtener las claves autogeneradas");
			}
			
			return sorteo;
			
		} catch (Exception e) {
			throw new AccesoDatosException("Error al agregar el registro a sorteos", e);
		}
	}

}
