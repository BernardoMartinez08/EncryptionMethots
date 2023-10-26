import java.util.Scanner;

public class cesar_encryption {

    public int new_index(char caracter, int direction, int move_number){
        int index = 0;
        if(direction == 1)
            index = (caracter - 'a' - move_number) % 26;
        else
            index = (caracter - 'a' + move_number) % 26;

        return index;
    }

    public char swap_caracter(char caracter, int direction, int move_number){
        caracter = Character.toLowerCase(caracter);
        int index = new_index(caracter, direction, move_number);
        return (char) ('a' + index);
    }

    public String encrypt(String text, int move_number, int direction){
        StringBuilder result = new StringBuilder();
        for (char caracter : text.toCharArray()) {

            if (Character.isLetter(caracter)) {
                char new_caracter = swap_caracter(caracter, direction, move_number);
                result.append(new_caracter);
            } else {
                result.append(caracter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el texto a encriptar: ");
        String text = scan.nextLine();

        System.out.print("Ingrese el numero de desplazamientos: ");
        int move_number = scan.nextInt();

        System.out.print("Ingrese la direccion del desplazamiento:\n1. Izquierda\n2. Derecha\nIngrese el numero de la opcion que desea: ");
        int direction = scan.nextInt();

        cesar_encryption cesar = new cesar_encryption();
        String encrypted_text = cesar.encrypt(text, move_number, direction);

        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("Texto encriptado: " + encrypted_text);
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}