package example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MalaOndaBeforeAspect {

    @Before("execution(* comprar(..))")
    public void beforeGreeting() {
        System.out.println("Este local de porquería .. ");
    }

}