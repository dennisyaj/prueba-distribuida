package db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="ordenCompras")
@Data
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal precio;
    @Column(name="cliente_id")
    private Integer clienteId;
    @Column(name="producto_id")
    private Integer productoId;
}
