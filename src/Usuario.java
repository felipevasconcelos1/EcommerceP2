
public class Usuario {

    private String login;

    private String senha;

    private String nome;

    private TipoEnum tipoEnum;

    public Usuario(String login, String senha, String nome, TipoEnum tipoEnum) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setNome(nome);
        this.tipoEnum = tipoEnum;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.length() > 2)  {
            this.login = login;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Usuario outroUsuario) {
        return this.login.equalsIgnoreCase(outroUsuario.getLogin());
    }


    public TipoEnum getTipoEnum() {
        return tipoEnum;
    }

    public void setTipoEnum(TipoEnum tipoEnum) {
        this.tipoEnum = tipoEnum;
    }
}
