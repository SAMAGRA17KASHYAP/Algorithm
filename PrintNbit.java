import java.util.*;
class PrintNbit{
	static StringBuffer sb=new StringBuffer();
	public static void allBits(char [] ch,int n){
		if(n==0){
			for (int i=ch.length-1;i>=0;i-- ) {
				System.out.print(ch[i]);
			}
			System.out.println();
			return;
		}
		ch[n-1]='0';
		allBits(ch,n-1);
		ch[n-1]='1';
		allBits(ch,n-1);
			
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		allBits(new char[n],n);
	}
}