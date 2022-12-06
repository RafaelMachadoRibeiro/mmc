package mmc;
import java.util.Scanner;
public class Mmc {
    public static void main(String[] args) {
        String texto1 = "De quantos numeros você quer tirar o mmc?";
        String texto2 = "Digite o numero que sera usado na operação";
        int quant=quant(texto1);
        int[] num = nuns(texto2,quant);
        int primo= 1;
        int mmc =1;
        int nDiv = 0;
        boolean[] primoDiv = new boolean[quant];
        primoDiv = primoDiv(primo,num,primoDiv);
        boolean fimloop = false;
        while (fimloop == false) {
            boolean printado = false;
            
            nDiv = 0;
            
            for (int j = 0; j < num.length; j++) {
                primo = 2;
                if (num[j] > 1) {
                    while (num[j] % primo != 0){
                        primo = proximoPrimo(primo);
                        primoDiv(primo,num,primoDiv);
                        if(primoDiv[j]){
                            print(num, primo);
                            divisao(num, primo,primoDiv);
                            mmc = mmc * primo;
                            printado = true;
                            break;
                        }
                    }
                }
            }
            if(printado == false){
                primoDiv(primo,num,primoDiv);
                print(num, primo);
                divisao(num, primo,primoDiv);
                mmc = mmc * primo;
            }
            fimloop = tudo1(num);
            
        }
        System.out.println("O minimo multiplo comum desses numeros é " + mmc);
    }
    
    
    public static int[]nuns(String texto1,int quant){
        Scanner in = new Scanner(System.in);
        int[] num = new int[quant]; 
        for(int i =0;i<quant;i++){
            System.out.println(texto1);
            num[i]=in.nextInt();
        } 
        return num;
    }
    public static int quant(String texto){
        Scanner in = new Scanner(System.in);
        int quant;
        System.out.println(texto);
        quant=in.nextInt(); 
        return quant;
    }
    public static void print(int[] vet,int primo){
        for(int i = 0; i < vet.length; i++){
            System.out.print(vet[i] + " ");
        }
        System.out.println("| " + primo);
        
    }
    public static boolean tudo1(int[]vet){
        boolean tudoUm = false;
        int cont = 0;
        for (int i = 0; i < vet.length; i++){
            if(vet[i] ==1){
                cont++;
            }
        }
        if(cont == vet.length){
            tudoUm = true;
        }
        return tudoUm;      
    }
    public static int proximoPrimo(int primo){
        int proxPri = primo + 1;
        int div = -1;
        int cont = 1;
        boolean ehPrimo = true;
        while (ehPrimo) {
            for (int j = 0; j < proxPri; j++) {
                if (proxPri % cont == 0) {
                    div++;
                }
                if (div > 2) {
                    proxPri++;
                    break;
                } else if (div == 2) {
                    ehPrimo = false;
                }
            }
            cont++;
        }
        return proxPri;
    }
    public static boolean[] primoDiv(int primo,int []vet,boolean[]primoDiv){
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] % primo == 0 && vet[i] > 1) {
                primoDiv[i] = true;
            } else {
                primoDiv[i] = false;
            }
        }
        return primoDiv;
       
    }
    public static void divisao(int[] vet,int primo,boolean[] primoDiv){
        for (int i = 0; i < vet.length; i++) {
            if (primoDiv[i] == true) {
                vet[i] = vet[i] / primo;
            }
        }
    }
}
