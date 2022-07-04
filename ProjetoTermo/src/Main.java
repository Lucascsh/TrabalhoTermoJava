import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File obj = new File("todasPalavras.txt");
            Scanner leitor = new Scanner(obj);
            while (leitor.hasNextLine()) {
                String data = leitor.nextLine();
                if(data.length()==5){
                    System.out.println(data);
                }
            }
            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu Um Erro.");
            e.printStackTrace();
        }
        int vetor[];
    }
}
