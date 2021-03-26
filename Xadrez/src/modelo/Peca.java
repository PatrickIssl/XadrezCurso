package modelo;

public abstract class Peca {
    
    private EnumCor cor;
    private int linha,coluna;
    private String imagem;
    private boolean eliminada = false;
    private boolean selecionada = false;
    private Tabuleiro tabuleiro;

    public Peca(EnumCor cor, int linha, int coluna, String imagem){
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.imagem = imagem;
    }
    
    public abstract boolean validaMovimento(int linhaDestino, int colunaDestino);
    
    public EnumCor getCor() {
        return cor;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String getImagem() {
        return imagem;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public boolean isSelecionada() {
        return selecionada;
    }

    public void setCor(EnumCor cor) {
        this.cor = cor;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    
    
}
