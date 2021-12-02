package com.learning.SpringAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;

// This class represents the aspect class.
// An aspect class is annotated using @Aspect annotation.

@Aspect
public class TrackOperation {
	
	// This point cut will apply to all the methods of Operation class, irrespective of return type.
	@Pointcut("execution(* Operation.*(..))")
//	This pointCut will execute for all the methods starting with `m`
//	@Pointcut("execution(* Operation.m*(..))")
	public void k() {}  // point cut name
	
	
/**	There are different kinds of advise available in Spring AOP. They are:
 * 	1. Before advise: called before calling the actual business logic.
 * 	2. After advise: called after calling the actual business logic.
 * 	3. AfterReturning advise: called when the method returns normally; returns some value or void.
 * 	4. Around advise: called applied before and after the business call.
 *  5. AfterThrowing advise: called when a method throws the exception.
 */
	@Before("k()")//applying point cut on before advice  
    public void myBeforeadvice(JoinPoint jp)//it is advice (before advice)  
    {  
        System.out.println("additional concern before calling the business logic");  
        //System.out.println("Method Signature: "  + jp.getSignature());  
    }  

	@After("k()")//applying point cut on after advice  
    public void myAfteradvice(JoinPoint jp)//it is advice (after advice)  
    {  
        System.out.println("additional concern after calling the business logic");  
        //System.out.println("Method Signature: "  + jp.getSignature());  
    } 
	
	@AfterReturning(  
	        pointcut = "execution(* Operation.*(..))",  
	        returning= "result"
	        )          
	public void myadvice(JoinPoint jp,Object result)//it is advice (after returning advice)  
	{  
      System.out.println("additional concern after returning");  
	  System.out.println("Method Signature: "  + jp.getSignature());  
	  System.out.println("Result in advice: "+result);  
	  System.out.println("end of after returning advice...");  
	}
	
	
	@Pointcut("execution(* Operation.k(..))")
	public void k2() {}
	
	@Around("k2()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around advise before  actual invocation of k()");
		Object obj = pjp.proceed();
		System.out.println("Around advise after actual call  of k()");
		return obj;
	}
	
	@AfterThrowing(
			pointcut = "execution(* Operation.validateAge(..))",
			throwing = "error"
		)
	public void myAfterThrowingAdvise(JoinPoint jp, Throwable error) {
		System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
	}
	
	

}
