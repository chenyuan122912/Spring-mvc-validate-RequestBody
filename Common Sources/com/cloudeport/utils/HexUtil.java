package com.cloudeport.utils;

import java.io.IOException;

/**
 * This class provides convenient functions to convert hex string to byte array and vice versa.
 * @author pengjiong
 *
 */
public class HexUtil {

    private HexUtil() {
    }

    /**
     * Converts a byte array to hex string.
     * 
     * @param b -
     *            the input byte array
     * @return hex string representation of b.
     */
    
    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(HexUtil.HEX_CHARS.charAt(b[i] >>> 4 & 0x0F));
            sb.append(HexUtil.HEX_CHARS.charAt(b[i] & 0x0F));
        }
        return sb.toString();
    }

    /**
     * Converts a hex string into a byte array.
     * 
     * @param s -
     *            string to be converted
     * @return byte array converted from s
     */
    public static byte[] toByteArray(String s) {
        byte[] buf = new byte[s.length() / 2];
        int j = 0;
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (byte) ((Character.digit(s.charAt(j++), 16) << 4) | Character
                    .digit(s.charAt(j++), 16));
        }
        return buf;
    }

    private static final String HEX_CHARS = "0123456789abcdef";
    
    public static void main(String [] args){
    	String temp  = new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Service name=\"CreateImageDocumentInfoService\">	<!--userName：用户名称-->	<!--userId：用户ID-->	<!--loginToken：登录验证Token -->	<!--branchLevel1：一级支行代码 -->	<!--branchLevel2：二级支行代码 -->	<User userName=\"\" userId=\"\" loginToken=\"\" branchLevel1=\"\" branchLevel2=\"\"/>	<In>		<Doc>			<!-- parentDirName：父文档目录名称-->			<ParentDirName value=\"\"/>			<!-- 父文档目录ID -->			<ParentDirId value=\"\"/>			<!--dirName：文档目录名称 -->			<DirName value=\"\"/>			<!-- 父文档目录ID-->			<DirId value=\"\"/>			<!--docName：影像文档名称-->			<DocName value=\"\"/>			<!-- docTypeId：影像文档类别ID -->			<DocTypeId value=\"\"/>			<!-- docSourceType : 来源类别，1：扫描，2：本地导入，3：引用-->			<DocSourceType value=\"\"/>			<File id=\"index\">				<!-- fileName：影像文件名称 -->				<FileName value=\"\"/>				<!-- filePath：影像文件存储路径 -->				<FilePath value=\"\"/>				<!-- fileIndex：影像文件索引号 -->				<FileIndex value=\"\"/>				<ImageDpi value=\"\"/>				<Angle value=\"\"/>			</File>			<!-- 如果是多个影像文件则添加多个File元素 -->		</Doc>		<!-- 如果是多个影像文档则添加多个Doc元素 -->	</In>	<Route>		<Domain>			<Parameter name=\"\" value=\"\" />			<!-- 可添加多个Parameter元素 -->		</Domain>		<Branch>			<Parameter name=\"\" value=\"\" />			<!-- 可添加多个Parameter元素 -->		</Branch>		<Chief>			<Parameter name=\"\" value=\"\" />			<!-- 可添加多个Parameter元素 -->		</Chief>	</Route>	<Out>		<Parameters>			<!-- returnStats: 返回状态,0表示失败，1表示成功-->			<ReturnStatus  value=\"\"/>		</Parameters>	</Out></Service>");
    	System.out.println("1 String:"+temp.length());
    	System.out.println("1 String:"+temp);
    	byte[] b = temp.getBytes();
    	temp = HexUtil.toHexString(b);
    	System.out.println("2 toHexString:"+temp.length());
    	System.out.println("2 toHexString:"+temp);
    	try {
			temp = ZipUtil.compress(temp);
			System.out.println("3 compress:"+temp.length());
			System.out.println("3 compress:"+temp);
			temp = ZipUtil.uncompress(temp);
			System.out.println("4 uncompress:"+temp.length());
			System.out.println("4 uncompress:"+temp);
	    	temp = new String(HexUtil.toByteArray(temp));
	    	System.out.println("5 String:"+temp.length());
	    	System.out.println("5 String:"+temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

}
