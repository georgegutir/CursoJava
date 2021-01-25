package UF2177.entidades;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Medicamentos {
		private Long id;
		private String nombre;
		private BigDecimal precio;
	
}
