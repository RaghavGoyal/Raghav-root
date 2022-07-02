package test.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("SpringCfg.xml");
		HelloWorld bean = (HelloWorld)context.getBean("HWBean");
		int result=bean.sum(20,30);
		System.out.println(result);
		context.registerShutdownHook();
		
		// Alternate method....but shutdownHook will not be called by this class.
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringCfg.xml"));
		NewSpring bean2 = (NewSpring)beanFactory.getBean("New");
		bean2.print();
		
		
		
		

	}

}
