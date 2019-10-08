package cc.mrbird.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogAspect {
	
	 @Pointcut("@annotation(cc.mrbird.common.annotation.MethodLog)")
	    public void pointcut() {
	        // do nothing
	    }
	 
	  @Around("pointcut()")
	    public Object around(ProceedingJoinPoint point) throws Throwable {
		  Object result;
		  long beginTime = System.currentTimeMillis();
		  System.out.println("=============开始时间==========="+beginTime);
		  result = point.proceed();
		  long endTime = System.currentTimeMillis();
		  //获取方法名
		  MethodSignature signature = (MethodSignature) point.getSignature();
		  System.out.println("=============方法名11111==========="+signature.getMethod());
		  System.out.println("=============方法结束111==========="+endTime);
		  return result;
	  }
}
