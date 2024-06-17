package GerenciamentoBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> acervo;

    public Biblioteca(List<Livro> acervo) {
        this.acervo = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        acervo.add(livro);
    }

    public void emprestarLivro(Livro livro){
        if(livro.isDisponivel()){
            livro.setDisponivel(false);
            System.out.println("GerenciamentoBiblioteca.Livro emprestado: " + livro.getTitulo());
        }else{
            System.out.println("GerenciamentoBiblioteca.Livro " + livro.getTitulo() + " não está disponível para empréstimo");
        }
    }

    public void devolverLivro(Livro livro){
        if(!livro.isDisponivel()){
            livro.setDisponivel(true);
            System.out.println("GerenciamentoBiblioteca.Livro devolvido" + livro.getTitulo());
        }else{
            System.out.println("GerenciamentoBiblioteca.Livro " + livro.getTitulo() + " já está disponível para empréstimo.");
        }
    }

    public void listarLivrosDisponiveis(){
        boolean algumDisp = false;
        System.out.println("Livros disponíveis:");
        for(Livro livro : acervo){
            if(livro.isDisponivel()){
                algumDisp = true;
                System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
            }
        }
        if(!algumDisp){
            System.out.println("Não há livros disponíveis.");
        }
    }
}
