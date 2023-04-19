package org.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Integer id;
    @Column(name = "ct_idpaciente")
    private Integer id_paciente;
    @Column(name = "ct_idmedico")
    private Integer id_medico;
    @Column(name = "ct_fecha")
    private Date fecha;
    @Column(name = "ct_hora")
    private Time hora;

    public Citas() {
    }

    public Citas(Integer id_paciente, Integer id_medico, Date fecha, Time hora) {
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citas citas = (Citas) o;
        return Objects.equals(id, citas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
