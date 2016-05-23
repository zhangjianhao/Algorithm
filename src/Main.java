import java.math.BigInteger;
import java.util.Scanner;



public class Main {
    private int n;

    public static void main(String[] args) {
        new Main().input();
    }
    public void input(){

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i=0; i<n; i++){
            int x = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("Case #"+(i+1)+":");
            solve(x,m,k,c);
        }
    }
    public void solve(int x,int m,int k,int c){
        String num = createString(x,m);
        BigInteger big = new BigInteger(num);
        BigInteger kbig = new BigInteger(k+"");
        BigInteger result = big.mod(kbig);
        BigInteger cBig = new BigInteger(c+"");
        if (result.equals(cBig))
            System.out.println("Yes");
        else System.out.println("No");
    }
    public String createString(int x,int m){
        StringBuilder build = new StringBuilder();
        for (int i=0; i<m; i++){
            build.append(x+"");
        }
        return build.toString();
    }
}
