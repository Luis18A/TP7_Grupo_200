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
import ar.edu.unju.edm.model.Nota;

public class Principal1 {

	public static void main(String[] args) {
//		LocalDate fecha = new LocalDate.of(01,01,2001); 
		List<Alumno> alumnos = new ArrayList<Alumno>();
//		alumnos.add(1, new Alumno("Martín", "Casas", 42468749,10.0,"rpoew"));
		Scanner sc = new Scanner(System.in);
		int op=0;
		do {
			System.out.println("---------------------------MENU----------------------------");
			System.out.println("1. Dar de alta un alumno.");
			System.out.println("2. Realizar la búsqueda de un alumno para asignarle sus notas.");
			System.out.println("3. Buscar un alumno ingresando su dni y mostrar el promedio de notas y la nota más alta (valor máximo) por cada Materia.");
			System.out.println("4. Mostrar la lista de alumnos con sus respectivas notas.");
			System.out.println("5. Mostrar la lista de materias ingresando el curso.");
			System.out.println("6. Salir");
			System.out.println("Ingrese opción: ");
				op=sc.nextInt();
			switch(op) {
			case 1:
				Alumno alumno = new Alumno(); 
				System.out.println("Ingrese dni: ");
				long dniIngresado = sc.nextLong();
				System.out.println("prueba");
////				se controla si existe el alumno
//				boolean bander=false;
//				for(Alumno alum: alumnos) {
//					if(alum.getDni()==dniIngresado) {
//						bander=true;
//					}
//				}
//				if(bander==true) {
//					System.out.println("\nEl alumno ya existe!");
//				}
//				else {
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
					System.out.println("Alumno agregado con éxito!");
//				}

				break;
			case 2:
				System.out.println("Ingrese Dni: ");dniIngresado=sc.nextLong();
				for(int i=0; i<alumnos.size();i++) {
					// Compute sum of salaries of employee
					// int total = employees.stream()
					  // .collect(Collectors.summingInt(Employee::getSalary));
					//for(Nota notas : alumnos.get(i).getNotas()) {
					
					if (alumnos.get(i).getDni()==dniIngresado) {
						//DoubleSummaryStatistics pro=alumnos.get(i).getNotas().stream().collect(Collectors.summarizingDouble(Nota::getNota));						
						//System.out.println("Promedio de Notas: "+ pro.getAverage()/(alumnos.get(i).getNotas().size()));;
						System.out.println("Notas Maxima: " ); 
						//List<Nota> notas=alumnos.get(i).getNotas().stream().distinct().forEach(nota->nota.getMateria).colect(Colectors.toList());;
					}
				}		
				break;
			case 3:
				
				break;
			case 4:
				System.out.println("Mostrando lista de alumnos con notas");
				for(Alumno al:alumnos) {
					System.out.println(al.getNombre()+" "+al.getApellido()+" "+al.getNotas());
				}
				break;
			case 5: 
				System.out.println("Ingrese un curso para listar sus materias: ");
				String cursoIngresado = sc.next();
				
				
				
				if(parquesNaturales.isEmpty()) {	
					System.out.println("\nNo hay ningún curso cargado!");				
				}else {	
					System.out.println("Ingrese nombre de un urso: ");
					String aux;
					aux= sc.next();
					Iterator it = parquesNaturales.keySet().iterator();
					while(it.hasNext()) {
						Integer key = (Integer) it.next();
						if(parquesNaturales.get(key).getProvincia().getNombreProvincia().equalsIgnoreCase(aux)) {
							System.out.println(parquesNaturales.get(key));
						}
					}
					
				}
			break;
				break;
			case 6: System.out.println("Saliendo...");
				break;
			default: System.out.println("No es una opción!");
				break;
			}
			
			
			
			
			
		}while(op!=6);
		
		
		sc.close();
	}

}
