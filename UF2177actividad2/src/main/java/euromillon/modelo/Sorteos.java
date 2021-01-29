package euromillon.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Sorteos {
	private Long id;
	private String num1, num2, num3, num4, num5;
	private String star1, star2;
	private LocalDate fechasorteo;
}
