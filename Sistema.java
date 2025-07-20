import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    Scanner sc = new Scanner(System.in);
    View view = new View();
    List<Pessoa> pessoas = new ArrayList<>();
    List<Itens> itensDaLoja = new ArrayList<>();

    public void login(int confirmation, int id) {
        if (confirmation == 1) {
            String senha = view.passwordMenu();

            boolean login = false;
            int index = 0;
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i).getSenha().equals(senha)) {
                    login = true;
                    index = i;
                    break;
                }
            }

            if (login) {
                System.out.println("connected");
                System.out.println();

                if (id == 1) {
                    comprar(index);
                }else if (id == 2){
                    int option = view.EmployeeOptionsMenu();
                    System.out.println();

                    switch (option){
                        case 1 -> addItemToStock();
                        case 2 -> {
                            listItens();
                            System.out.print("Qual item deseja remover: ");
                            itensDaLoja.remove(sc.nextInt() + 1);
                        }
                        case 3 -> {
                            System.out.println("Lista de clientes:");
                            System.out.println();
                            for (Pessoa pessoaCliente : pessoas) {
                                if (pessoaCliente instanceof Cliente) {
                                    System.out.println(pessoaCliente);
                                }
                            }
                            System.out.println();
                        }
                    }
                }

            } else {
                System.out.println("incorrect password");
                System.out.println();
            }
        } else if (confirmation == 2) {
            System.out.print("Digite o nome: ");
            String nome = sc.next();
            System.out.print("Digite o cpf: ");
            String cpf = sc.next();
            System.out.print("crie uma senha: ");
            String senha = sc.next();
            System.out.println();

            if (id == 1) {
                pessoas.add(new Cliente(nome, cpf, senha));
            } else if (id == 2) {
                pessoas.add(new Employee(nome, cpf, senha));
            }

        }
    }

    public void principal() {
        int option = view.mainMenu();
        System.out.println();

        switch (option) {
            case 1 -> {
                int confirmation = view.customerConfirmationMenu();
                System.out.println();
                login(confirmation, 1);
            }
            case 2 -> {
                int confirmation = view.employeeConfirmationMenu();
                System.out.println();
                login(confirmation, 2);
            }
        }
    }

    public void listItens() {
        if (!itensDaLoja.isEmpty()) {
            for (int i = 0; i < itensDaLoja.size(); i++) {
                System.out.println(itensDaLoja.get(i).toString());
            }
        } else {
            System.out.println("Não a itens no catálogo ");
            System.out.println();
        }
    }

    public void comprar(int index) {
        int purchaseMenuOption = view.buyMenu();
        System.out.println();

        switch (purchaseMenuOption) {
            case 1 -> listItens();
            case 2 -> {
                view.escolhaDoItem();
                listItens();
                System.out.print("Digite a opção: ");
                int indexItem = sc.nextInt();

                if (indexItem >= 0 && indexItem < itensDaLoja.size()) {
                    Itens addAoCarrinho = itensDaLoja.get(indexItem);
                    Pessoa cliente = pessoas.get(index);

                    if (cliente instanceof Cliente) {
                        ((Cliente) cliente).addItem(addAoCarrinho);
                        System.out.println("Item adicionado ao carrinho!");
                    }
                } else {
                    System.out.println("Ítem inválido!");
                }
            }
        }
    }

    public void addItemToStock(){
        System.out.print("Nome do produto: ");
        String nome = sc.next();
        System.out.print("Valor do produto: ");
        String valor = sc.next();

        Itens itens = new Itens(nome, valor);
        itensDaLoja.add(itens);
    }

}
