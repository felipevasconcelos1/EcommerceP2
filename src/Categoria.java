import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String nome;

    private List<Produto> produtos;

    private int posicao;

    private String separador = System.getProperty("line.separator");

    public Categoria(String nome) {
        this.nome = nome;
        this.posicao = 0;
        this.produtos = new ArrayList<>();
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    private boolean produtoExite(Produto produto) {
        for (Produto produtoDaVez : this.produtos) {
            if (produtoDaVez != null && produtoDaVez.equals(produto)) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionaProduto(Produto prod) {
        if (!produtoExite(prod)) {
            produtos.add(prod);
            return true;
        } else
            System.out.println("Erro! Produto já está cadastrado.");
            return false;
    }

    public boolean removeProduto(Produto prod) {
        if (!produtoExite(prod)) {
            System.out.println("Erro! Produto não cadastrado");
            return false;
        } else {
            produtos.remove(prod);
            System.out.println("Produto exluido com sucesso!");
            return true;
        }
    }

    public Produto encontraProduto(int produto) {
        return this.produtos.get(produto - 1);
    }



    public String toString() {
        String retorno = this.nome + this.separador;
        for (int i = 0; i < this.produtos.size(); i++) {
            Produto prod1 = this.produtos.get(i);
            retorno += (i+1) + ". " + prod1.getNome() + " - " + prod1.getPreco() + this.separador; // Formatar para 2 casas decimais
        }
        return retorno;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}