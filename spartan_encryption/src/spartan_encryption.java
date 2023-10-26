import java.util.Scanner;

public class spartan_encryption {

    public String[][] split_text(String text, int columns){
        String[][] text_array = new String[columns][columns];
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < columns; j++){
                try{
                    text_array[i][j] = text.charAt(i*columns + j) + "";
                }
                catch(Exception e){
                    text_array[i][j] = "";
                }
            }
        }
        return text_array;
    }

    public String spartan_encription(String[][] text) {
        StringBuilder encrypted_text = new StringBuilder();
        for(int i = 0; i < text.length; i++){
            for (int j = 0; j < text.length; j++) {
                encrypted_text.append(text[j][i]);
            }
        }
        return encrypted_text.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el texto a encriptar: ");
        String text = scan.nextLine();

        int columns = 0;
        boolean accepted = false;
        while(accepted != true) {
            System.out.print("Ingrese el numero de columnas: ");
            columns = scan.nextInt();

            if(columns>=2 && columns < text.length())
                accepted = true;
            else
                System.out.print("Ingrese un numero mayor a 1 y menor al tamaño de la palabra.\n");
        }

        spartan_encryption spartan = new spartan_encryption();
        String[][] text_array = spartan.split_text(text, columns);
        String encrypted_text = spartan.spartan_encription(text_array);

        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("Texto encriptado: " + encrypted_text);
        System.out.println("------------------------------------------------------------------------------------------");
    }
}