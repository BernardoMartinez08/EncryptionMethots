import java.util.Scanner;

public class cesar_encryption {

    public int new_index(char caracter, int direction, int move_number){
        int index = caracter - 'a';
        if (direction == 1) {
            index = (index - move_number) % 26;

            if (index < 0)
                index += 26;

        } else {
            index = (index + move_number) % 26;
        }
        return index;
    }


    public char swap_caracter(char caracter, int direction, int move_number){
        caracter = Character.toLowerCase(caracter);
        int index = new_index(caracter, direction, move_number);
        return (char) ('a' + index);
    }

    public String calculate_text(String text, int direction, int move_number, int method){
        StringBuilder result = new StringBuilder();

        if(method == 2)
            direction = direction == 1 ? 2 : 1;

        for (char caracter : text.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char new_caracter = swap_caracter(caracter, direction , move_number);
                result.append(new_caracter);
            } else {
                result.append(caracter);
            }
        }
        return result.toString();
    }

    public String encrypt(String text, int move_number, int direction){
        return calculate_text(text, direction, move_number, 1);
    }

    public String decrypt(String text, int move_number, int direction){
        return calculate_text(text, direction, move_number, 2);
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
        String decrypted_text = cesar.decrypt(encrypted_text, move_number, direction);

        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("Texto encriptado: " + encrypted_text);
        System.out.println("Texto desencriptado: " + decrypted_text);
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
