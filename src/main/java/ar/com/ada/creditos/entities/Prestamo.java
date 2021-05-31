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

    @Column (name="estado_id")
    private int estadoId;

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

    //ENUMERADO es un tipo de clase
    public EstadoPrestamoEnum getEstadoId() {

        return EstadoPrestamoEnum.parse(this.estadoId); //devuelve un estado no un int
                                                    //si estadoId=2 devuelve rechazado
    }

    public void setEstadoId(EstadoPrestamoEnum estadoId) { //pasamos un parametro tipo enumerado
                                                        //pero guardamos como int en estadoId
        this.estadoId = estadoId.getValue();
    }

    public enum EstadoPrestamoEnum {
        SOLICITADO(1), //estos son constructores con un solo parametro
        RECHAZADO(2),
        PENDIENTE_APROBACION(3),
        APROBADO(4),
        INCOBRABLE(5),
        CANCELADO(6),
        PREAPROBADO(100);

        private final int value;//variable con la que se va a mappear?

        // NOTE: Enum constructor tiene que estar en privado
        private EstadoPrestamoEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static EstadoPrestamoEnum parse(int id) {
            EstadoPrestamoEnum status = null; // Default
            for (EstadoPrestamoEnum item : EstadoPrestamoEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

   





}
