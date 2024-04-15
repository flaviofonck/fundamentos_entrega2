package fundamentos_programacion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateLastNames {

    public static void main(String[] args) {
        String[] firstNames = {
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

        String fileName = "firstNames.txt";

        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String firstName : firstNames) {
                bw.write(firstName + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo firstNames.txt creado exitosamente!");
    }
}
