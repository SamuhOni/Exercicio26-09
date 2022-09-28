
package controle.de.imoveis;


public class ImovUsado extends Imoveis {
    
     double precoDesconto(){
        double resultado = this.getPreco() - getPreco() * 0.05;
        return resultado;
    }
    
}
