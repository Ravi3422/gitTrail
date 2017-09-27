package website;

import java.lang.reflect.Array;

import bsh.classpath.BshClassPath.AmbiguousName;

public class FirstRepetedLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//FirstrepNum();
		
		//printDiagram();
		
		arraydiff();
		
		
	}

	private static void arraydiff() {
		// TODO Auto-generated method stub
		int[] a = {5,2,3,7,2,1,9};
		int big = a[0],small = a[0],Asmall = a[0], bIndex =1, sIndex=0;
		
		for (int i=1;i<a.length;i++)
		{
			
			if (a[i]>a[i-1])
			{
				big = a[i];
				bIndex = i;
				System.out.println(bIndex +" Big : " + big);
				//i++;
			}
			if(a[i]<small && i<=bIndex)
			{
				small=a[i];
				System.out.println(i+" small : " + small);
				Asmall = small;
			}
			else if(a[i]<Asmall && i>bIndex)
			{
				Asmall = a[i];
				System.out.println("After Small : " + Asmall);
				sIndex=i;
			}
		}
		
		System.out.println("Big : " + big + " Small : " + small);
		
	}

	private static void printDiagram() {
		// TODO Auto-generated method stub
		int num = 3;
		
		for (int i=num; i>0; i--)
		{
			int var = 1;
			while(var<i)
			{
				System.out.print(" ");
				var++;
			}
			//var=1;
			while(var<=num)
			{
				System.out.print("#");
				var++;
			}
			System.out.println();
		}
	}

	private static void FirstrepNum() {
		String str = "abcddcba";
		str = str.toLowerCase();
		boolean flag = false;
		char[] splitstr = str.toCharArray();
		//System.out.println(splitstr[1]);
		
		for (int i=0;i<str.length();i++)
		{
			for (int j=i+1; j<str.length(); j++)
			{
				if(splitstr[i]==splitstr[j])
				{
					System.out.println("First repeted char is : " + splitstr[i]);
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}
		if(!flag)
		{
			System.out.println("No repeated char found :(");
		}
		
	}

}

/*n=3
**1
*22
333*/




 
 
