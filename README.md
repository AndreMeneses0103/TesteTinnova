# Teste Prático Tinnova Software Solutions
Este repositório contém a implementação do sistema de gestão de biblioteca em pseudocódigo, conforme solicitado no teste prático da Tinnova Software Solutions.

## Descrição do Projeto
O projeto consiste em um sistema de gestão de biblioteca que permite as adicionar e buscar livros, realizar empréstimos e devolve-los.


## Pseudocódigo Implementado
### Biblioteca
```
// Implementação do sistema de gestão de biblioteca em pseudocódigo

Função adicionarLivro(livro):
    livro.dataAdição ← dataAtual
    adicionar livro à acervo

Função emprestarLivro(livro):
    Se livro.disponível então:
        livro.disponível ← falso
        livro.dataEmprestimo ← dataAtual
        livro.dataDevolucao ← dataAtual + 3 dias
        Mostrar "Livro emprestado: " + livro.título
    Senão:
        Mostrar "Livro " + livro.título + " não está disponível para empréstimo"

Função devolverLivro(livro):
    Se não livro.disponível então:
        livro.disponível ← verdadeiro
        Se dataAtual > livro.dataDevolucao então:
            diferencaDias ← calcularDiferencaDias(dataAtual, livro.dataDevolucao)
            multa ← diferencaDias * 5.0
            Mostrar "Livro devolvido com atraso de " + diferencaDias + " dias."
            Mostrar "Multa a ser paga: R$ " + multa
        Senão:
            Mostrar "Livro devolvido: " + livro.título
    Senão:
        Mostrar "Livro " + livro.título + " já está disponível para empréstimo."

Função listarLivrosDisponiveis():
    Para cada livro em acervo:
        Se livro.disponível então:
            Mostrar "Título: " + livro.título + ", Autor: " + livro.autor

Função listarLivrosIndisponiveis():
    Para cada livro em acervo:
        Se não livro.disponível então:
            Mostrar "Título: " + livro.título + ", Autor: " + livro.autor

Função procurarLivrosPorData(dataInicio):
    livrosEncontrados ← lista vazia
    Para cada livro em acervo:
        Se livro.dataAdição > dataInicio então:
            adicionar livro a livrosEncontrados
    retornar livrosEncontrados

Função listarTodosLivros():
    retornar acervo
```
### Exemplo de Utilização
```
// Exemplo de utilização:
// Criar uma nova biblioteca
    biblioteca ← nova Biblioteca()

    // Criar alguns livros
    livroA ← novo Livro("Vidas Secas", "Graciliano Ramos")
    livroB ← novo Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis")
    livroC ← novo Livro("Capitães da Areia", "Jorge Amado")

    // Adicionar livros à biblioteca
    biblioteca.adicionarLivro(livroA)
    biblioteca.adicionarLivro(livroB)
    biblioteca.adicionarLivro(livroC)

    // Criar um leitor
    leitor ← novo Leitor("André")

    // Empréstimo de livros pelo leitor
    leitor.emprestarLivro(biblioteca, livroA)
    leitor.emprestarLivro(biblioteca, livroC)

    // Listar livros emprestados pelo leitor
    livrosEmprestados ← leitor.getLivrosEmprestados()
    Mostrar "Livros emprestados por " + leitor.getNome() + ":"
    Para cada livro em livrosEmprestados:
        Mostrar "- " + livro.getTitulo()
        Mostrar "  Data Devolução: " + livro.getDataDevolucao() + "\n"

    // Devolução de um livro pelo leitor
    leitor.devolverLivro(biblioteca, livroA)

    // Listar livros disponíveis na biblioteca
    livrosDisponiveis ← biblioteca.listarLivrosDisponiveis()
    Mostrar "Livros disponíveis na biblioteca:"
    Para cada livro em livrosDisponiveis:
        Mostrar "- " + livro.getTitulo()

    // Listar todos os livros no acervo da biblioteca
    todosLivros ← biblioteca.listarTodosLivros()
    Mostrar "Todos os livros no acervo da biblioteca:"
    Para cada livro em todosLivros:
        Mostrar "- " + livro.getTitulo() + " (Autor: " + livro.getAutor() + ")"
```
