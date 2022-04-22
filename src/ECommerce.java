import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ECommerce {

    private String nome;

    private List<Categoria> categoria;

    private List<Usuario> usuarios;

    private int posicao;

    private int posicaoUsuario;

    private String separador = System.getProperty("line.separator");

    public ECommerce(String nome) {
        this.nome = nome;
        this.categoria = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.posicao = 0;
        this.posicaoUsuario = 0;
    }


    // Metodos dos usuarios
    public boolean usuarioExiste(Usuario usuario) {
        for (Usuario usuarioDaVez : this.usuarios) {
            if (usuarioDaVez != null && usuarioDaVez.equals(usuario)) {
                return true;
            }
        }
        return false;
    }


    public boolean adicionaUsuario(Usuario usuario) {
        if (!usuarioExiste(usuario)) {
            usuarios.add(usuario);
        }
        return false;
    }

    public boolean adicionaCategoria(Categoria cat) {
        categoria.add(cat);
        return true;
    }

    public boolean removeCategoria(Categoria cat) {
        categoria.remove(cat);
        return true;
    }


    public String toString() {
        String retorno = this.nome + this.separador;
        for (int i = 0; i < this.categoria.size(); i++) {
            Categoria cat = this.categoria.get(i);
            retorno += (i+1) + ". " + cat.getNome() + this.separador;
        }
        return retorno;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario encontrarUsuarioLogin(String userLogin) {
        for (Usuario usuario : usuarios) {
            if (Objects.nonNull(usuario)) {
                if (usuario.getLogin().equals(userLogin)) {
                    return usuario;
                }
            }

        }
        System.out.println("Usuário não existe");
        return null;
    }

    public Categoria encontrarCategoria(int categoria) {
        return this.categoria.get(categoria - 1);
    }

    public List<Produto> buscarProduto(String nome) {
        List<Produto> listaDeEncontrados = new ArrayList<>();
        for (Categoria cat: categoria) {
            for (Produto prod: cat.getProdutos()) {
                if (prod.getNome().contains(nome)) {
                    listaDeEncontrados.add(prod);
                }
            }
        }
        return listaDeEncontrados;
    }


}
