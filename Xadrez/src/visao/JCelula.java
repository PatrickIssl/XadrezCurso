package visao;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class JCelula extends JPanel{
    
    private JPeca jPeca;
    
    private int linha, coluna;
    
    public JCelula(int linha, int coluna){
        this.linha= linha;
        this.coluna= coluna;
    }
    
    public JCelula(JPeca jPeca){
        this.jPeca = jPeca;
        this.linha = jPeca.getPeca().getLinha();
        this.coluna = jPeca.getPeca().getColuna();
        this.add(jPeca);
        if((jPeca.getPeca() != null) && jPeca.getPeca().isSelecionada()){
            this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        }
    }

    public JPeca getjPeca() {
        return jPeca;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setjPeca(JPeca jPeca) {
        this.jPeca = jPeca;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    
}
