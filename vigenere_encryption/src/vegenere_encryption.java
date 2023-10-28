import java.util.Scanner;

public class vegenere_encryption {

    public int new_index(char caracter, char key_caracter, int method) {
        int caracter_index = caracter - 'a';
        int key_index = key_caracter - 'a';

        int index;
        if(method == 1)
            index = (caracter_index + key_index) % 26;
        else
            index = (caracter_index - key_index) % 26;

        if (index < 0)
            index += 26;
        return index;
    }

    public char swap_caracter(char caracter,char key_caracter, int method){
        caracter = Character.toLowerCase(caracter);
        key_caracter = Character.toLowerCase(key_caracter);

        int index = new_index(caracter, key_caracter, method);
        return (char) ('a' + index);
    }

    public String complete_key(String text, String key){
        StringBuilder result = new StringBuilder();
        int key_index = 0;
        for (char caracter : text.toCharArray()) {
            if (Character.isLetter(caracter)) {
                if(key_index == key.length())
                    key_index = 0;
                result.append(key.charAt(key_index));
                key_index++;
            } else {
                result.append(caracter);
            }
        }
        return result.toString();
    }

    public String calculate_text(String text,String key, int method){
        if(key.length() < text.length())
            key = complete_key(text, key);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {

            if (Character.isLetter(text.charAt(i)) && Character.isLetter(key.charAt(i))) {
                char new_caracter = swap_caracter(text.charAt(i), key.charAt(i), method);
                result.append(new_caracter);
            } else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    public String encrypt(String text, String key){
        return calculate_text(text, key, 1);
    }

    public String decrypt(String text, String key){
        return calculate_text(text, key, 2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el texto a encriptar: ");
        String text = scan.nextLine();

        System.out.print("Ingrese el la llave de encriptacion: ");
        String key = scan.nextLine();

        vegenere_encryption vegenere = new vegenere_encryption();
        String encrypted_text = vegenere.encrypt(text, key);
        String decrypted_text = vegenere.decrypt(encrypted_text, key);

        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("Texto encriptado: " + encrypted_text);
        System.out.println("Texto desencriptado: " + decrypted_text);
        System.out.println("------------------------------------------------------------------------------------------");
    }
}