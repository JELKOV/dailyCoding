package class02;
class Tiling {
    public int tiling(int n) {
    if(n%2==1){
      return 0;
    }
    int dp [] = new int [n+1];
    dp[0]=1;

    int sum = 0;
    for(int i=2; i<=n; i+=2){
         dp[i] = (dp[i-2] * 3 + sum*2) % 100000;
       sum += dp[i-2];

    }

        return dp[n];
    }

}
public class private01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Tiling t = new Tiling();
        System.out.println(t.tiling(4));

	}

}
