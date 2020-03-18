import java.io.PrintWriter;
import java.util.Scanner;

public class SymbolDesign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        PrintWriter output = new PrintWriter(System.out, false);

        int i, j;
        for (i=1; i<=n+1; i++){
            for (j=1; j<=(n+1)-i; j++){
                output.print(" ");
            }
            for (j=1; j<=2*i-1; j++){
                if (j>k && j<2*i-k){
                    output.print(" ");
                }
                else {
                    output.print("*");
                }
            }
            output.println();
        }

        for (i=n; i>0; i--){
            for (j=1; j<=(n+1)-i; j++){
                output.print(" ");
            }
            for (j=1; j<=2*i-1; j++){
                if (j>k && j<2*i-k){
                    output.print(" ");
                }
                else {
                    output.print("*");
                }
            }
            output.println();
        }
        output.close();
    }
}