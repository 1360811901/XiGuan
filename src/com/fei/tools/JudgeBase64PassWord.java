package com.fei.tools;

import java.io.IOException;
import java.nio.ByteBuffer;
/** 
 * 判断是否是base64 加密过的字符串
 * @author Administrator
 *
 */
public class JudgeBase64PassWord {

	  public static final char[] BASE64_CODE = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
	            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
	            '5', '6', '7', '8', '9', '+', '/', '=' };

	    public static final int MAX_BUFF_SIZE = 4000000;

	    public static boolean doCheck(String black_passWord) throws IOException{
	        ByteBuffer buffer = ByteBuffer.allocate(1024);
	        String line = null;
	        String lastLine = null;
	        while ((line = black_passWord) != null)
	        {
	            lastLine = line;
	            final byte[] bytes = line.getBytes();
	            tryAllocate(buffer, bytes.length);
	            buffer.put(bytes);
	        }

	        // 检查最后两个字节
	        final byte[] lastLineBytes = lastLine.getBytes();
	        // 等号个数
	        int equalsNum = 0;
	        for (int i = lastLineBytes.length - 1; i >= lastLineBytes.length - 2; i--)
	        {
	            if (lastLineBytes[i] == '=')
	            {
	                equalsNum++;
	            }
	        }

	        final byte[] src = buffer.toString().getBytes();
	        for (int i = 0; i < src.length - equalsNum; i++)
	        {
	            final char c = (char) src[i];
	            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '+' || c == '/')
	            {
	                continue;
	            }
	            return false;
	        }

	        if ((src.length - equalsNum) % 4 != 0)
	        {
	            return false;
	        }

	        return true;
	    }

	    public static ByteBuffer tryAllocate(ByteBuffer buffer, int length)
	    {
	        if (length > buffer.remaining())
	        {
	            buffer.flip();
	            return ByteBuffer.allocate(roundup(buffer.limit() + length)).put(buffer);
	        }
	        return buffer;
	    }

	    public static int roundup(int length)
	    {
	        if (length > MAX_BUFF_SIZE)
	        {
	            throw new IllegalArgumentException("length too large!");
	        }

	        int capacity = 16;
	        while (length < capacity)
	        {
	            capacity = capacity << 1;
	        }
	        return capacity;
	    }

}
