import GerenciamentoBiblioteca.Biblioteca;
import GerenciamentoBiblioteca.Leitor;
import GerenciamentoBiblioteca.Livro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livroA = new Livro("Vidas Secas", "Graciliano Ramos");
        Livro livroB = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis");
        Livro livroC = new Livro("Capitães da Areia", "Jorge Amado");

        biblioteca.adicionarLivro(livroA);
        biblioteca.adicionarLivro(livroB);
        biblioteca.adicionarLivro(livroC);

        Leitor leitor = new Leitor("André");

        leitor.emprestarLivro(biblioteca, livroA);
        leitor.emprestarLivro(biblioteca, livroC);

        List<Livro> livrosEmprestados = leitor.getLivrosEmprestados();
        System.out.println("Livros emprestados por " + leitor.getNome() + ":");
        for (Livro livro : livrosEmprestados) {
            System.out.println("- " + livro.getTitulo());
            System.out.println("  Data Devolução: " + livro.getDataDevolucao() + "\n");
        }

        leitor.devolverLivro(biblioteca, livroA);

        List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
        System.out.println("\nLivros disponíveis na biblioteca:");
        for (Livro livro : livrosDisponiveis) {
            System.out.println("- " + livro.getTitulo());
        }

        List<Livro> todosLivros = biblioteca.listarTodosLivros();
        System.out.println("\nTodos os livros no acervo da biblioteca:");
        for (Livro livro : todosLivros) {
            System.out.println("- " + livro.getTitulo() + " (Autor: " + livro.getAutor() + ")");
        }
    }
}
