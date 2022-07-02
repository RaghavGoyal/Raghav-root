import java.io.*;

class Demo implements Serializable
{
	public int a; 
    public String b; 
    
    Demo(int a,String b)
    {
    	this.a = a; 
        this.b = b; 
    }
    
}
public class S {
public static void main(String args[]) throws FileNotFoundException{
	Demo obj = new Demo(1,"xyz");
	String filename = "try.txt";
	try{
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(obj);

        out.close();
        file.close();
        System.out.println("Successful");

	}
	catch(Exception e) {
		
	}
}
}
