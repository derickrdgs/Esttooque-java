import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSISTEMA DE ESTOQUE");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar quantidade");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    produtos.add(new Produto(nome, qtd, preco));
                    System.out.println("Produto cadastrado.");
                    break;

                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            p.exibir();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nome do produto: ");
                    String nomeBusca = sc.nextLine();

                    for (Produto p : produtos) {
                        if (p.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.print("Nova quantidade: ");
                            int novaQtd = sc.nextInt();
                            p.setQuantidade(novaQtd);
                            System.out.println("Quantidade atualizada.");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nome do produto: ");
                    String remover = sc.nextLine();

                    produtos.removeIf(p -> p.getNome().equalsIgnoreCase(remover));
                    System.out.println("Produto removido.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}    
