package modelo;

public class Peao extends Peca{

    private boolean primeiroMovimento = true;
    
    
    public Peao(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna,"/home/operador/Downloads/figs/PEAO"+cor+".gif");
    }
    
    public Peao(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        Peca pecaDestino = getTabuleiro().getPeca(linhaDestino, colunaDestino);
        if(pecaDestino == null && getTabuleiro().getPeca(getLinha()+1,colunaDestino) != null && getCor() == EnumCor.PRETO){
            return false;
        }
         if(pecaDestino == null && getTabuleiro().getPeca(getLinha()-1,colunaDestino) != null && getCor() == EnumCor.BRANCO){
            return false;
        }
        if(pecaDestino == null && colunaDestino != getColuna()){
            return false;
        }
        if(pecaDestino != null && colunaDestino == getColuna()){
            return false;
        }
        if(pecaDestino == null && linhaDestino >= getLinha()+2 && primeiroMovimento != true || pecaDestino == null && linhaDestino <= getLinha()-2 && primeiroMovimento != true && getCor().equals(EnumCor.BRANCO)){
            return false;
        }
        if(pecaDestino == null && linhaDestino > getLinha()+2 || pecaDestino == null && linhaDestino < getLinha()-2 && getCor().equals(EnumCor.BRANCO) ){
            return false; 
        }
        if(getCor().equals(EnumCor.BRANCO) && getLinha() < linhaDestino || getCor().equals(EnumCor.PRETO) && getLinha() > linhaDestino){
           return false;
        }
        if(pecaDestino !=null && colunaDestino != getColuna() && colunaDestino > getColuna() + 1 || pecaDestino !=null && colunaDestino != getColuna() && colunaDestino < getColuna() -1  ){
            return false;
        }
        if(colunaDestino == getColuna()+1 && linhaDestino > getLinha()+1 || colunaDestino == getColuna()-1 && linhaDestino > getLinha()+1){
            return false;
        }
        if(colunaDestino == getColuna()+1 && linhaDestino < getLinha()-1 || colunaDestino == getColuna()-1 && linhaDestino < getLinha()-1){
            return false;
        }
        if(colunaDestino != getColuna() && linhaDestino == getLinha()){
            return false;
        }
        return true;
    }

    

public void setPrimeiroMovimento(boolean primeiroMovimento){
    this.primeiroMovimento = primeiroMovimento;
}
}