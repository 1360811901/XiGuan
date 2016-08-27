package com.fei.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fei.util.MySessionContext;


/**
 * Application Lifecycle Listener implementation class MyVification
 * servletContextListener 当Servlet 容器启动或终止Web 应用时，会触发ServletContextEvent 事件
 */
public class MyVification implements ServletContextListener {
	
	//public static Map<String,Integer> userMap = new HashMap<String,Integer>(); 
	private   MySessionContext myc=MySessionContext.getInstance();

    /**
     * Default constructor. 
     */
    public MyVification() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();    
        // 这里DbConnection是一个定制好的类用以创建一个数据库连接  
        context.setAttribute("code_map",myc);
    }
	
}
