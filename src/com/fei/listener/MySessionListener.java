package com.fei.listener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
public class MySessionListener implements HttpSessionListener {
	
	// public static Map userMap = new HashMap();                                //������һ������������session��  
    // private   MySessionContext myc=MySessionContext.getInstance();  //MySessionContext��ʵ��session�Ķ�ȡ��ɾ������  ����ģʽ  

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  { 
    	
    	//myc.AddSession(httpSessionEvent.getSession());
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  { 
    	//HttpSession session = httpSessionEvent.getSession();
    	//myc.DelSession(session);
         // TODO Auto-generated method stub
    }
	
}
