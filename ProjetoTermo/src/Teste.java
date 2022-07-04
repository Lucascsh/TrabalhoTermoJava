import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Teste {


    public static void main(String[] args) {
        ArrayList<String> dis = new ArrayList<String>();
        ArrayList<String> palavrasDigitadas = new ArrayList<String>();
        ArrayList<String> letrasPosicaoCerta = new ArrayList<String>();
        ArrayList<String> letrasCertas = new ArrayList<String>();
        ArrayList<String> letrasNaoEncontradas = new ArrayList<String>();
        try {
            File obj = new File("dicionario.txt");
            Scanner leitor = new Scanner(obj);
            while (leitor.hasNextLine()) {
                String data = leitor.nextLine();
                dis.add(data.toUpperCase());
            }

            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu Um Erro.");
            e.printStackTrace();
        } 
        String palavraCerta = dis.get((int)(Math.random()*6026));
        palavraCerta.toUpperCase();
        System.out.println(palavraCerta);
        int tentativas = 0;
        
        do{
            String palavraEscolhida = JOptionPane.showInputDialog("Digite uma palavra com 5 letras: ").toUpperCase();
            if(palavraEscolhida.length() !=5){
                JOptionPane.showMessageDialog(null, "Palavra Inválida, digite outra!");
            }else{
                System.out.println(palavraEscolhida);
                if (!dis.contains(palavraEscolhida)){
                    JOptionPane.showMessageDialog(null, "Palavra não Reconhecida.\nTente outra!");
                    continue;
                }else if(palavraEscolhida.equals(palavraCerta)){
                    JOptionPane.showMessageDialog(null, "Parabéns você acertou a palavra!");
                        break;
                }else
                    palavrasDigitadas.add(palavraEscolhida);
                    tentativas++;
                    int percorrerLetras = 0;
                    do{
                        if(palavraEscolhida.charAt(percorrerLetras)==palavraCerta.charAt(percorrerLetras)){
                            //System.out.println("A letra " + palavraEscolhida.charAt(percorrerLetras) + " está na palavra e na posição correta");
                            letrasPosicaoCerta.add("" + palavraEscolhida.charAt(percorrerLetras));
                        }else if (palavraCerta.contains("" + palavraEscolhida.charAt(percorrerLetras))){
                            //System.out.println("A letra " + palavraEscolhida.charAt(percorrerLetras) + " está na palavra, mas na posição incorreta");
                            letrasCertas.add("" + palavraEscolhida.charAt(percorrerLetras));
                        }else if (!palavraCerta.contains("" + palavraEscolhida.charAt(percorrerLetras))){
                            //System.out.println("A letra " + palavraEscolhida.charAt(percorrerLetras) + " não está na palavra");
                            letrasNaoEncontradas.add("" + palavraEscolhida.charAt(percorrerLetras));
                        }
                        percorrerLetras++;
                        
                        }while(percorrerLetras < 5);
                    System.out.println("Palavras já testadas: " + palavrasDigitadas);
                    System.out.println("Letras na Posição Certa: " + letrasPosicaoCerta);
                    System.out.println("Letras na palavra, mas na posição incorreta: " + letrasCertas);
                    System.out.println("Letras que não pertencem a palavra: " + letrasNaoEncontradas);
                    System.out.println("Tentativas: " + tentativas);
               }
     
        }while(tentativas < 6);
        
        
    }
}
