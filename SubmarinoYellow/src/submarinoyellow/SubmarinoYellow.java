package submarinoyellow;
import java.util.Scanner;

public class SubmarinoYellow {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner entradaS = new Scanner(System.in); //Scanner para Strings

        int menu, prodNum = 0, vendasNum = 0;
        //menu é utilizado para nevegação no menu; prodNum é o contador de produtos cadastrados; vendasNum é o contador de compras efetuadas;
        boolean exit = false;
        //exit é utilizado para sair do programa (quando exit == true)

        int[] codigos = {1,2,3,4,5,6,7,8,9,10}; //codigos para os produtos cadastrados
        String[] nomes = new String[10]; //nomes dos produtos cadastrados
        Double[] valores = new Double[10]; //valor dos produtos cadastrados

        int[] vendas = new int[100]; //código de cada produto vendido

        clean(); //função que "limpa" o console

        print("Projeto \"Loja de Produtos\" - Professora Simone de Abreu | Contrução de Algoritmos\n"); //print é um atalho para System.out.println(), que também altera os caracteres para UTF-8
        print("Nome: Douglas Santos Salles RA: 20950019");
        print("Nome: Nathalia Abramson Friederichs RA: 21028220");
        print("Nome: Thiago Araujo Rodrigues RA: 21033797");
        print("Nome: Thiago Vinícius Pessia RA: 21027210");
        print("Nome: Victor Luis X Santicioli RA:20837821 ");

        continuar();

        do {
            clean();

            print("========= Menu de Opções =========");
            print("1 - Cadastrar produto");
            print("2 - Listar produtos");
            print("3 - Vender produto");
            print("4 - Relatório de vendas");
            print("5 - Sair");
            print("Digite uma opção:");
            menu = entrada.nextInt();

            clean();

            switch(menu) {
                case 1: //cadastro
                    if(prodNum<10) { //verifica se o número máximo de produtos já foi cadastrado
                        print("Insira o nome do produto (" + (prodNum + 1) + "/10):");
                        nomes[prodNum] = entradaS.nextLine();


                        print("\nInsira o valor do produto (" + (prodNum + 1) + "/10):");
                        valores[prodNum] = entrada.nextDouble();

                        if(valores[prodNum] > 0){ //verifica se o valor inserido é válido
                            clean();

                            print("CADASTRO EFETUADO!");
                            prodNum++; //só considera o cadastro caso o valor seja validado

                            continuar();
                        }
                        else {
                            clean();

                            print("Valor Inválido");

                            continuar();
                        }
                    }
                    else {
                        print("Número máximo de cadastros atingido!");
                        continuar();
                    }

                    break;

                case 2: //listagem
                    listar(prodNum,codigos,nomes,valores); //método que lista os produtos cadastrados

                    continuar();

                    break;

                case 3: //venda
                    if(prodNum!=0) {
                        listar(prodNum,codigos,nomes,valores); //lista os produtos cadastrados

                        int vendaTemp; //mantém a venda em uma variável temporária, até que ela seja validada, e então envia o código para o vetor

                        if(vendasNum<=100) { //verifica se o número máximo de vendas já foi alcançado
                            print("Insira o código do produto que deseja comprar:");

                            vendaTemp = entrada.nextInt();

                            clean();

                            if(vendaTemp < (prodNum + 1)) { //verifica se o código inserido é válido (se o código é menor ou igual ao ultimo código cadastrado)
                                vendas[vendasNum] = vendaTemp;
                                print("Compra Cadastrada!");
                                vendasNum++;
                                continuar();
                            }
                            else {
                                print("Código Inexistente!");
                                continuar();
                            }
                        }
                        else {
                            print("Número máximo de vendas atingido!");
                        }
                    }
                    else {
                        print("Nenhum produto cadastrado!");
                        continuar();
                    }

                    break;

                case 4: //relatório
                    if(vendas[0]!=0) { //verifica se alguma venda já foi cadastrada

                        print("=== Relatório de Vendas ===\n");

                        for (int i = 0; i < prodNum; i++) {  //itera sobre os produtos cadastrados
                            int comprado = 0; //variável que guarda o número de vezes que um produto específico foi comprado

                            for(int j = 0; j<vendas.length; j++) { //itera sobre as vendas
                                if(vendas[j] == (i + 1)) { //verifica se o código no vetor vendas é igual ao código do produto em questão
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

                    continuar();

                    break;

                case 5:
                    exit = true;

                    break;

                default:
                    print("Número inserido é invalido!");
                    continuar();
            }

        } while(exit != true);
    }

    public static void listar(int num, int[] codigo, String[] nome, Double[] valor) { //método para listagem dos itens cadastrados
        if (num == 0) { //verifica se algum produto já foi cadastrado
            print("Nenhum produto cadastrado!");
        }
        else {
            for (int i = 0; i < num; i++) {
                print("Código: " + codigo[i] + "\nNome: " + nome[i] + "\nValor: " + valor[i] + "\n"); //imprime os dados do produto
            }
        }
    }


    //FUNÇÕES UTEIS


    public static void print(String string) {  //atalho para o System.out.println()
        System.out.println(string);
    }

    public static void clean() {  //atalho para limpar o console
        for(int i = 0; i<50; i++) {
            print("\n");
        }
    }

    public static void continuar() { //intorrompe o programa momentaneamente
        Scanner entry = new Scanner(System.in); //Scanner para Strings
        print("\nAperte enter para sair");
        String sair = entry.nextLine();
    }
}
