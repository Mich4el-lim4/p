import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public int mainMenu(){
        System.out.println("1 - cliente");
        System.out.println("2 - funcionario");
        System.out.print("Digite o numero correspondente a opção: ");
        return sc.nextInt();
    }

    public int customerConfirmationMenu(){
        System.out.println("1 - Já sou cliente");
        System.out.println("2 - Fazer cadastro");
        System.out.print("Digite o numero correspondente a opção: ");
        return sc.nextInt();
    }

    public int employeeConfirmationMenu(){
        System.out.println("1 - Já sou funcionario");
        System.out.println("2 - Fazer cadastro");
        System.out.print("Digite o numero correspondente a opção: ");
        return sc.nextInt();
    }

    public String passwordMenu(){
        System.out.print("Digite a senha: ");
        return sc.next();
    }

    public int buyMenu(){
        System.out.println("1 - Mostrar catálogo de produtos");
        System.out.println("2 - Adicionar um produto ao carrinho");
        System.out.println("3 - Mostrar carrinho");
        System.out.println("4 - Remover produto do carrinho");
        System.out.println("1 - Mostrar catálogo de produtos");
        System.out.print("Digite o numero correspondente a opção: ");
        return sc.nextInt();
    }

    public void escolhaDoItem(){
        System.out.println("Qual item deseja adicionar ao carrinho");
    }

    public int EmployeeOptionsMenu(){
        System.out.println("1 - Adicionar item ao estoque");
        System.out.println("2 - Remover item do stoque");
        System.out.println("3 - Confirir lista de clientes");
        System.out.print("Digite o numero correspondente a opção: ");
        return sc.nextInt();
    }
}
