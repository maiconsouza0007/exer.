package br.edu.univas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

record Produto(int id, String nome, double preco) {
}

class GerenciadorProdutos {
    private final List<Produto> produtos;

    public GerenciadorProdutos() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.id() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.id() + ", Nome: " + produto.nome() + ", Preço: " + produto.preco());
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();

        // Adicionar alguns produtos
        gerenciador.adicionarProduto(new Produto(1, "Camiseta", 29.99));
        gerenciador.adicionarProduto(new Produto(2, "Calça Jeans", 79.99));
        gerenciador.adicionarProduto(new Produto(3, "Tênis", 99.99));

        // Listar os produtos
        gerenciador.listarProdutos();

        // Remover um produto
        gerenciador.removerProduto(2);

        // Listar os produtos novamente
        gerenciador.listarProdutos();
    }
}

