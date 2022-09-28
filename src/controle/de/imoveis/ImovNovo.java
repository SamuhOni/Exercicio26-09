
package controle.de.imoveis;


public class ImovNovo extends Imoveis {
    
    double precoAcrescimo(){
        double resultado = this.getPreco() * 0.1;
        return resultado;
    }
    
}
