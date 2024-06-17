package GerenciamentoBiblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        Date dataAtual = new Date();
        livro.setDataAdicao(dataAtual);
        livro.setDisponivel(true);
        acervo.add(livro);
    }

    public void emprestarLivro(Livro livro){
        if(livro.isDisponivel()){
            livro.setDisponivel(false);
            Date dataAtual = new Date();
            livro.setDataEmprestimo(dataAtual);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataAtual);
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            Date dataDevolucao = calendar.getTime();
            livro.setDataDevolucao(dataDevolucao);
            System.out.println("GerenciamentoBiblioteca.Livro emprestado: " + livro.getTitulo());
        }else{
            System.out.println("GerenciamentoBiblioteca.Livro " + livro.getTitulo() + " não está disponível para empréstimo");
        }
    }

    public void devolverLivro(Livro livro){
        if(!livro.isDisponivel()){
            livro.setDisponivel(true);

            Date dataAtual = new Date();
            if (dataAtual.after(livro.getDataDevolucao())) {
                long diferencaMillis = dataAtual.getTime() - livro.getDataDevolucao().getTime();
                long diferencaDias = diferencaMillis / (1000 * 60 * 60 * 24);

                double multa = diferencaDias * 5.0;

                System.out.println("Livro devolvido com atraso de " + diferencaDias + " dias.");
                System.out.println("Multa a ser paga: R$ " + multa);
            } else {
                System.out.println("Livro devolvido: " + livro.getTitulo());
            }
        }else{
            System.out.println("GerenciamentoBiblioteca.Livro " + livro.getTitulo() + " já está disponível para empréstimo.");
        }
    }

    public List<Livro> listarLivrosDisponiveis(){
        List<Livro> disponiveis = new ArrayList<>();
        for(Livro livro: acervo){
            if(livro.isDisponivel()){
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public List<Livro> listarLivrosIndisponiveis(){
        List<Livro> indisponiveis = new ArrayList<>();
        for(Livro livro: acervo){
            if(!livro.isDisponivel()){
                indisponiveis.add(livro);
            }
        }
        return indisponiveis;
    }

    public List<Livro> procurarLivrosPorData(Date dataInicio) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getDataAdicao().after(dataInicio)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> listarTodosLivros(){
        return acervo;
    }
}
