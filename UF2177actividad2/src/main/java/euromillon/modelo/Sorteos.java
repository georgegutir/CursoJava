package euromillon.modelo;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Sorteos {
	@Min(1)
	private Long id;
	@Min(1)
	@Max(50)
	@NotBlank
	private Integer num1, num2, num3, num4, num5;
	@Min(1)
	@Max(12)
	@NotBlank
	private Integer star1, star2;
	@NotBlank
	private Date fechasorteo;
}
