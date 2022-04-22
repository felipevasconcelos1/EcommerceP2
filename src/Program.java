import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        ECommerce comercio = new ECommerce("Mercado Nada Livre");
        Usuario admin = new Usuario("admin", "admin", "Admin", TipoEnum.ADMINISTRADOR);

        /* - Input de usuários/cat/prod para teste
        Usuario vendedorMock = new Usuario("vendedor", "123", "vendedor", TipoEnum.VENDEDOR);
        Usuario clienteMock = new Usuario("cliente", "123", "cccccc", TipoEnum.USUARIO);
        Categoria categoriaMock = new Categoria("comida");
        Produto produtoMock = new Produto("ovo", 2.5);
        comercio.adicionaUsuario(admin);
        comercio.adicionaUsuario(vendedorMock);
        comercio.adicionaUsuario(clienteMock);
        categoriaMock.adicionaProduto(produtoMock);
        comercio.adicionaCategoria(categoriaMock);

         */

        System.out.print("1. Login\n2. Cadastro\n3. Sair\nEscolha uma opção (1 a 3): ");

        int escolha = sc.nextInt();
        sc.nextLine();

        while (escolha != 3) {

            if (escolha == 1) {
                // Implementa Login
                System.out.print("Digite seu login: ");
                String userLogin = sc.nextLine();
                System.out.println();

                Usuario usuarioEncontrado = comercio.encontrarUsuarioLogin(userLogin);

                if (Objects.nonNull(usuarioEncontrado)) {
                    System.out.print("Digite sua senha: ");
                    String userSenha = sc.nextLine();
                    if (usuarioEncontrado.getSenha().equals(userSenha)) {
                        TipoEnum classificacao = usuarioEncontrado.getTipoEnum();
                        if (classificacao.equals(TipoEnum.VENDEDOR)) {
                            // MENU VENDEDOR

                            System.out.println("Tela de vendedor");
                            // mostra opcoes de criar produto, e adicionar em categorias
                            while (escolha != 5) {
                                System.out.println(comercio);
                                System.out.println("1. Listar Produtos\n2. Inserir Produto\n3. Editar Produto" +
                                        "\n4. Excluir Produto\n5. Voltar");
                                escolha = sc.nextInt();
                                sc.nextLine();
                                if (escolha == 1) {
                                    // Implementar listagem de produtos por categoria daquele vendedor
                                }else if (escolha == 2) {
                                    // Perguntar em qual categoria ele deseja adicionar o produto
                                    System.out.println(comercio);
                                    System.out.print("Digite um numero referente a categoria do produto: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();

                                    Categoria categoria2 = comercio.encontrarCategoria(categoria);
                                    System.out.print("Qual o nome do produto a ser cadastrado? ");
                                    String nomeProduto = sc.nextLine();
                                    System.out.print("Qual o preco do produto a ser cadastrado? ");
                                    double precoProduto = sc.nextDouble();
                                    sc.nextLine();

                                    Produto produto = new Produto(nomeProduto, precoProduto);
                                    categoria2.adicionaProduto(produto);

                                    System.out.println(categoria2);


                                    // Opcoes de adicionar o produto naquela categoria
                                } else if (escolha == 3){
                                    // Perguntar em qual categoria o produto sera editado
                                    System.out.println(comercio);
                                    System.out.print("Digite um numero referente a categoria do produto: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();

                                    Categoria categoria2 = comercio.encontrarCategoria(categoria);
                                    // Listar produtos da categoria - Para input de qual será editado
                                    System.out.println(categoria2);
                                    System.out.print("Qual o numero do produto a ser editado? ");
                                    int produtoEditarIndice = sc.nextInt();
                                    sc.nextLine();

                                    Produto produtoEcontrado = categoria2.encontraProduto(produtoEditarIndice);
                                    // Nome ou preco?
                                    System.out.print("1. Nome \n2. Preço\nDigite o número correspondente ao que " +
                                            "Desejas editar: ");
                                    int atributoEditar = sc.nextInt();
                                    sc.nextLine();

                                    if (atributoEditar == 1) {
                                        System.out.print("Digite o novo nome do produto: ");
                                        String produtoNovoNome = sc.nextLine();
                                        produtoEcontrado.setNome(produtoNovoNome);
                                        System.out.println("Nome alterado com sucesso!");
                                    } else if (atributoEditar == 2) {
                                        System.out.print("Digite o novo preço do produto: ");
                                        double produtoNovoPreco = sc.nextDouble();
                                        sc.nextLine();
                                        produtoEcontrado.setPreco(produtoNovoPreco);
                                        System.out.println("Preço alterado com sucesso!");
                                    } else {
                                        System.out.println("Opção Inválida. Por favor, tente novamente!");
                                    }

                                } else if (escolha == 4) {
                                    // Perguntar em qual categoria o produto sera excluido
                                    System.out.println(comercio);
                                    System.out.print("Digite um numero referente a categoria do produto: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();

                                    Categoria categoria2 = comercio.encontrarCategoria(categoria);
                                    // Listar produtos da categoria - Para input de qual será editado
                                    System.out.println(categoria2);
                                    System.out.print("Qual o numero do produto a ser editado? ");
                                    int produtoEditarIndice = sc.nextInt();
                                    sc.nextLine();

                                    Produto produtoEcontrado = categoria2.encontraProduto(produtoEditarIndice);
                                    categoria2.removeProduto(produtoEcontrado);
                                }
                            }

                        } else if (classificacao.equals(TipoEnum.USUARIO)) {
                            // MENU CLIENTE
                            System.out.println("Tela de cliente");
                            CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
                            System.out.println("1. Buscar Produto\n2. Adicionar ao carrinho\n3. Finalizar compra\n4. Remover produto do carrinho\n5. Finalizar compra");
                            System.out.print("Escolha uma opção: ");
                            escolha = sc.nextInt();
                            sc.nextLine();

                            while (escolha != 5) {
                                // mostra categorias e opcao de busca, depois opcoes de finalizar compra
                                if (escolha == 1) {
                                    System.out.print("Digite o produto que deseja buscar: ");
                                    String nome = sc.nextLine();
                                    List<Produto> produtosEncontrado = comercio.buscarProduto(nome);
                                    System.out.println(produtosEncontrado.size() < 1 ? "Não encontramos nenhum intem" : produtosEncontrado);
                                } else if (escolha == 2) {
                                    // Adicionar itens no carrinho percorrendo categorias
                                    System.out.println(comercio);
                                    System.out.print("Digite um numero referente a categoria do produto: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();

                                    Categoria categoria2 = comercio.encontrarCategoria(categoria);
                                    System.out.println(categoria2);
                                    System.out.print("Selecione o produto desejado: ");
                                    int produtoEditarIndice = sc.nextInt();
                                    sc.nextLine();

                                    Produto produtoEcontrado = categoria2.encontraProduto(produtoEditarIndice);
                                    System.out.print("Quantas unidades de você deseja comprar? ");
                                    int quantidadeProduto = sc.nextInt();
                                    sc.nextLine();

                                    carrinhoDeCompras.adicionaProdutoCarrinho(produtoEcontrado, quantidadeProduto);
                                    System.out.println(carrinhoDeCompras);

                                } else if (escolha == 3) {
                                    // implementa
                                } else if (escolha == 4) {
                                    // Metodo retirar produto do carrinho
                                    System.out.println(carrinhoDeCompras);
                                    System.out.print("Qual produto você deseja remover do carrinho? ");
                                    String nomeProd = sc.nextLine();
                                    Produto paraRemover = new Produto(nomeProd, 12);
                                    carrinhoDeCompras.removeProdutoCarrinho(paraRemover);
                                    System.out.println(carrinhoDeCompras);
                                }

                                System.out.println("1. Buscar Produto\n2. Adicionar ao carrinho\n3. Finalizar compra\n4. Remover produto do carrinho\n5. Finalizar compra");
                                System.out.print("Escolha uma opção: ");
                                escolha = sc.nextInt();
                                sc.nextLine();

                            }


                        } else {
                            // MENU ADMIN

                            while (escolha != 5) {
                                // se o usuario logado eh admin, mostra opcoes de categorias.
                                System.out.println("Tela do Administrador");
                                System.out.println("1. Listar Categoria\n2. Inserir Categoria\n3. Editar Categoria" +
                                        "\n4. Excluir categoria\n5. Voltar");
                                escolha = sc.nextInt();
                                sc.nextLine();

                                if (escolha == 1) {
                                    System.out.println(comercio);
                                } else if (escolha == 2) {
                                    System.out.println("Inserindo categoria");
                                    System.out.print("Digite o nome da categoria a ser inserida: ");
                                    String nomeCategoria = sc.nextLine();
                                    Categoria categoria = new Categoria(nomeCategoria);
                                    comercio.adicionaCategoria(categoria);
                                } else if (escolha == 3) {
                                    System.out.println("Editando a categoria");
                                    System.out.println(comercio);
                                    System.out.print("Digite o numero da categoria a ser editada: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();

                                    Categoria categoria2 = comercio.encontrarCategoria(categoria);
                                    System.out.print("Digite o novo nome da categoria: ");
                                    String categoriaNovoNome = sc.nextLine();
                                    categoria2.setNome(categoriaNovoNome);
                                    System.out.println("Categoria editada com sucesso!");
                                } else if (escolha == 4) {
                                    System.out.println("Excluindo categoria");
                                    System.out.println(comercio);
                                    System.out.print("Digite o numero da categoria a ser excluida: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();

                                    Categoria categoria2 = comercio.encontrarCategoria(categoria);
                                    comercio.removeCategoria(categoria2);
                                    if (comercio.removeCategoria(categoria2)) {
                                        System.out.println("Categoria removida com sucesso!");
                                    } else {
                                        System.out.println("Erro! Tente novamente.");
                                    }
                                }
                            }

                        }
                    } else  {
                        System.out.println("Senha incorreta");
                    }
                }


            } else if (escolha == 2) {

                System.out.print("1. Vendedor\n2. Cliente\n3. Voltar\nEscolha uma opção (1 a 3): ");
                escolha = Integer.parseInt(sc.nextLine());

                if (escolha == 1 || escolha == 2) {
                    System.out.print("Digite o login: ");
                    String login = sc.nextLine();

                    System.out.print("Digite o senha: ");
                    String senha = sc.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    if (escolha == 1) {
                        Vendedor vendedor = new Vendedor(login, senha, nome, TipoEnum.VENDEDOR);
                        comercio.adicionaUsuario(vendedor);
                        System.out.println("Vendedor(a) cadastrado(a) com sucesso");
                    } else {
                        Cliente cliente = new Cliente(login, senha, nome, TipoEnum.USUARIO);
                        comercio.adicionaUsuario(cliente);
                        System.out.println("Cliente cadastrado(a) com sucesso");
                        System.out.println(cliente.getTipoEnum());
                    }
                }


            } else {
                System.out.println("Opção Inválida");
            }

            System.out.print("1. Login\n2. Cadastro\n3. Sair\nEscolha uma opção (1 a 3): ");
            escolha = sc.nextInt();
            sc.nextLine();

        }

    }
}


