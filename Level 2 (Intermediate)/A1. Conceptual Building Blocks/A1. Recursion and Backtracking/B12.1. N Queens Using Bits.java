import java.io.*;
import java.util.*;

public class Main {
    
  public static void solution(boolean board[][], int i, int cols, int d1, int d2, String asf){
      if( i == chess.length){
          System.out.println(asf);
          return;
      }
      
      int n= chess.length;
      
      for( int j=0; j< chess.length; j++){
          //yahape isqueen safe hai kya check krte the, but mai yahape check karunga ki columns mai jth bit on hai ya nhi
          if((cols & (1 << j)) == 0 && (d1 & (1 << (i - j + n - 1))) == 0 && (d2 & (1 << (i + j))) == 0){ // iski value 0 aayi means yeh place kisi queen ne aquire krke nhi rakhi hai. agar yeh teeno bit off hui columns ki jth bit, d1 ki i-j+n-1th bit, d2 ki i+jth bit, agar yeh teeno bit off hui matlab yeh position humare queen keliye safe hai, safe hai to yahape queen place krdo
          chess[i][j] = true;
          //place krne ke bad yeh bhi btana hoga ki yeh position mai acquire kr chuka hu, to bits on karni padegi
          cols |= (1 << j); // columns ki jth bit on kardi
          d1 |= ( 1 << (i-j+n-1)); // d1 ki yeh wali bit on karenge
          d2 |= ( 1 << (i+j)); // d1 ki i+jth bit on karenge
          
          // yeh queen place krdi to next queen keliye recursive call
          solution(chess, i+1, cols, d1, d2, asf + i + "-" + j + ", ");
          
          //wapas ate hue false karna hoga
          //jo mask banaya hai uske sare bits ko toggle krdo, aur toggle krke AND lelo
          chess[i][j] = false;
          cols &= ~(1 << j); 
          d1 &= ~( 1 << (i-j+n-1)); 
          d2 &= ~( 1 << (i+j));
              
          }
      }
      
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    
    boolean cols= 0; 
    boolean ndiag= 0; 
    boolean rdiag= 0; 
    
    solution( board, 0, cols, ndiag, rdiag, ""); 
  }

}
