import Model.Implementations.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student al1=new Student();
        System.out.println("Ingrese datos del alumno:\n Nombre: ");
        al1.setNombre(scanner.nextLine());
        System.out.println("Ingrese el apellido: ");
        al1.setApellido(scanner.nextLine());
        System.out.println("Ingrese edad: ");
        al1.setEdad(scanner.nextInt());
        System.out.println("Ingrese el email: ");
        al1.setEmail(scanner.nextLine());


    }
}