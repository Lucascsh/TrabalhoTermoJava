import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Teste {


    public static void main(String[] args) {
        ArrayList<String> dis = new ArrayList<String>();
        try {
            File obj = new File("dicionario.txt");
            Scanner leitor = new Scanner(obj);
            while (leitor.hasNextLine()) {
                String data = leitor.nextLine();
                dis.add(data);
            }

            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu Um Erro.");
            e.printStackTrace();
        } 
        String palavraCerta = dis.get((int)(Math.random()*6026));
        System.out.println(palavraCerta);
        
        System.out.println("_ _ _ _ _");
        int tentativas = 0;
        
        do{
            String palavraEscolhida = JOptionPane.showInputDialog("Digite uma palavra com 5 letras: ");
            
            if(palavraEscolhida.length() !=5){
                JOptionPane.showMessageDialog(null, "Palavra Inválida, digite outra!");
                
            }else{
                tentativas ++;
                System.out.println(palavraEscolhida);
                //%d %d %d %d %d if(char = palavra) 
                //a  _  _   _   _
            } 

            if (palavraEscolhida.equals(palavraCerta)){
                JOptionPane.showMessageDialog(null, "Parabéns você acertou a palavra!");
                break;
            }
            
            if (tentativas == 2){
                JOptionPane.showMessageDialog(null, "Acabaram as tentativas! ");
            }
        
        }while(tentativas < 2);
        
        
    }
}
