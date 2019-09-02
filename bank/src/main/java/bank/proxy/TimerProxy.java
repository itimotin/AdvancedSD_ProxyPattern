package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class TimerProxy implements InvocationHandler {
    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
                .getClass().getInterfaces(), new TimerProxy(obj));
    }

    public TimerProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable {
        // start the timer
        long start = System.currentTimeMillis();
        //method invocation
        Object result = m.invoke(obj, args);
        //calculate total time
        long elapsedTimeMillis = System.currentTimeMillis() - start;

        System.out.println("Timer: It took " + elapsedTimeMillis + " milliseconds to invoke the method: "+ m.getName());
        return result;
    }
}
