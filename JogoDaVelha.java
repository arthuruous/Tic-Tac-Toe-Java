package jogodavelha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JogoDaVelha extends JFrame {
    JLabel tela; //rótulo
    JButton[] c = new JButton[9];
    boolean turn = true;

    public JogoDaVelha(){
        super("Super Jogo Da Velha");
        
        //formatações
        setLayout(null);
        setSize(387,407);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        tela = new JLabel();
        setContentPane(tela);

        for(int i=0;i<9;i++){
            c[i] = new JButton("");
        }
        for(int i=0;i<9;i++){
            c[i].setBackground(Color.black);
        }
        for(int i=0;i<9;i++){
            c[i].setFont(new Font("Comic Sans MS",Font.BOLD,30));
        }
        for(int i=0;i<9;i++){
            tela.add(c[i]);
        }
        
        //posicionamento e tamanho
        int x = 15, y = 15;
        for(int i=0;i<9;i++){
            c[i].setBounds(x,y,110,110); //x,y
            x += 115;
            if((i+1) % 3 == 0){
                y += 115;
                x = 15;
            }
        }
      
        for(int i=0;i<9;i++){
            int s = i;
            int b = i;
            c[i].addActionListener((ActionEvent e) -> {
                String jogador;
                if(c[b].getText().equals("")){ //verifica caso o campo por vazio
                    if(turn){
                        jogador = "X";
                        c[b].setText("X");
                    }
                    else{
                        jogador = "O";
                        c[b].setText("O");
                    }
                    c[b].setEnabled(false);
                    if(draw()){
                        JOptionPane.showMessageDialog(null, "Empate!");
                        reset();
                    }
                    if(vitoria()){
                        JOptionPane.showMessageDialog(null, "O jogador "+jogador+" venceu!");
                        reset();
                    }
                    else{
                        turn = !turn; //altera para o valor contrário
                    }
                }
            });
        }
    }
    
    public boolean vitoria(){
        String[][] tabela = new String[3][3];
        for(int i=0;i<9;i++){
            tabela[i/3][i%3] = c[i].getText(); // 1/3 = 0 (divisão inteira); 1%3 = 1 (divisão aproxiamada)
        }
        for(int l=0;l<3;l++){
            for(int c=0;c<3;c++){
                if(tabela[l][c] == "X"){
                    if((tabela[0][0] == "X" && tabela[0][1] == "X" && tabela[0][2] == "X") || (tabela[1][0] == "X" && tabela[1][1] == "X" && tabela[1][2] == "X") || (tabela[2][0] == "X" && tabela[2][1] == "X" && tabela[2][2] == "X")){
                        return true;
                    }
                    else if((tabela[0][0] == "X" && tabela[1][0] == "X" && tabela[2][0] == "X") || (tabela[0][1] == "X" && tabela[1][1] == "X" && tabela[2][1] == "X") || (tabela[0][2] == "X" && tabela[1][2] == "X" && tabela[2][2] == "X")){
                        return true;
                    }
                    else if((tabela[0][0] == "X" && tabela[1][1] == "X" && tabela[2][2] == "X") || (tabela[0][2] == "X" && tabela[1][1] == "X" && tabela[2][0] == "X")){
                        return true;
                    }
                    break;
                }
                else{
                    if((tabela[0][0] == "O" && tabela[0][1] == "O" && tabela[0][2] == "O") || (tabela[1][0] == "O" && tabela[1][1] == "O" && tabela[1][2] == "O") || (tabela[2][0] == "O" && tabela[2][1] == "O" && tabela[2][2] == "O")){
                        return true;
                    }
                    else if((tabela[0][0] == "O" && tabela[1][0] == "O" && tabela[2][0] == "O") || (tabela[0][1] == "O" && tabela[1][1] == "O" && tabela[2][1] == "O") || (tabela[0][2] == "O" && tabela[1][2] == "O" && tabela[2][2] == "O")){
                        return true;
                    }
                    else if((tabela[0][0] == "O" && tabela[1][1] == "O" && tabela[2][2] == "O") || (tabela[0][2] == "O" && tabela[1][1] == "O" && tabela[2][0] == "O")){
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    public boolean draw(){
        for(int i=0;i<9;i++){
            if(c[i].getText().equals("")){
                return false;
            }
        }
        return true;
    }
    
    public void reset(){
        for(int i=0;i<9;i++){
            c[i].setText("");
            c[i].setEnabled(true);
        }
        turn = !turn;
    }
    
    public static void main(String[] args) {
        JogoDaVelha veia = new JogoDaVelha();
        veia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
