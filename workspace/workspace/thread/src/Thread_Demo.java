class T1 extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++){
		try{
			System.out.println("hii");
			Thread.sleep(100);
		} 
		catch(Exception e){}
		}
	}
}

class T2 extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++){
		try{
			System.out.println("hello");
			Thread.sleep(100);
		} 
		catch(Exception e){}
		}
	}
}
public class Thread_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T1 obj1=new T1();
		T2 obj2=new T2();
		
		obj1.start();
		obj2.start();

	}

}
