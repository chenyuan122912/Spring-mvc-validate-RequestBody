package com.cloudeport.tools.guid;

import org.doomdark.uuid.UUIDGenerator;

public final class GUID
{

    private GUID()
    {
    	 
    }
    public static String generate()
    {
        return UUIDGenerator.getInstance().generateTimeBasedUUID().toString();
    }
    public static void main(String args[]){
    	System.out.println("s: "+RandomGuid()+" length: "+RandomGuid().length());
    	System.out.println(generate().split("-"));
    }
    
    public static String RandomGuid(){
    	String guid=UUIDGenerator.getInstance().generateTimeBasedUUID().toString();
    	return guid.replaceAll("-", "");
    }
}

