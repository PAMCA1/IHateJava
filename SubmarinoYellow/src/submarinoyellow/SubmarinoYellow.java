//compile: javac src/submarinoyellow/SubmarinoYellow.java -d build/classes
//run: java -classpath build/classes submarinoyellow/SubmarinoYellow

package submarinoyellow;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class SubmarinoYellow {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int menu, prodNum = 0;
        boolean exit = false;

        int[] codigos = {1,2,3,4,5,6,7,8,9,10};
        String[] nomes = new String[10];
        Double[] valores = new Double[10];

        do {
            clean();

            print("========= Menu de Opções =========\n1 - Cadastrar produto\n2 - Listar produtos\n3 - Vender produto\n4 - Relatório de vendas\n5 - Sair\nDigite uma opção:");
            menu = entrada.nextInt();
            
            clean();
            
            switch(menu) {
                case 1:
                    if(prodNum<10) {
                        print("Insira o nome do produto (" + (prodNum + 1) + "/10):");
                        nomes[prodNum] = entrada.next();
                        
                        print("\nInsira o valor do produto (" + (prodNum + 1) + "/10):");
                        valores[prodNum] = entrada.nextDouble();
                        if(valores[prodNum] <= 0){
                            clean();
                            print("Valor Inválido");
                            sleep(2000);
                            break;
                        }
                        
                        clean();

                        print("CADASTRO EFETUADO!\n\nCódigo - " + codigos[prodNum] + "\nNome - " + nomes[prodNum] + "\nValor - " + valores[prodNum]);

                        prodNum++;
                        sleep(2000);
                    }
                    else {
                        print("Número máximo de cadastros atingido!");
                        sleep(2000);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    print("Número inserido é invalido!");
                    sleep(2000);
            }

        } while(exit != true);
    }

    public static void print(String string) {  //atalho para o System.out.println()
        try {  
            System.out.println(new String(string.getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Tipo incorreta de codificação!");
        }
    }

    public static void clean() {  //atalho para limpar o console
        for(int i = 0; i<50; i++) {
            print("\n");
        }
        return;
    }

    public static void sleep(int miliseconds) { //intorrompe o programa por x milisegundos
        try {
            Thread.sleep(miliseconds);
        } 
        catch(InterruptedException e) {

        }
    }
}
