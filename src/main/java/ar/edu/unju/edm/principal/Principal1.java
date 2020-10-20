package ar.edu.unju.edm.principal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.InputMismatchException;
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
		materias.add(new Materia(1, "POO", "cuatrimestral", "quinto"));
		materias.add(new Materia(2, "LSO","anual","quinto"));
		materias.add(new Materia(3, "Fisica","anual","cuarto"));
		materias.add(new Materia(4, "Herramientas Informáticas","cuatrimestral","quinto"));
		materias.add(new Materia(5, "Matemática","anual", "cuarto"));
//		también se pueden agregar mas materias a la hora de agregar la nota de un alumno
		
		Scanner sc = new Scanner(System.in);
		int op=0;
		boolean ing;
		do {
			do {
				System.out.println("\n---------------------------MENU----------------------------");
				System.out.println("1. Dar de alta un alumno.");
				System.out.println("2. Realizar la búsqueda de un alumno para asignarle sus notas.");
				System.out.println("3. Buscar un alumno ingresando su dni y mostrar el promedio de notas y la nota más alta (valor máximo) por cada Materia.");
				System.out.println("4. Mostrar la lista de alumnos con sus respectivas notas.");
				System.out.println("5. Mostrar la lista de materias ingresando el curso.");
				System.out.println("6. Salir");
				System.out.println("\nIngrese opción: ");
				ing=true;
				try {
					op=sc.nextInt();
				}catch(InputMismatchException i){
					System.out.println("\nIngreso inválido. Debe ingresar una opción numérica.");
					sc.next();
					ing=false;
					}
			}while(ing==false);
			
			switch(op) {
			case 1:
				boolean ing2;
				long dniIngresado=0;
				do {
					ing2=true;
					System.out.println("Ingrese dni: ");
					try {
						dniIngresado = sc.nextLong();
					}catch(InputMismatchException i) {
						System.out.println("\nINGRESO ERRONEO. Debe ingresar un número de DNI.\n");
						sc.next();
						ing2=false;
					}
				}while (ing2==false);
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
					int dia=0;
					int mes=0;
					int anio=0;	
					boolean ingr1,ingr2,ingr3,fechaIng;
					LocalDate fecha=null;
					do {
						do {
							ingr1=true;
							System.out.println("Ingrese día de fecha de nacimiento: ");
							try {
								dia = sc.nextInt();
							}catch(InputMismatchException i){
								System.out.println("\nINGRESO ERRONEO. Debe ingresar el NÚMERO del día del mes.\n");
								sc.next();
								ingr1=false;
							}
						}while(ingr1==false);	
						do {
							ingr2=true;
							System.out.println("Ingrese mes de la fecha de nacimiento: ");
							try {
								mes = sc.nextInt();
							}catch(InputMismatchException i){
								System.out.println("\nINGRESO ERRONEO. Debe ingresar el NÚMERO del mes.\n");
								sc.next();
								ingr2=false;
							}
						}while(ingr2==false);	
						do {
							ingr3=true;
							System.out.println("Ingrese año de nacimiento: ");
							try {
								anio = sc.nextInt();
							}catch(InputMismatchException i){
								System.out.println("\nINGRESO ERRONEO. Debe ingresar el NÚMERO del año.\n");
								sc.next();
								ingr3=false;
							}
						}while(ingr3==false);	
						try {
							fecha = LocalDate.of(anio,mes,dia);
							fechaIng=true;
						}catch(DateTimeException e) {
							if(dia<1 || dia>31) {
								System.out.println("\nEl día está fuera del rango (1-31)");
							}
							if(mes<1 || mes>12) {
								System.out.println("\nEl mes está fuera del rango (1-12)");
							}
							System.out.println("\nLa fecha es inválida. Ingrese números para día, mes y/o año dentro del rango!\n");
							fechaIng=false;
						}
					}while(fechaIng==false);
					alumno.setFechaNac(fecha);
					System.out.println("Ingrese curso: ");
					alumno.setCurso(sc.next());
					alumnos.add(alumno);
					System.out.println("\nAlumno agregado con éxito!");
				}
				break;
			case 2:
				boolean ing3;
				long dniBuscado=0;
				do {
					ing3=true;
					System.out.println("Ingrese DNI del alumno: ");
					try {
						dniBuscado=sc.nextLong();
					}catch(InputMismatchException i) {
						System.out.println("\nINGRESO ERRONEO. Debe ingresar un número de DNI.\n");
						sc.next();
						ing3=false;
					}
				}while(ing3==false);
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
					boolean ing4;
					int ordenNotaIng=0;
					do {
						ing4=true;
						System.out.println("Ingrese orden de la nota: ");
						try {
							ordenNotaIng = sc.nextInt();
						}catch(InputMismatchException j) {
							System.out.println("\nINGRESO ERRONEO. Debe ingresar un número de DNI.\n");
							sc.next();
							ing4=false;
						}
					}while(ing4==false);
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
					double notaI=0;
					do {
						boolean ing5;
						do {
							ing5=true;
							System.out.println("Ingrese la nota (entre 1 y 10!!!): ");
							try {
								notaI=sc.nextDouble();
							}catch(InputMismatchException j) {
								System.out.println("\nINGRESO ERRONEO. Debe ingresar un número!.\n");
								sc.next();
								ing5=false;
							}
						}while(ing5==false);
					}while(notaI<1 || notaI>10);
					nota.setNota(notaI);
					int dia=0;
					int mes=0;
					int anio=0;	
					boolean ingr1,ingr2,ingr3,fechaIng;
					LocalDate fecha=null;
					do {
						do {
							ingr1=true;
							System.out.println("Ingrese día de registro de la nota: ");
							try {
								dia = sc.nextInt();
							}catch(InputMismatchException j){
								System.out.println("\nINGRESO ERRONEO. Debe ingresar el NÚMERO del día del mes.\n");
								sc.next();
								ingr1=false;
							}
						}while(ingr1==false);	
						do {
							ingr2=true;
							System.out.println("Ingrese mes de registro de la nota: ");
							try {
								mes = sc.nextInt();
							}catch(InputMismatchException j){
								System.out.println("\nINGRESO ERRONEO. Debe ingresar el NÚMERO del mes.\n");
								sc.next();
								ingr2=false;
							}
						}while(ingr2==false);	
						do {
							ingr3=true;
							System.out.println("Ingrese año de registro de la nota: ");
							try {
								anio = sc.nextInt();
							}catch(InputMismatchException j){
								System.out.println("\nINGRESO ERRONEO. Debe ingresar el NÚMERO del año.\n");
								sc.next();
								ingr3=false;
							}
						}while(ingr3==false);	
						try {
							fecha = LocalDate.of(anio,mes,dia);
							fechaIng=true;
						}catch(DateTimeException e) {
							if(dia<1 || dia>31) {
								System.out.println("\nEl día está fuera del rango (1-31)");
							}
							if(mes<1 || mes>12) {
								System.out.println("\nEl mes está fuera del rango (1-12)");
							}
							System.out.println("\nLa fecha es inválida. Ingrese números para día, mes y/o año dentro del rango!\n");
							fechaIng=false;
						}
					}while(fechaIng==false);
					nota.setFechaNota(fecha);
					
					boolean ing6;
					int codMateriaIng=0;
					do {
						ing6=true;
						System.out.println("\nIngrese código de la materia en la que desea registrar la nota, o agregue un código nuevo: ");
						try {
							codMateriaIng = sc.nextInt();
						}catch(InputMismatchException j) {
							System.out.println("\nINGRESO ERRONEO. Debe ingresar un código numérico.\n");
							sc.next();
							ing6=false;
						}
					}while(ing6==false);
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
						System.out.println("La materia no existe, se la agregará\n");
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
				System.out.println(materias);
				System.out.println(alumnos);
				break;
			case 3:
				boolean ing7;
				long dniBusc=0;
				do {
					ing7=true;
					System.out.println("Ingrese DNI del alumno: ");
					try {
						dniBusc=sc.nextLong();
					}catch(InputMismatchException j) {
						System.out.println("\nINGRESO ERRONEO. Debe ingresar un número de DNI.\n");
						sc.next();
						ing7=false;
					}
				}while(ing7==false);
				
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
					List<Materia> materias1 = new ArrayList<Materia>();
					List<Materia> materias2 = new ArrayList<Materia>();
					List<Materia> materias3 = new ArrayList<Materia>();
					List<Materia> materias4 = new ArrayList<Materia>();
					List<Materia> materias5 = new ArrayList<Materia>();
					
					for(Materia mat:materias) {
						if(mat.getCurso().equalsIgnoreCase("primero")) {
							materias1.add(mat);
						}
						if(mat.getCurso().equalsIgnoreCase("segundo")) {
							materias2.add(mat);
						}
						if(mat.getCurso().equalsIgnoreCase("tercero")) {
							materias3.add(mat);
						}
						if(mat.getCurso().equalsIgnoreCase("cuarto")) {
							materias4.add(mat);
						}
						if(mat.getCurso().equalsIgnoreCase("quinto")) {
							materias5.add(mat);
						}
					}
//					según el curso al que pertezca el alumno se muestra el promedio de las materias correspondientes
					if(alumnos.get(ind).getCurso().equalsIgnoreCase("primero")){
						for(Materia mat:materias1) {
							double acum=0,c=0,promedio=0,mayor=-1;
							for(Nota nt:alumnos.get(ind).getNotas()) {
								if(nt.getMateria().equals(mat)) {
									c++;
									acum=acum+nt.getNota();
									if(nt.getNota()>mayor) {
										mayor=nt.getNota();
									}
								}
							}
							promedio=acum/c;
							System.out.println(mat.getNombre()+": El promedio es: "+promedio+". La nota más alta es: "+mayor);
						}
					}
					if(alumnos.get(ind).getCurso().equalsIgnoreCase("segundo")){
						for(Materia mat:materias2) {
							double acum=0,c=0,promedio=0,mayor=-1;
							for(Nota nt:alumnos.get(ind).getNotas()) {
								if(nt.getMateria().equals(mat)) {
									c++;
									acum=acum+nt.getNota();
									if(nt.getNota()>mayor) {
										mayor=nt.getNota();
									}
								}
							}
							promedio=acum/c;
							System.out.println(mat.getNombre()+": El promedio es: "+promedio+". La nota más alta es: "+mayor);
						}
					}
					if(alumnos.get(ind).getCurso().equalsIgnoreCase("tercero")){
						for(Materia mat:materias3) {
							double acum=0,c=0,promedio=0,mayor=-1;
							for(Nota nt:alumnos.get(ind).getNotas()) {
								if(nt.getMateria().equals(mat)) {
									c++;
									acum=acum+nt.getNota();
									if(nt.getNota()>mayor) {
										mayor=nt.getNota();
									}
								}
							}
							promedio=acum/c;
							System.out.println(mat.getNombre()+": El promedio es: "+promedio+". La nota más alta es: "+mayor);
						}
					}
					if(alumnos.get(ind).getCurso().equalsIgnoreCase("cuarto")){
						for(Materia mat:materias4) {
							double acum=0,c=0,promedio=0,mayor=-1;
							for(Nota nt:alumnos.get(ind).getNotas()) {
								if(nt.getMateria().equals(mat)) {
									c++;
									acum=acum+nt.getNota();
									if(nt.getNota()>mayor) {
										mayor=nt.getNota();
									}
								}
							}
							promedio=acum/c;
							System.out.println(mat.getNombre()+": El promedio es: "+promedio+". La nota más alta es: "+mayor);
						}
					}
					if(alumnos.get(ind).getCurso().equalsIgnoreCase("quinto")){
						for(Materia mat:materias5) {
							double acum=0,c=0,promedio=0,mayor=-1;
							for(Nota nt:alumnos.get(ind).getNotas()) {
								if(nt.getMateria().equals(mat)) {
									c++;
									acum=acum+nt.getNota();
									if(nt.getNota()>mayor) {
										mayor=nt.getNota();
									}
								}
							}
							promedio=acum/c;
							System.out.println(mat.getNombre()+": El promedio es: "+promedio+". La nota más alta es: "+mayor);
						}
					}
				}
				else {
					System.out.println("\nEl alumno no existe!");
				}
				break;
			case 4:
				System.out.println("\nALUMNOS Y NOTAS");
				for(Alumno al:alumnos) {
					System.out.print(al.getNombre()+" "+al.getApellido()+":");
					
					for(Nota not:al.getNotas()) {
						System.out.print(", "+not.getNota());
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
			default: System.out.println("\nOpción inválida!");
				break;
			}
		}while(op!=6);
		
		
}
}