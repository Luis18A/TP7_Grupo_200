package ar.edu.unju.edm.model;

import java.time.LocalDate;

public class Nota {

	private int orden;
	private double nota;
	private LocalDate fechaNota;
	private Materia materia;
	
	
	
	public Nota() {
		// TODO Auto-generated constructor stub
	}
	
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public LocalDate getFechaNota() {
		return fechaNota;
	}
	public void setFechaNota(LocalDate fechaNota) {
		this.fechaNota = fechaNota;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	@Override
	public String toString() {
		return "Nota [orden=" + orden + ", nota=" + nota + ", fechaNota=" + fechaNota + ", materia=" + materia + "]";
	}
	public Nota(int orden, double nota, LocalDate fechaNota, Materia materia) {
		super();
		this.orden = orden;
		this.nota = nota;
		this.fechaNota = fechaNota;
		this.materia = materia;
	}
	
	
	
	
	
	
}
