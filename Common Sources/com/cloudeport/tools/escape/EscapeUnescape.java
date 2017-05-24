package com.cloudeport.tools.escape;

import java.net.URLDecoder;

public class EscapeUnescape {

	public static String unescape(String source) {

        try{
            
            String target = URLDecoder.decode(source,"utf-8");
            return target;
            
          }
          catch(Exception e){
          
            return new String("error!");
          
          }
	}
}

