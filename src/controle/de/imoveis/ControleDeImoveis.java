package controle.de.imoveis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ControleDeImoveis {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner ler = new Scanner(System.in);
        Connection connection = null;

        int num = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String serverName = "127.0.0.1:3306";
            String mydatabase = "aula";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true$serverTimezone=UTC";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("STATUS--->Conectado com sucesso!");
            } else {
                System.out.println("STATUS--->Nao foi possivel realizar conexao");
            }
            while (num != 9) {
                System.out.println("1 - Imoveis Novos\n2 - Imoveis Usados\n9 - Sair.\n");
                num = ler.nextInt();
            }
            if (num == 1) {
                ImovNovo imovnovo = new ImovNovo();
                imovnovo.mostrar();
                double retornoMetodo = imovnovo.precoAcrescimo();
                System.out.println("Valor a pagar do imovel novo com acrescimo: " + retornoMetodo);            
                    String sql = "INSERT INTO Imoveis (nome, endereco, preco) Values (?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, imovnovo.getNome());
                    ps.setString(2, imovnovo.getEndereco());
                    ps.setDouble(3, imovnovo.getPreco());
                    ps.setDouble(4, retornoMetodo);
                    ps.setInt(5, num);
                    ps.execute();
            }

            if (num == 2) {
                ImovUsado imovusado = new ImovUsado();
                imovusado.mostrar();
                double retornoMetodo = imovusado.precoDesconto();
                System.out.println("Valor a pagar do imovel usado com desconto: " + retornoMetodo);
                String sql = "INSERT INTO Imoveis (nome, endereco, preco) Values (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, imovusado.getNome());
                ps.setString(2, imovusado.getEndereco());
                ps.setDouble(3, imovusado.getPreco());
                ps.setDouble(4, retornoMetodo);
                ps.setInt(5, num);
                ps.execute();
            }

        } catch (ClassNotFoundException e) {  //Driver nao encontrado
            System.out.println("O driver exoecificado nao foi encontrado.");
        } catch (SQLException e) {
            //Nao consegue se conectar ao banco
            System.out.println("Nao foi possivel conectar ao banco de dados." + e.getMessage());
        } finally {
            connection.close();
        }

    }
}

