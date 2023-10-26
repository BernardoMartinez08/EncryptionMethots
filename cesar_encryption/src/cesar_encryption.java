import java.util.Scanner;

public class cesar_encryption {
    public String cesar_encryption(String text, int move_number, int direction, int alphabet){
        return "";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el texto a encriptar: ");
        String text = scan.nextLine();

        System.out.print("Ingrese el numero de desplazamientos: ");
        int move_number = scan.nextInt();

        System.out.print("Ingrese la direccion del desplazamiento:\n1. Izquierda\n2. Derecha\nIngrese el numero de la opcion que desea: ");
        int direction = scan.nextInt();

        System.out.print("Ingrese el alfabeto usar:\n1. Ingles\n2. Español\nIngrese el numero de la opcion que desea: ");
        int opc = scan.nextInt();
    }
}