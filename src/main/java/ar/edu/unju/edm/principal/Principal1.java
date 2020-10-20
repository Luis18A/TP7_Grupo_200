package ar.edu.unju.edm.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
//import java.util.stream.Stream;
import java.util.stream.Collectors;

import ar.edu.unju.edm.model.Alumno;
import ar.edu.unju.edm.model.Materia;
import ar.edu.unju.edm.model.Nota;

public class Principal1 {

	public static void main(String[] args) {
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		List<Materia> materias = new ArrayList<Materia>();
		materias.add(new Materia(1, "POO", "cuatrimestral", "sexto"));
		materias.add(new Materia(2, "LSO","anual","quinto"));
		materias.add(new Materia(3, "Herramientas Informáticas","cuatrimestral","quinto"));
		materias.add(new Materia(4, "Fisica","anual","cuarto"));
		materias.add(new Materia(5, "Matemática","anual", "cuarto"));
//		se pueden agregar mas materias a la hora de agregar la nota de un alumno
		
		Scanner sc = new Scanner(System.in);
		int op=0;
		do {
			System.out.println("\n---------------------------MENU----------------------------");
			System.out.println("1. Dar de alta un alumno.");
			System.out.println("2. Realizar la búsqueda de un alumno para asignarle sus notas.");
			System.out.println("3. Buscar un alumno ingresando su dni y mostrar el promedio de notas y la nota más alta (valor máximo) por cada Materia.");
			System.out.println("4. Mostrar la lista de alumnos con sus respectivas notas.");
			System.out.println("5. Mostrar la lista de materias ingresando el curso.");
			System.out.println("6. Salir");
			System.out.println("\nIngrese opción: ");
			op=sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Ingrese dni: ");
				long dniIngresado = sc.nextLong();
//				se controla si existe el alumno
				boolean bander=false;
				for(Alumno alum: alumnos) {
					if(alum.getDni()==dniIngresado) {
						bander=true;		
					}
				}				
				if(bander==true) {
					System.out.println("\nEl alumno ya existe!");
				}
				else {
					Alumno alumno = new Alumno(); 
					alumno.setDni(dniIngresado);
					System.out.println("Ingrese nombre: ");
					alumno.setNombre(sc.next());
					System.out.println("Ingrese apellido: ");
					alumno.setApellido(sc.next());
					System.out.println("Ingrese día de fecha de nacimiento: ");
					int dia = sc.nextInt();
					System.out.println("Ingrese mes de fecha de nacimiento: ");
					int mes = sc.nextInt();
					System.out.println("Ingrese año de fecha de nacimiento: ");
					int anio = sc.nextInt();
					LocalDate fecha = LocalDate.of(anio, mes, dia);
					alumno.setFechaNac(fecha);
					System.out.println("Ingrese curso: ");
					alumno.setCurso(sc.next());
					alumnos.add(alumno);
					System.out.println("\nAlumno agregado con éxito!");
				}
				break;
			case 2:
				System.out.println("Ingrese DNI del alumno: ");
				long dniBuscado=sc.nextLong();
				int i=-1,index=0;
				boolean encontrado=false;
				for(Alumno alum:alumnos) {
					i++;
					if(alum.getDni()==dniBuscado) {
						index=i;
						encontrado=true;
					}
				}
				if(encontrado==true) {
					System.out.println("Ingrese orden de la nota: ");
					int ordenNotaIng = sc.nextInt();
//					se controla si existe la nota
					boolean bandera=false;
					for(Nota not: alumnos.get(index).getNotas()) {
						if(not.getOrden()==ordenNotaIng) {
							bandera=true;		
						}
					}				
					if(bandera==true) {
						System.out.println("\nEl orden de la nota ya existe!");
					}
					else {
					Nota nota = new Nota();
					nota.setOrden(ordenNotaIng);
					double notaI;
					do {
						System.out.println("Ingrese la nota (entre 1 y 10!): ");
						notaI=sc.nextDouble();
					}while(notaI<1 || notaI>10);
					nota.setNota(notaI);
					System.out.println("Ingrese día de registro de la nota: ");
					int dia=sc.nextInt();
					System.out.println("Ingrese mes de registro de la nota: ");
					int mes=sc.nextInt();
					System.out.println("Ingrese año de registro de la nota: ");
					int anio=sc.nextInt();
					LocalDate fecha = LocalDate.of(anio, mes, dia);
					nota.setFechaNota(fecha);
					System.out.println("\nIngrese código de la materia en la que desea registrar la nota, o agregue un código nuevo: ");
					int codMateriaIng = sc.nextInt();
//					se controla si existe la materia
					boolean band=false;
					int y=-1,ind=0;
					for(Materia mat: materias) {
						y++;
						if(mat.getCod()==codMateriaIng) {
							band=true;
							ind=y;
						}
					}	
					if(band==true) {
						nota.setMateria(materias.get(ind));
					}
					else {
						System.out.println("La materia no existe, se la agregará");
						Materia materia = new Materia();
						materia.setCod(codMateriaIng);
						System.out.println("Ingrese nombre de la materia: ");
						materia.setNombre(sc.next());
						System.out.println("Ingrese tipo (cuatrimetral o anual): ");
						materia.setTipo(sc.next());
						System.out.println("Ingrese el curso: ");
						materia.setCurso(sc.next());
						materias.add(materia);
						nota.setMateria(materia);
					}
					alumnos.get(index).getNotas().add(nota);
					}
				}
				else {
					System.out.println("\nEl alumno no existe!");
				}
//				for(int i=0; i<alumnos.size();i++) {
					// Compute sum of salaries of employee
					// int total = employees.stream()
					  // .collect(Collectors.summingInt(Employee::getSalary));
					//for(Nota notas : alumnos.get(i).getNotas()) {
					
//					if (alumnos.get(i).getDni()==dniBuscado) {
//						//DoubleSummaryStatistics pro=alumnos.get(i).getNotas().stream().collect(Collectors.summarizingDouble(Nota::getNota));						
//						//System.out.println("Promedio de Notas: "+ pro.getAverage()/(alumnos.get(i).getNotas().size()));;
//						System.out.println("Notas Maxima: " ); 
//						//List<Nota> notas=alumnos.get(i).getNotas().stream().distinct().forEach(nota->nota.getMateria).colect(Colectors.toList());;
//					}
//				}	
				System.out.println(materias);
				System.out.println(alumnos);
				break;
			case 3:
				System.out.println("Ingrese DNI del alumno: ");
				long dniBusc=sc.nextLong();
				int j=-1,ind=0;
				boolean encontrad=false;
				for(Alumno alum:alumnos) {
					j++;
					if(alum.getDni()==dniBusc) {
						ind=j;
						encontrad=true;
					}
				}
				if(encontrad==true) {
//					alumnos.get(ind).
					
					
				}
				else {
					System.out.println("\nEl alumno no existe!");
				}
				break;
			case 4:
				for(Alumno al:alumnos) {
					System.out.print(al.getNombre()+" "+al.getApellido()+": ");
					for(Nota not:al.getNotas()) {
						System.out.print(not.getNota()+" _ ");
					};
					System.out.println();
				}
				break;
			case 5: 
				System.out.println("Ingrese el curso para listar sus materias: ");
				String cursoIngresado = sc.next();
				boolean band=false;
				for(Materia materia:materias){
					if(materia.getCurso().equalsIgnoreCase(cursoIngresado)) {
						System.out.println("-"+materia.getNombre());
						band=true;
					}
				}
				if(band==false) {
					System.out.println("\nNo hay materias cargadas o ingresó mal el curso!");
				}
				break;
			case 6: System.out.println("Saliendo...");
				break;
			default: System.out.println("Opción inválida!");
				break;
			}
		}while(op!=6);
		
		
}
}