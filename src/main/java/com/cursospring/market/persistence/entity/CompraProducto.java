package com.cursospring.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
    @EmbeddedId
    private CompraProductoPK id;
    private Integer cantidad;
    private Float total;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Compra compra;

    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
