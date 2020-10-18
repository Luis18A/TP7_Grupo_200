package ar.edu.unju.edm.model;

public class Materia {

	private int cod;
	private String nombre;
	private String tipo;
	private String curso;
	
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Materia [cod=" + cod + ", nombre=" + nombre + ", tipo=" + tipo + ", curso=" + curso + "]";
	}
	public Materia(int cod, String nombre, String tipo, String curso) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.tipo = tipo;
		this.curso = curso;
	}
	
	
	
	
	
}
