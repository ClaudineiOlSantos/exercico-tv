package arrays;

import java.util.Scanner;

/**
 *
 * @author claudinei
 */
public class TestaTelevisao {

    public static void main(String[] args) throws Exception {

        String[] canais
                = {"Globo",
                    "SBT",
                    "Bandeirantes",
                    "Record",
                    "TV Cultura",
                    "Rede TV",
                    "Canal do Boi",
                    "HBO",
                    "National Geographic",
                    "History Channel"};

        Televisao tv = new Televisao(100, canais);
        Scanner input = new Scanner(System.in);

        //menu
        int resposta = 0;

        System.out.println("1 - On/Off");
        System.out.println("2 - << Volume");
        System.out.println("3 - Volume >>");
        System.out.println("4 - << Canal");
        System.out.println("5 - Canal >>");
        System.out.println("6 - Informar canal");
        System.out.println("0 - Sair");

        do {
            System.out.println("\n\n------------------------------------------------");
            System.out.println("Escolha a opção desejada:");

            resposta = input.nextInt();
            try {
                switch (resposta) {
                    case 1://Liga ou desliga TV

                        if (tv.ligaDesliga()) {
                            System.out.println("A TV está ligada e você está assistindo: " + tv.getCanalAtual());
                        } else {
                            System.out.println("A TV está desligada...");
                        }
                        break;
                    case 2://Diminue Volume
                        System.out.println("Volume: " + tv.diminueVolume());
                        break;
                    case 3://Aumenta Volume
                        System.out.println("Volume: " + tv.aumentaVolume());
                        break;
                    case 4://Diminue Canal
                        System.out.println("Você está assistindo: " + tv.diminueCanal());
                        break;
                    case 5://Aumenta Canal
                        System.out.println("Você está assistindo: " + tv.aumentaCanal());
                        break;
                    case 6://Informar canal
                        System.out.println("Informe o número do canal entre 1 e " + tv.getNumeroCanais());
                        input.nextInt();
                        System.out.println("Você está assistindo:" + tv.mudaCanal(resposta));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (resposta != 0);
    }

}
