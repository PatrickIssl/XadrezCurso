package controle;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import modelo.Peca;
import modelo.Tabuleiro;
import visao.JTabuleiro;

public class ControlaTempo implements Runnable {

    private JTabuleiro jTabuleiro;
    
    private int tempoGasto = 0;
    
    private JProgressBar barraProgresso;
    
    public ControlaTempo(JProgressBar pbTempo){
        super();
        this.barraProgresso = pbTempo;
    }
    
    public void setJTabuleiro(JTabuleiro jTabuleiro){
        this.jTabuleiro = jTabuleiro;
    }
    
    public void zeraCronometro(){
        this.tempoGasto = 0;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1);
                tempoGasto += 1;
                barraProgresso.setValue(tempoGasto);
                if (tempoGasto > 0 && tempoGasto < 5000){
                    barraProgresso.setForeground(Color.GREEN);
                }else if (tempoGasto >= 5000 & tempoGasto < 8000){
                    barraProgresso.setForeground(Color.YELLOW);
                }else if (tempoGasto >= 8000){
                    barraProgresso.setForeground(Color.RED);
                }
                
                if(tempoGasto >= Tabuleiro.TEMPO_JOGADA){
                    JOptionPane.showMessageDialog(null, "O Jogador "+ jTabuleiro.getTabuleiro().getVez() + " perdeu a vez");
                    if(jTabuleiro.getTabuleiro().getPecaSelecionada() != null){
                       jTabuleiro.getTabuleiro().getPecaSelecionada().setSelecionada(false);
                       jTabuleiro.getTabuleiro().setPecaSelecionada(null); 
                    }
                    jTabuleiro.getTabuleiro().inverteVez();
                    jTabuleiro.desenhaTabuleiro();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
      }
    
}
