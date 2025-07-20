import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    public Cliente(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }

    List<Itens> itensDoCarrinho = new ArrayList<>();

    public void addItem(Itens item){
        itensDoCarrinho.add(item);
    }

}
