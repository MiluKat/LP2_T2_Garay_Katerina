package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmpleadoEntity {

	@Id
	@Column (name = "dni_empleado",
			nullable = false,
			length = 8,
			columnDefinition ="CHAR(8)",
			unique = true)
	private String dniEmp;
	
	@Column (name = "nombre_empleado", nullable = false, length = 45)
	private String nomEmp;
	
	@Column (name = "apellido_empleado", nullable = false, length = 45)
	private String apeEmp;
	
	@Column (name = "fecha_nacimiento", nullable = false, length = 45) 
	/*@Temporal(TemporalType.TIMESTAMP)*/
	private String fechaNac;
	
	@Column (name = "direccion", length = 45)
	private String direccion;
	
	@Column(name = "correo", nullable = false, unique = true, length = 45)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name="id_area", nullable = false)
	private AreaEntity areaEntity;
	
	
}
