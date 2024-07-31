import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Digite qual exercício deseja testar (ou 0 para sair):");
            opcao = scanner.nextInt();
            switch (opcao) {

                case 1:
                    pessoas();
                    break;
                case 2:
                    jogoDaVelha();
                    break;

            }
        } while (opcao != 0);
    }

    public static void pessoas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos pesssoas deseja cadrastrar?");
        int quantNome = scanner.nextInt();
        scanner.nextLine();

        String[] pessoas = new String[quantNome];
        int[] idade = new int[quantNome];

        for (int i = 0; i < quantNome; i++) {
            System.out.println("Digite o nome do(a) " + (i + 1) + " pessoa");
            pessoas[i] = scanner.nextLine();
            System.out.println("Digite a idade do(a) " + (i + 1) + " pessoa");
            idade[i] = scanner.nextInt();
            scanner.nextLine();
        }

        maiorIdade(pessoas, idade);

    }

    public static void maiorIdade(String[] pessoas, int[] idade) {

        for (int i = 0; i < pessoas.length; i++) {
            if (idade[i] < 18) {
                System.out.println(pessoas[i] + " é menor de idade");
            } else {
                System.out.println(pessoas[i] + " é maior de idade");
            }
        }
    }

    public static void jogoDaVelha() {

        Scanner scanner = new Scanner(System.in);

        char[][] tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' '; // Inicializa com espaços em branco
            }
        }
        char jogadorAtual = 'x';

        boolean vencerdor = false;

        for (int i = 0; i < 9; i++) {

            int y, x;

            System.out.println("Digite qual posição você deseja marcar");

            do {
                printTabuleiro(tabuleiro);
                System.out.println("Digite a linha que você deseja adicionar");
                x = scanner.nextInt();
                System.out.println("Agora digite a coluna em que deseja adicionar");
                y = scanner.nextInt();
            }
            while (x < 1 || x > 3 || y < 1 || y > 3 || tabuleiro[x - 1][y - 1] != ' ');

            tabuleiro[x - 1][y - 1] = jogadorAtual;

            if (verificaVencedor(tabuleiro, jogadorAtual)) {
                printTabuleiro(tabuleiro);
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                vencerdor = true;
                break;
            }

            jogadorAtual = (jogadorAtual == 'x') ? 'o' : 'x'; // Alterna o jogador
        }

        if (!vencerdor) {
            printTabuleiro(tabuleiro);
            System.out.println("Empate!");
        }
    }

    private static void printTabuleiro(char[][] tabuleiro) {

        System.out.print(tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println();
        System.out.print("----------");
        System.out.println();
        System.out.print(tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println();
        System.out.print("----------");
        System.out.println();
        System.out.print(tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
        System.out.println();

    }

    private static boolean verificaVencedor(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                    (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        return false;
    }
}
