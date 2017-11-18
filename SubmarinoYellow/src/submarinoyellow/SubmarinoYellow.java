//compile: javac src/submarinoyellow/SubmarinoYellow.java -d build/classes
//run: java -classpath build/classes submarinoyellow/SubmarinoYellow

package submarinoyellow;
import java.util.Scanner;
import java.io.*;

public class SubmarinoYellow {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner entradaS = new Scanner(System.in);

        int menu, prodNum = 0, vendasNum = 0;
        boolean exit = false;

        int[] codigos = {1,2,3,4,5,6,7,8,9,10};
        String[] nomes = new String[10];
        Double[] valores = new Double[10];

        int[] vendas = new int[100];

        do {
            clean();

            print("========= Menu de Opções =========\n1 - Cadastrar produto\n2 - Listar produtos\n3 - Vender produto\n4 - Relatório de vendas\n5 - Sair\nDigite uma opção:");
            menu = entrada.nextInt();

            clean();

            switch(menu) {
                case 1: //cadastro
                    if(prodNum<10) {
                        Double valorTemp;

                        print("Insira o nome do produto (" + (prodNum + 1) + "/10):");
                        nomes[prodNum] = entradaS.nextLine();


                        print("\nInsira o valor do produto (" + (prodNum + 1) + "/10):");
                        valorTemp = entrada.nextDouble();

                        if(valorTemp > 0){
                            valores[prodNum] = valorTemp;

                            clean();

                            print("CADASTRO EFETUADO!");
                            prodNum++;

                            sleep(2000);
                        }
                        else {
                            clean();

                            print("Valor Inválido");

                            sleep(2000);
                        }
                    }
                    else {
                        print("Número máximo de cadastros atingido!");
                        sleep(2000);
                    }

                    break;

                case 2: //listagem
                    listar(prodNum,codigos,nomes,valores);

                    print("Aperte enter para sair:");
                    String sair = entradaS.nextLine();

                    break;

                case 3: //venda
                    if(prodNum!=0) {
                        listar(prodNum,codigos,nomes,valores);

                        int vendaTemp;

                        if(vendasNum<100) {
                            print("Insira o código do produto que deseja comprar:");

                            vendaTemp = entrada.nextInt();

                            clean();

                            if(vendaTemp < (prodNum + 1)) {
                                vendas[vendasNum] = vendaTemp;
                                print("Compra Cadastrada!");
                                vendasNum++;
                                sleep(2000);
                            }
                            else {
                                print("Código Inexistente!");
                                sleep(2000);
                            }
                        }
                        else {
                            print("Número máximo de vendas atingido!");
                        }
                    }
                    else {
                        print("Nenhum produto cadastrado!");
                        sleep(2000);
                    }

                    break;

                case 4: //relatório
                    if(vendas[0]!=0) {

                        print("=== Relatório de Vendas ===");

                        for (int i = 0; i < prodNum; i++) {
                            int comprado = 0;
                            for(int j = 0; j<vendas.length; j++) {
                                if(vendas[j] == (i + 1)) {
                                    comprado++;
                                }
                            }
                            if (comprado > 0) {
                                print("Código: " + (i + 1));
                                print("Produto: " + nomes[i]);
                                print("Nº de Vendas: " + comprado);
                                print("Preço: " + valores[i]);
                                print("Total: " + (comprado * valores[i]) + "\n");
                            }
                        }

                    }
                    else {
                        print("Nenhuma venda cadastrada!");
                    }

                    print("\nAperte enter para sair:");
                    sair = entradaS.nextLine();

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

    public static void listar(int num, int[] codigo, String[] nome, Double[] valor) { //método para listagem dos itens cadastrados
        if (num == 0) {
            print("Nenhum produto cadastrado!");
        }
        else {
            for (int i = 0; i < num; i++) {
                print("Código: " + codigo[i] + "\nNome: " + nome[i] + "\nValor: " + valor[i] + "\n");
            }
        }
    }


    //FUNÇÕES UTEIS


    public static void print(String string) {  //atalho para o System.out.println()
        try {
            System.out.println(new String(string.getBytes("ISO-8859-1"), "UTF-8")); //codifica para aceitar acentos e caracteres do latim
        } catch (UnsupportedEncodingException e) {
            System.out.println("Tipo incorreto de codificação!");
        }
    }

    public static void clean() {  //atalho para limpar o console
        for(int i = 0; i<50; i++) {
            print("\n");
        }
    }

    public static void sleep(int miliseconds) { //intorrompe o programa por x milisegundos
        try {
            Thread.sleep(miliseconds);
        }
        catch(InterruptedException e) {

        }
    }
}
