package br.com.fiap.postech.soat.techchallenger1.domain.model;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoId implements Serializable {
    @JoinColumn(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @JoinColumn(name = "produto", nullable = false)
    private Long produto;
}
