package dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Data
public class ProductoDto {
    private Integer id;
    private String nombre;
    private BigDecimal number;

}
