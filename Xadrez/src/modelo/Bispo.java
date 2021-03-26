package modelo;

public class Bispo extends Peca{

    
    public Bispo(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna,"/home/operador/Downloads/figs/BISPO"+cor+".gif");
    }
    
    public Bispo(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    
    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
       
            int quantidadeLinha = linhaDestino - getLinha();
            int quantidadeColuna = colunaDestino - getColuna();
            
        for (int i = 0; i < 8; i++) {
          
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
         return false;
        }
      
  
}
