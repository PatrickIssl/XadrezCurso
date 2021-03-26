
package modelo;

public class Cavalo extends Peca{

    
    public Cavalo(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna,"/home/operador/Downloads/figs/CAVALO"+cor+".gif");
    }
    
    public Cavalo(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
       if(colunaDestino > getColuna()+2 || colunaDestino< getColuna() -2 || linhaDestino > getLinha()+2 || linhaDestino < getLinha()-2){
           return false;
       }
       
        if(linhaDestino == getLinha()+1 && colunaDestino == getColuna()+1 || linhaDestino == getLinha()-1 && colunaDestino == getColuna()-1|| linhaDestino == getLinha()+1 && colunaDestino == getColuna()-1|| linhaDestino == getLinha()-1 && colunaDestino == getColuna()+1){
          return false;  
        }
        if (getLinha() == linhaDestino || getColuna() == colunaDestino) {
            return false;
        }
        if(colunaDestino == getColuna()+2 ||colunaDestino == getColuna()-2 ){
            if(linhaDestino > getLinha()+1 || linhaDestino < getLinha()-1 ){
                return false;
            }
        }
         if(linhaDestino == getLinha()+2 ||linhaDestino == getLinha()-2 ){
            if(colunaDestino > getColuna()+1 || colunaDestino < getColuna()-1 ){
                return false;
            }
        }
        
        return true;
    }
    
}
