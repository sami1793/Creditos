package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
//import java.sql.Date;//no se porque se me puso este
//import java.util.Date;---->preguntar esto a profe
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @Column(name="prestamo_id")//si el nombre es diferente al que está en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//cuando es autoincremental
    private int prestamoId;

    @Column(name="fecha_prestamo")
    @Temporal(TemporalType.DATE)//fechas que NO tienen hora
    private Date fecha;

    private BigDecimal importe;

    private int cuotas;

    @Column(name="fecha_alta")
    private Date fechaAlta;

    @ManyToOne//join column van donde esta la FK, muchos prestamos 1 cliente
    @JoinColumn(name="cliente_id", referencedColumnName = "cliente_id")//en la otra tabla mappin
    private Cliente cliente;//cliente_id es de tipo Cliente

    
    //GETTERS Y SETTERS
    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        //con esto hago una relación BIDORECCIONAL
        this.cliente.getPrestamos().add(this);
        //this.cliente.agregarPrestamo(this);//BIDIRECCIONAL con funcion 
    }

   





}
