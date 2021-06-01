package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="cancelacion")
public class Cancelacion {

    @Id
    @Column(name="cancelacion_id")
    private int cancelacionId;

    @ManyToOne//muchas cacelacion para 1 prestamo
    @JoinColumn(name="prestamo_id",referencedColumnName = "prestamo_id")//como se llama en esta y en la otra
    private Prestamo prestamo; //no es de tipo int 

    @Column(name="fecha_cancelacion")
    private Date fechaCancelacion;

    private BigDecimal importe;

    private int cuota;




    public int getCancelacionId() {
        return cancelacionId;
    }

    public void setCancelacionId(int cancelacionId) {
        this.cancelacionId = cancelacionId;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.prestamo.getCancelaciones().add(this);//relacion bidroeccional
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }


    
}
