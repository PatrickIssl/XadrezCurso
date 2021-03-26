package modelo;

public class Rei extends Peca{

    public Rei(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna,"/home/operador/Downloads/figs/REI"+cor+".gif");
    }
    public Rei(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        if (colunaDestino > getColuna()+1 || linhaDestino > getLinha()+1){
            return false;
        }
        if (colunaDestino < getColuna()-1 || linhaDestino < getLinha()-1){
            return false;
        }
        return true;
    }
    
}
