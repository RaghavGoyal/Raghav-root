package test.spring;

public class HelloWorld {
	
	public void printHello()
	{
		System.out.println("Hello from spring");
		
	}
	
	public int sum(int a,int b)
	{
		int c=a+b;
		return c;
		
	}
	
	public void initIt() throws Exception {
		  System.out.println("Init method invoked at the start of application. ");
		}
	
	public void destroy() throws Exception {
		  System.out.println("Spring Container is destroyed!");
		}

}
