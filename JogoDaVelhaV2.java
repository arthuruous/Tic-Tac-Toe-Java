package jogodavelha;

import javax.swing.JOptionPane;

public class JogoDaVelhaV2 {
    public static void main(String[] args) {
        int[][] velha = {{1,2,3},{4,5,6},{7,8,9}};
        String[][] velha2 = new String[3][3];
        int x=0,y=0, q=0,v=0;
        
        JOptionPane.showMessageDialog(null, "JOGO DA VELHA!");
        imp(velha,velha2,x,y);
        
        for(int i=1;i<10;i++){
            if(v == 1 || v == 2){
                break;
            }
            else if(i%2!=0){
                q = Integer.parseInt(JOptionPane.showInputDialog("Escolha entre 1 a 9 o quadrado X"));
                jog(velha,velha2,x,y,q,i);
            }
            else{
                q = Integer.parseInt(JOptionPane.showInputDialog("Escolha entre 1 a 9 o quadrado O"));
                jog(velha,velha2,x,y,q,i);
            }
            imp(velha,velha2,x,y);
            
            for(x=0; x<3; x++){
                for(y=0; y<3; y++){
                    if(velha2[x][y] == "X"){
                        if((velha2[0][0] == "X" && velha2[0][1] == "X" && velha2[0][2] == "X") || (velha2[1][0] == "X" && velha2[1][1] == "X" && velha2[1][2] == "X") || (velha2[2][0] == "X" && velha2[2][1] == "X" && velha2[2][2] == "X")){
                            JOptionPane.showMessageDialog(null, "X GANHOU!!"); //linha
                            v = 1;
                        }
                        else if((velha2[0][0] == "X" && velha2[1][0] == "X" && velha2[2][0] == "X") || (velha2[0][1] == "X" && velha2[1][1] == "X" && velha2[2][1] == "X") || (velha2[0][2] == "X" && velha2[1][2] == "X" && velha2[2][2] == "X")){
                            JOptionPane.showMessageDialog(null, "X GANHOU!!"); //coluna
                            v = 1;
                        }
                        else if((velha2[0][0] == "X" && velha2[1][1] == "X" && velha2[2][2] == "X") || (velha2[0][2] == "X" && velha2[1][1] == "X" && velha2[2][0] == "X")){
                            JOptionPane.showMessageDialog(null, "X GANHOU!!"); //diagonal
                            v = 1;
                        }
                        break;
                    }
                    if(velha2[x][y] == "O"){
                        if((velha2[0][0] == "O" && velha2[0][1] == "O" && velha2[0][2] == "O") || (velha2[1][0] == "O" && velha2[1][1] == "O" && velha2[1][2] == "O") || (velha2[2][0] == "O" && velha2[2][1] == "O" && velha2[2][2] == "O")){
                            JOptionPane.showMessageDialog(null, "O GANHOU!!"); //linha
                            v = 2;
                        }
                        else if((velha2[0][0] == "O" && velha2[1][0] == "O" && velha2[2][0] == "O") || (velha2[0][1] == "O" && velha2[1][1] == "O" && velha2[2][1] == "O") || (velha2[0][2] == "O" && velha2[1][2] == "O" && velha2[2][2] == "O")){
                            JOptionPane.showMessageDialog(null, "O GANHOU!!"); //coluna
                            v = 2;
                        }
                        else if((velha2[0][0] == "O" && velha2[1][1] == "O" && velha2[2][2] == "O") || (velha2[0][2] == "O" && velha2[1][1] == "O" && velha2[2][0] == "O")){
                            JOptionPane.showMessageDialog(null, "O GANHOU!!"); //diagonal
                            v = 2;
                        }
                        break;
                    }
                }
            }
        }
    }
    static void imp(int[][] v, String[][] v2, int a, int b){
        for(a=0; a<3; a++){
                System.out.print(" | ");
                for(b=0; b<3; b++){
                    if(v2[a][b] == null){
                        System.out.print(v[a][b]+" | ");
                    }
                    else{
                        System.out.print(v2[a][b]+" | ");
                    }
                }
                System.out.print("\n  --- --- ---\n");
            }
            System.out.print("\n\n\n");
    }
    static void jog(int[][] v, String[][] v2, int a, int b, int w, int k){
        for(a=0; a<3; a++){
            for(b=0; b<3; b++){
                if(k%2!=0){
                    if(v[a][b] == w){
                        v2[a][b] = "X";
                    }
                }
                else{
                    if(v[a][b] == w){
                        v2[a][b] = "O";
                    }
                }
            }
        }
    }
}
