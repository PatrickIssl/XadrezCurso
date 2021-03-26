package modelo;

public class Torre extends Peca{

    public Torre(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna,"/home/operador/Downloads/figs/TORRE"+cor+".gif");
    }

    public Torre(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        if(getColuna() != colunaDestino && getLinha() != linhaDestino){
            return false;
        }
        if (getColuna() == colunaDestino) {
            for (int i = getLinha()-1; i > linhaDestino; i--) {
                if(getTabuleiro().getPeca(i, getColuna()) != null){
                    return false;
                }
            }
           for (int i = getLinha()+1; i < linhaDestino; i++) {
                if(getTabuleiro().getPeca(i, getColuna()) != null){
                    return false;
                }
            }
        }
         if (getLinha()== linhaDestino) {
            for (int i = getColuna()-1; i > colunaDestino; i--) {
                if(getTabuleiro().getPeca(getLinha(), i) != null){
                    return false;
                }
            }
           for (int i = getColuna()+1; i < colunaDestino; i++) {
                if(getTabuleiro().getPeca(getLinha(), i) != null){
                    return false;
                }
            }
        }
        
        
        
        return true;
    }
    
}
