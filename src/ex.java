import java.util.*;
public class ex {
	public static void main(String[] args) {

		int count=1;
		int num=5555;
		String s=num+"";
		System.out.println("length:"+s.length());
		for(int i=1;i<s.length();i++) {
			for(int j=1;j<i;j++) {
				int a=num%10;
				num=num/10;
				if(a!=num%10*j)
					count++;
			}
		}
		System.out.println(count);
		
	}

}
