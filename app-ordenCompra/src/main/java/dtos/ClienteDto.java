package dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ClienteDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;

}
