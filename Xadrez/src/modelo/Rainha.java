package modelo;

public class Rainha extends Peca{

    
    public Rainha(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna,"/home/operador/Downloads/figs/RAINHA"+cor+".gif");
    }
    
    public Rainha(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
          for (int i = 1; i < 8; i++) {
            
                //SE
               
                if(colunaDestino == getColuna()+i && linhaDestino == getLinha()+i){
                    int contador = colunaDestino - getColuna();
                    for (int j = 1; j < contador; j++) {
                        Peca pecateste = getTabuleiro().getPeca(getLinha()+j, getColuna()+j);
                        if(pecateste != null){
                         return false;
                        }
                    }
                    return true;    
                }
                
                //NW
                if(colunaDestino == getColuna()-i && linhaDestino == getLinha()-i){
                     int contador = colunaDestino - getColuna();
                    for (int j = -1; j > contador; j--) {
                        Peca pecateste = getTabuleiro().getPeca(getLinha()+j, getColuna()+j);
                        if(pecateste != null){
                         return false;
                        }
                    }
                    return true;
                }

                //NE
                 if(colunaDestino == getColuna()+i && linhaDestino == getLinha()-i){
                    int contador = colunaDestino - getColuna();
                    for (int j = 1; j < contador; j++) {
                        Peca pecateste = getTabuleiro().getPeca(getLinha()-j, getColuna()+j);
                        if(pecateste != null){
                         return false;
                        }
                    }
                     return true;
                }

                 
                 if(colunaDestino == getColuna()-i && linhaDestino == getLinha()+i){
                    int contador = getColuna() - colunaDestino;
                    for (int j = 1; j < contador; j++) {
                        Peca pecateste = getTabuleiro().getPeca(getLinha()+j, getColuna()-j);
                        if(pecateste != null){
                         return false;
                        }
                    }
                     return true;
                }  
        } 
          
          
          
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
