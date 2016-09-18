import java.util.*;
class Recursion{
	public static void towerOfHanoi(int n,String start,String aux,String end){
		if(n>0){
			towerOfHanoi(n-1,start,end,aux);
			System.out.println("Moved from "+start+" "+end);
			towerOfHanoi(n-1,aux,start,end);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		towerOfHanoi(n,"A","B","C");
	}
}