package com.fei.garbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class HttpRuquest {
	
	public static void setGetRequest(String url,String params) throws MalformedURLException{
		String result = "";
		BufferedReader in = null;
		try {
			URL readurl = new URL(url);
			URLConnection conn = readurl.openConnection();
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
			conn.connect();
			Map<String,List<String>> map = conn.getHeaderFields();
			for(String key:map.keySet()){
				System.out.println(key + "--->" + map.get(key));
			}
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine())!= null){
				result += line;
			}
			System.out.println(result);
		} catch (IOException e) {
			System.out.println("����GET ��������쳣��" + e);
			e.printStackTrace();
		}finally{
			try{
				if(in != null)
					in.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	public static void setPostRequest(String url,String params){
		PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            //conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Charset", "utf-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(params);
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("发送post请求失败"+e);
            e.printStackTrace();
        }
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
   
	}
}
