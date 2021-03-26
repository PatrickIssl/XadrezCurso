package visao;

import controle.ControlaTempo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import modelo.EnumCor;
import modelo.Tabuleiro;


public class JXadrez extends JFrame{
    
    private static JLabel lbVez;
    
    private Tabuleiro tabuleiro;
    
    private JButton btReiniciarJogo;
    private JButton btPassaVez;
    private ControlaTempo controlaTempo;
    private final JTabuleiro jTabuleiro;
    public static final JPanel painelCemiterio = new JPanel();
    public JProgressBar pbTempo;
    
    
    public JXadrez(){
        setTitle("Jogo de Xadrez");
        this.setLayout(new BorderLayout());
        pbTempo = new JProgressBar();
        pbTempo.setMinimum(0);
        pbTempo.setMaximum(10000);
        pbTempo.setValue(50);
        pbTempo.setOrientation(WIDTH);
        this.controlaTempo = new ControlaTempo(pbTempo);
        this.tabuleiro = new Tabuleiro(controlaTempo);
        this.jTabuleiro = new JTabuleiro(tabuleiro);
        controlaTempo.setJTabuleiro(jTabuleiro);
        this.add(jTabuleiro,BorderLayout.CENTER);
        
        JPanel pnTopo = new JPanel();
        lbVez = new JLabel("VEZ DE: BRANCO");
        pnTopo.add(lbVez);
        this.add(pnTopo, BorderLayout.NORTH);
        
        JPanel pnLateral = new JPanel();
        pnLateral.setLayout(new GridLayout(10,1));
        btReiniciarJogo = new JButton("Reiniciar Jogo");
        
        btPassaVez = new JButton("Passa a Vez");
        pnLateral.add(btReiniciarJogo);
        pnLateral.add(btPassaVez);
        
    
        btPassaVez.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if(jTabuleiro.getTabuleiro().getPecaSelecionada() != null){
                       jTabuleiro.getTabuleiro().getPecaSelecionada().setSelecionada(false);
                       jTabuleiro.getTabuleiro().setPecaSelecionada(null); 
                    }
                    jTabuleiro.getTabuleiro().inverteVez();
                    jTabuleiro.desenhaTabuleiro();
            }
        });
        
        
        btReiniciarJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
               reiniciaJogo();
            }
        });
        
      
        painelCemiterio.setLayout(new FlowLayout());
        this.add(painelCemiterio, BorderLayout.SOUTH);
        
        this.add(pnLateral, BorderLayout.WEST);
        this.add(pbTempo,BorderLayout.EAST);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Thread threadTempo = new Thread(controlaTempo);
        threadTempo.start();
        
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String args[]){
        new JXadrez();
    }
    
    private void reiniciaJogo(){
            controlaTempo.zeraCronometro();
            this.tabuleiro = new Tabuleiro(controlaTempo);
            this.jTabuleiro.setTabuleiro(tabuleiro);
            this.jTabuleiro.desenhaTabuleiro();
            setVez(tabuleiro.getVez());
    }
    
     
    
    
    public static void setVez(EnumCor corVez){
        lbVez.setText("VEZ DE: "+corVez);
    }
    
}
