package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LoggerProxy implements InvocationHandler {
   private Object dao;

   public static Object newInstance(Object obj) {
       return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
               .getClass().getInterfaces(), new LoggerProxy(obj));
   }

   public LoggerProxy(Object dao) {
       this.dao = dao;
   }

   public Object invoke(Object proxy, Method m, Object[] args)
           throws Throwable {
       System.out.println("LoggerProxy: Invoking method: " + m.getName());
       return m.invoke(dao, args);
   }
}
