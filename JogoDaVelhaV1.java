package jogodavelha;

import javax.swing.JOptionPane;

public class JogoDaVelhaV1 {
    public static void main(String[] args) {
        int[][] velha = {{1,2,3},{4,5,6},{7,8,9}};
        String[][] velha2 = new String[3][3];
        int x,y, e=0,i=0,c=0,v=0;
        
        JOptionPane.showMessageDialog(null, "JOGO DA VELHA!");
        
        for(x=0; x<3; x++){
            System.out.print(" | ");
            for(y=0; y<3; y++){
                System.out.print(velha[x][y]+" | ");
            }
            System.out.print("\n  --- --- ---\n");
        }
        System.out.print("\n\n\n");
        
        for(c=0;c<10;c++){
            if(c == 9){
                JOptionPane.showMessageDialog(null, "VELHA!!");
                break;
            }
            else if(v == 1 || v == 2){
                break;
            }
            
            e = Integer.parseInt(JOptionPane.showInputDialog("Pressione 1 para 'X' ou 0 para 'O'"));
            switch (e){
            case 1:
                i = Integer.parseInt(JOptionPane.showInputDialog("Escolha entre 1 à 9 o quadrado 'X'"));
                for(x=0; x<3; x++){
                    for(y=0; y<3; y++){
                        if(velha[x][y] == i){
                            velha2[x][y] = "X";
                        }
                    }
                }
                break;
            case 0:
                i = Integer.parseInt(JOptionPane.showInputDialog("Escolha entre 1 à 9 o quadrado 'O'"));
                for(x=0; x<3; x++){
                    for(y=0; y<3; y++){
                        if(velha[x][y] == i){
                            velha2[x][y] = "O";
                        }
                    }
                }
                break;
            }
            for(x=0; x<3; x++){
                System.out.print(" | ");
                for(y=0; y<3; y++){
                    if(velha2[x][y] == null){
                        System.out.print(velha[x][y]+" | ");
                    }
                    else{
                        System.out.print(velha2[x][y]+" | ");
                    }
                }
                System.out.print("\n  --- --- ---\n");
            }
            System.out.print("\n\n\n");
            
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
}
