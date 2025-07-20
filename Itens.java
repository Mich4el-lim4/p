public class Itens {

    String nome;
    String valor;
    String id;

    public Itens(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Itens:\n" +
                "Produto = " + nome +
                "\nValor = " + valor;
    }
}
