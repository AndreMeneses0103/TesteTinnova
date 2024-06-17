import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private String nome;
    private List<Livro> livrosEmprestados;

    public Leitor(String nome, List<Livro> livrosEmprestados) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void emprestarLivro(Biblioteca biblioteca, Livro livro){
        biblioteca.emprestarLivro(livro);
        if(!livro.isDisponivel()){
            livrosEmprestados.add(livro);
        }
    }

    public void devolverLivro(Biblioteca biblioteca, Livro livro){
        biblioteca.devolverLivro(livro);
        livrosEmprestados.remove(livro);
    }

    public List<Livro> getLivrosEmprestados(){
        return livrosEmprestados;
    }
}
