package mmc;
import java.util.Scanner; // Importação Scanner
public class Mmc {
    public static void main(String[] args) {

        //Interação com o usuário
        String i1 = "Quantos números você quer calcular MMC? (Quantidade)";
        String i2 = "Digite o número que você quer utilizar";
        String i3 = "O resultado do MMC é ";

        //Variáveis 
        int quant=quant(i1); // A quantidade que o usuário digitou é virou o int quantidade
        int[] num = nuns(i2,quant); // Adiciona os números que o usuário digitou a um vetor num do tamanho da quantidade
        int primo= 1;
        int mmc = 1;
        int nDiv;
        
        //Condições específicas
        if (quant == 0){ // Se quant for nulo
            System.out.println("Não é possível calcular o MMC de nenhum número"); 
        }else{
          
            boolean[] primoDiv = new boolean[quant]; // primoDiv é igual a quantidade de números do vetor
            primoDiv = primoDiv(primo,num,primoDiv); // primoDiv é um vetor de primo, num e primoDiv
            boolean fimloop = false; // O fimloop é falso

            while (fimloop == false) { // Enquanto o fimLoop for falso
                boolean printado = false; // O printado (escrito) vai ser falso

                nDiv = 0; // O valor de nDiv vai ser definido para 0

                for (int j = 0; j < num.length; j++) { // Enquanto J for menor que NUM, o loop irá se repetir, ou seja, quando o vetor todo ser analisado, o for irá terminar
                    primo = 2; // O valor de primo é redefinido para 2 
                    if (num[j] > 1) { // Se algum NUM for menor que 1, ele vai entrar na condição
                        while (num[j] % primo != 0){ // Se o resto de num dividido por primo, for igual a 0
                            primo = proximoPrimo(primo);  // Primo é igual ao próximo primo
                            primoDiv(primo,num,primoDiv); //primoDiv é um vetor
                            if(primoDiv[j]){ // A condição é primoDiv mais qual posição do vetor
                                print(num, primo); // print é igual o vetor num e a aba primo
                                divisao(num, primo,primoDiv); // Disão é igual ao vetor num, primo, primoDiv
                                mmc = mmc * primo; // MMC é o MMC multiplicado pelo Primo
                                printado = true; // Muda o valor de printado para verdadeiro
                                break; // Força o fim do loop
                            }
                        }
                    }
                }
                if(printado == false){ // Se printado for falso ele entra na condição
                    primoDiv(primo,num,primoDiv); // Puxa o resultado da função e defini
                    print(num, primo); // Puxa o resultado da função e defini
                    divisao(num, primo,primoDiv); // Puxa o resultado da função e defini
                    mmc = mmc * primo;} // Puxa o resultado da função e defini
                    fimloop = tudo1(num); // Puxa o resultado da função e defini
            } 
            System.out.println(i3 + mmc); // Vai imprimir o valor do vetor ao usuário
        }
    }
    
    public static int[]nuns(String i2,int quant){
        Scanner in = new Scanner(System.in); // Importação scanner
        int[] num = new int[quant]; // O vetor num equivale o vetor quant, que no final ambos falam o tamanho do vetor
      
        for(int i =0;i<quant;i++){ // Enquanto i for menor que quant o for vai repetir
            System.out.println(i2); // Pede para digitar mais um número
            num[i]=in.nextInt(); // Pergunta quais número e adiciona ao vetor
        }  
        return num; // Vai retornar a função
    }
    public static int quant(String i1){
        Scanner in = new Scanner(System.in); // Importação scanner
        int quant;
        System.out.println(i1); // Mostrar na tela
        quant=in.nextInt(); // Quat é o valor que o usuário digitar
        if (quant < 1){ // Se quant for menor que 1
            quant = 0; // Quant é igual a 0
        }
        return quant; // Retorna a função
        
    }
    public static void print(int[] vet,int primo){
        String barrinha = "| ";  // Defini o valor da String barrinha
        
        for(int i = 0; i < vet.length; i++){ // Vai testar todos os espaços do vetor
            System.out.print(vet[i] + " "); // Vai imprimir os numeros com mais um espaço
        }
        System.out.println(barrinha + primo); // imprimo o numero 
    }
    public static boolean tudo1(int[]vet){
        boolean tudoUm = false; // tudoUm é falso
        int cont = 0; // o cont começa em 0  
        
        for (int i = 0; i < vet.length; i++){ // Enquanto o vetor for mais que I ele vai continuar no Looop (Quando acabar o vetor o loop para)
            if(vet[i] == 1){ // Verificar se algum valor do vetor vale 1
                cont++; // Soma mais um
            }
        }
        if(cont == vet.length){ // Se cont for igual ao vetor, ou seja, se todo vetor for igual a cont
            tudoUm = true;}  // tudoUm é verdadeiro, significa que o todo o vetor é 1
        
        return tudoUm; // Vai retornar a função
    }
    public static int proximoPrimo(int primo){
        int proxPri = primo + 1; // O próximo primo é primo + 1 pelo fato de ser o próximo
        int div = -1;
        int cont = 1;
        boolean ehPrimo = true; // o booleab ehPrimo é verdadeiro
        
        while (ehPrimo) { 
            for (int j = 0; j < proxPri; j++) { // Enquanto j for menor que proxPri ele continua no loop 
                if (proxPri % cont == 0) { // Se o resto da divisão for 0
                    div++;} // Soma mais um
                if (div > 2) { // Se div for maior que 2 ele entra nessa condição
                    proxPri++; // Soma mais um
                    break;} // força o fim do loop
                else if (div == 2) { // Se não for nenhuma if acima ele cai nessa codição
                    ehPrimo = false;} // O ehprimo é falso
            }
            cont++; // Soma mais um
        }
        return proxPri; // Vai retornar a função
    }
    public static boolean[] primoDiv(int primo,int []vet,boolean[]primoDiv){
        for (int i = 0; i < vet.length; i++) { // Enquanto vet for maior que i, o loop irá se repetir
            if (vet[i] % primo == 0 && vet[i] > 1) { // Se o resultado do resto do vetor for 0 ele entra na condição
                primoDiv[i] = true;}  // O primoDiv vai virar True
            else { // Se ele não entrar na condição, ele vai vim pra essa condição
                primoDiv[i] = false;} // O primoDiv vai virar False
        }
        return primoDiv; // Vai retornar a função
    }
    public static void divisao(int[] vet,int primo,boolean[] primoDiv){
        for (int i = 0; i < vet.length; i++) { // Enquanto o tamanho do vetor menor que i, ele vai verificar todos
            if (primoDiv[i] == true) { // Se primoDiv for verdadieor
                vet[i] = vet[i] / primo;} // Vet é o resultado do vet dividido por primo
        }
    }
}
