/*The purpose of this assignment is to give you practice working with arrays,
passing them to functions, sorting, searching and reading and writing text files.
In this program you will read two files and store their contents in arrays.
  You will sort both arrays, and then search an array for each element of the second array.*/
package lab_2;
import java.io.*;
import java.util.*;
public class Searching_keywords {
	static void sort_array(String a[],String b[]) // doing bubble sort the arrays elements on the basis of unicode (lexicographically)
	{
		String temp; // temporary variable
		for(int i=0;i<16000;i++)
		{
			for(int j=i+1;j<16000;j++)
			{
				if(a[i].compareTo(a[j])>0)	// compareTo function compares the 2 strings lexicographically (if 1st element is bigger it gives
											// positive value,smaller gives negative values,else it gives 0
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					
				}
			}
			
		}
		for(int i=0;i<84;i++)			 
		{
			for(int j=i+1;j<84;j++)
			{
				if(b[i].compareTo(b[j])>0) 
				{
					temp=b[i];
					b[i]=b[j];
					b[j]=temp;
					
				}
			}
		}
	}
	
	public static void main(String args[])	throws IOException{
		String a[]=null; // arrays to store the file_1 data
		String b[]=null; // arrays to store the file_2 data
		a= new String[16000];
		b=new String[84];
		File dictionary=new File("C:\\Users\\Verma\\Desktop\\Java\\Lab_2\\HW2-dictionary.txt");
		File keywords= new File("C:\\Users\\Verma\\Desktop\\Java\\Lab_2\\HW2-keywords.txt");
		File outfile1=new File("C:\\Users\\Verma\\Desktop\\Java\\Lab_2\\HW2-output-16103002.txt");
		FileWriter f = new FileWriter(outfile1);   // f as an object of write only file
		BufferedReader ob1=new BufferedReader(new FileReader(dictionary)); // ob1 as an object of read only file
		BufferedReader ob2=new BufferedReader(new FileReader(keywords)); // ob2 as an object of read only file
  	  String c,d;
  	String newLine = System.getProperty("line.separator"); // add new line in the output file when we use newLine 
  	  int i=0,j=0;  	  
  	  while((c=ob1.readLine())!=null) // store the values of file1 in array a
  	  {
  		  a[i]=c;
  		  i++;
  		
  	  }
  	  while((d=ob2.readLine())!=null) // store the values of file2 in array b
  	  {
  		  b[j]=d;
  		  j++;
  		
  	  }
  	  int flag,count=0;
	ob1.close();
	ob2.close();
		sort_array(a,b); // function call to sort the array
		for(i=0;i<84;i++)
		{
			flag=1;							// flag used as a switch to determine if the value is present 
											// if flag=1 (value isn't present) else present
			for(j=0;j<16000;j++) 
			{
				if(b[i].compareTo(a[j])==0)
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{count++; // to count number of elements not found
				f.write("keyword not found :" + b[i]);
				f.write(newLine);
				
			}
		}
		f.write(newLine);
		f.write("Number of keywords not found= " + count);
		f.close();
	}
}
