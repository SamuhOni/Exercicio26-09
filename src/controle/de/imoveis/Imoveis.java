package controle.de.imoveis;

import java.util.Scanner;

public class Imoveis {

    private int id;
    private String nome;
    private String endereco;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    void mostrar() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        nome = ler.next();
        System.out.println("Digite o endereco: ");
        endereco = ler.next();
        System.out.println("Digite o preco: ");
        preco = ler.nextDouble();
    }
}
