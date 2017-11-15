//compile: javac src/submarinoyellow/SubmarinoYellow.java -d build/classes
//run: java -classpath build/classes submarinoyellow/SubmarinoYellow

package submarinoyellow;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SubmarinoYellow {

    public static void main(String[] args) {
        int menu;
        boolean exit = false;

        Scanner entrada = new Scanner(System.in);

        do {
            clean();

            print("========= Menu de Opções =========\n1 - Cadastrar produto\n2 - Listar produtos\n3 - Vender produto\n4 - Relatório de vendas\n5 - Sair\nDigite uma opção:");
            menu = entrada.nextInt();
            
            switch(menu) {
                case 1:
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
                    clean();
                    print("Número inserido é invalido!");
                    sleep(2000);
            }

        } while(exit != true);
    }

    public static void print(String string) {  //atalho para o System.out.println()
        System.out.println(string);
        return;
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
