import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CarrinhoDeCompras {

    private HashMap<Produto, Integer> listaProdutos;

    private double total;


    private String separador = System.getProperty("line.separator");

    public CarrinhoDeCompras() {
        this.listaProdutos = new HashMap<>();
    }

    public boolean adicionaProdutoCarrinho(Produto produto, int quantidade) {
        listaProdutos.put(produto, quantidade);
        return true;
    }

    private void calcularPreco() {
        this.total = 0;
        for (Map.Entry<Produto, Integer> set : listaProdutos.entrySet()) {
            this.total += set.getKey().getPreco() * set.getValue();
        }
    }

    private boolean produtoExiste(Produto produto) {
        String produtoNomeMinusculo = produto.getNome().toLowerCase(Locale.ROOT);

        for (Map.Entry<Produto, Integer> set : listaProdutos.entrySet()) {
            if (set.getKey() != null && set.getKey().getNome().toLowerCase(Locale.ROOT).equals(produtoNomeMinusculo)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeProdutoCarrinho(Produto produto) {
        if (produtoExiste(produto)) {
            for (Map.Entry<Produto, Integer> set : listaProdutos.entrySet()) {
                if (set.getKey().getNome().equals(produto.getNome())) {
                    listaProdutos.remove(set.getKey());
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        this.calcularPreco();
        String retorno = "Carrinho de compras: " + this.separador;
        int i = 0;
        for (Map.Entry<Produto, Integer> set : listaProdutos.entrySet()) {
            retorno += "===================================================\n";
            retorno += (i+1) + ". Item: " + set.getKey().getNome() + " - Preço: " + set.getKey().getPreco() + " - \n" +
                   " - Quantidade: " + set.getValue() + " - Total: R$" + (this.total);
        }
        return retorno;
    }

}
