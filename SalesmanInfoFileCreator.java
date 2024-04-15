package fundamentos_programacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SalesmanInfoFileCreator {

    // Listas de nombres y apellidos comunes
    private static final String[] FIRST_NAMES = {
    	    "Santiago", "Valentina", "Mateo", "Camila", "Sebastián", "Isabella", "Matías", "Sofía", "Juan", "Mariana",
    	    "Diego", "Valeria", "Daniel", "Luciana", "Nicolás", "Emma", "Emiliano", "Victoria", "Alejandro", "Martina",
    	    "Tomás", "Ana", "Joaquín", "Juliana", "Samuel", "Antonella", "Felipe", "Gabriela", "Andrés", "Amelia",
    	    "Lucas", "Daniela", "Adrián", "Bianca", "Gabriel", "Renata", "Luciano", "Laura", "Gonzalo", "Catalina",
    	    "Emilio", "Isadora", "David", "Rafaela", "Ricardo", "Paula", "Carlos", "Adriana", "José", "Fernanda",
    	    "Fernando", "Celeste", "Esteban", "Carolina", "Pablo", "Alessandra", "Marcos", "Natasha", "Javier", "Alejandra",
    	    "Emmanuel", "Luna", "Miguel", "Josefina", "Luis", "Abril", "Rafael", "Valery", "Leonardo", "Ximena",
    	    "Oscar", "Giselle", "Julio", "Alana", "Hernán", "Melanie", "Rodrigo", "Renata", "Martín", "Ivana",
    	    "Cristian", "Diana", "Fabián", "Paulina", "Estefano", "Elena", "Enrique", "Julia", "Víctor", "Aurora"
    	};
    private static final String[] LAST_NAMES = {
    	    "García", "Martínez", "Rodríguez", "Hernández", "López", "González", "Pérez", "Sánchez", "Ramírez", "Torres",
    	    "Flores", "Vásquez", "Rivera", "Gómez", "Díaz", "Reyes", "Morales", "Castillo", "Fernández", "Ortega",
    	    "Jiménez", "Ruiz", "Alvarez", "Romero", "Moreno", "Vargas", "Mendoza", "Arias", "Chávez", "Guerrero",
    	    "Rojas", "Medina", "Silva", "Ramos", "Acosta", "Delgado", "Vega", "Mora", "Soto", "Sosa", "Luna",
    	    "Gutiérrez", "Cruz", "Campos", "Figueroa", "Núñez", "Cabrera", "Herrera", "Miranda", "Aguilar", "Peña",
    	    "Santiago", "Orozco", "Valenzuela", "Salazar", "Castañeda", "Navarro", "Téllez", "Bermúdez", "Calderón", "Cortés",
    	    "Escobar", "Figueroa", "Gallegos", "Montes", "Paz", "Zamora", "Duarte", "Espinosa", "Granados", "Herrera",
    	    "Ibarra", "Jurado", "León", "Mata", "Noriega", "Ochoa", "Palacios", "Quiroz", "Ríos", "Saavedra",
    	    "Tapia", "Uribe", "Villarreal", "Zúñiga", "Almeida", "Becerra", "Dávila", "Estrada", "Fajardo", "Godínez"
    	};

    public static void createSalesManInfoFile(int salesmanCount) {
        // Define el nombre del archivo, puedes cambiar la ruta y el nombre del archivo según sea necesario
        String fileName = "salesmen_info.txt";

        try {
            // Crea un objeto File
            File file = new File(fileName);

            // Crea un FileWriter y BufferedWriter para escribir en el archivo
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribe la línea de encabezado
            bw.write("ID, Nombre, Apellido, Ventas\n");

            // Genera información pseudoaleatoria de vendedores y escribe en el archivo
            Random rand = new Random();
            for (int i = 1; i <= salesmanCount; i++) {
                // Selecciona nombres y apellidos de las listas de manera pseudoaleatoria
                String firstName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
                int sales = rand.nextInt(100); // Número pseudoaleatorio de ventas hasta 100

                bw.write(i + ", " + firstName + ", " + lastName + ", " + sales + "\n");
            }

            // Cierra el BufferedWriter
            bw.close();
            System.out.println("Archivo de información de vendedores creado con éxito: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario que ingrese la cantidad de vendedores
        System.out.print("Ingrese la cantidad de vendedores: ");
        int salesmanCount = scanner.nextInt();

        // Llama al método con el valor ingresado
        createSalesManInfoFile(salesmanCount);

        scanner.close();
    }
}
