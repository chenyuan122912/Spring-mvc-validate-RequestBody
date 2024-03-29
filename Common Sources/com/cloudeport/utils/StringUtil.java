package com.cloudeport.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * String Utilities.
 */
public class StringUtil {
	private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private StringUtil() {
		// util class, prevent from new instance
	}

	public static boolean isNull(Object object) {
		if (object instanceof String) {
			return StringUtil.isEmpty(object.toString());
		}
		return object == null;
	}

	/**
	 * Checks if string is null or empty.
	 * 
	 * @param value
	 *            The string to be checked
	 * @return True if string is null or empty, otherwise false.
	 */
	public static boolean isEmpty(final String value) {
		return value == null || value.trim().length() == 0
				|| "null".endsWith(value);
	}

	/**
	 * Converts <code>null</code> to empty string, otherwise returns it
	 * directly.
	 * 
	 * @param string
	 *            The nullable string
	 * @return empty string if passed in string is null, or original string
	 *         without any change
	 */
	public static String null2String(Object obj) {
		return obj == null? "" : obj.toString();
	}
	

	public static String null2String(String str) {
		return str == null || "null".equalsIgnoreCase(str)? "" : str;
	}

	public static int null2Integer(Object obj) {
		return null2Integer(obj.toString());
	}
	
	public static int null2Integer(String str){
		return str == null || "null".equalsIgnoreCase(str)? 0 : Integer.parseInt(str.trim());
	}
	
	public static long null2Long(Object obj){
		return null2Long(obj.toString());
	}
	
	public static long null2Long(String str){
		return str == null || "null".equalsIgnoreCase(str)? 0 : Long.parseLong(str);
	}

	public static short null2Short(Object obj){
		return null2Short(obj.toString());
	}
	public static short null2Short(String str){
		return str == null || "null".equalsIgnoreCase(str)? 0 : Short.parseShort(str);
	}
	
	
	
	
	
	
	
	
	/**
	 * Converts string from GB2312 encoding ISO8859-1 (Latin-1) encoding.
	 * 
	 * @param gbString
	 *            The string of GB1212 encoding
	 * @return New string of ISO8859-1 encoding
	 */
	public static String iso2Gb(String gbString) {
		if (gbString == null)
			return null;
		String outString = "";
		try {
			byte[] temp = null;
			temp = gbString.getBytes("ISO8859-1");
			outString = new String(temp, "GB2312");
		} catch (java.io.UnsupportedEncodingException e) {
			// ignore it as no way to convert between these two encodings
		}
		return outString;
	}

	/**
	 * Converts string from ISO8859-1 encoding to UTF-8 encoding.
	 * 
	 * @param isoString
	 *            String of ISO8859-1 encoding
	 * @return New converted string of UTF-8 encoding
	 */
	public static String iso2Utf(String isoString) {
		if (isoString == null)
			return null;
		String outString = "";
		try {
			byte[] temp = null;
			temp = isoString.getBytes("ISO8859-1");
			outString = new String(temp, "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {

		}
		return outString;
	}

	/**
	 * Converts string from platform default encoding to GB2312.
	 * 
	 * @param inString
	 *            String in platform default encoding
	 * @return New string in GB2312 encoding
	 */
	public static String str2Gb(String inString) {
		if (inString == null)
			return null;
		String outString = "";
		try {
			byte[] temp = null;
			temp = inString.getBytes();
			outString = new String(temp, "GB2312");
		} catch (java.io.UnsupportedEncodingException e) {

		}
		return outString;
	}


	public static String fillZero(String value, int len) {
		if (StringUtil.isNull(value) || len <= 0) {
			throw new IllegalArgumentException("参数不正确");
		}
		StringBuffer zero = new StringBuffer();
		int paramLen = value.trim().length();
		if (paramLen < len) {
			for (int i = 0; i < len - paramLen; i++) {
				zero.append("0");
			}
		}
		zero.append(value);
		return zero.toString();
	}


	/**
	 * to 10Decrypt
	 */
	public static String to10(String opStr) {
		String zm = "#123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int lenOfOp = opStr.length();
		long result = 0;
		String indexOfOp;
		int js;
		for (int i = 0; i < lenOfOp; i++) {
			indexOfOp = opStr.substring(i, i + 1);
			js = zm.indexOf(indexOfOp);
			result = result * 36 + js;
		}
		// 补充到12位
		String jg = String.valueOf(result);
		int bc = 12 - jg.length();
		String jgq = "";
		for (int j = 0; j < bc; j++) {
			jgq += "0";
		}
		return jgq + jg;
	}

	/**
	 * to 36Encrypt
	 */
	public static String to36(String originalStr) {

		long oVal = Long.parseLong(originalStr);
		long shang;
		int yushu;
		String result = "";
		String zm = "#123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 1; i < 9; i++) {
			shang = oVal / 36;
			yushu = (int) (oVal % 36);
			result = zm.substring(yushu, yushu + 1) + result;
			oVal = shang;
		}

		return result;

	}

	// Useful split and replace methods

	/**
	 * Splits the provided text into a list, using whitespace as the separator.
	 * The separator is not included in the returned String array.
	 * 
	 * @param str
	 *            the string to parse
	 * @return an array of parsed Strings
	 */
	public static String[] split(String str) {
		return split(str, null, -1);
	}

	/**
	 * @param text
	 *            String
	 * @param separator
	 *            String
	 * @return String[]
	 */
	public static String[] split(String text, String separator) {
		return split(text, separator, -1);
	}

	/**
	 * Splits the provided text into a list, based on a given separator. The
	 * separator is not included in the returned String array. The maximum
	 * number of splits to perfom can be controlled. A null separator will cause
	 * parsing to be on whitespace.
	 * <p>
	 * <p>
	 * This is useful for quickly splitting a string directly into an array of
	 * tokens, instead of an enumeration of tokens (as
	 * <code>StringTokenizer</code> does).
	 * 
	 * @param str
	 *            The string to parse.
	 * @param separator
	 *            Characters used as the delimiters. If <code>null</code>,
	 *            splits on whitespace.
	 * @param max
	 *            The maximum number of elements to include in the list. A zero
	 *            or negative value implies no limit.
	 * @return an array of parsed Strings
	 */
	public static String[] split(String str, String separator, int max) {
		StringTokenizer tok = null;
		if (separator == null) {
			// Null separator means we're using StringTokenizer's default
			// delimiter, which comprises all whitespace characters.
			tok = new StringTokenizer(str);
		} else {
			tok = new StringTokenizer(str, separator);
		}

		int listSize = tok.countTokens();
		if (max > 0 && listSize > max) {
			listSize = max;
		}

		String[] list = new String[listSize];
		int i = 0;
		int lastTokenBegin = 0;
		int lastTokenEnd = 0;
		while (tok.hasMoreTokens()) {
			if (max > 0 && i == listSize - 1) {
				// In the situation where we hit the max yet have
				// tokens left over in our input, the last list
				// element gets all remaining text.
				String endToken = tok.nextToken();
				lastTokenBegin = str.indexOf(endToken, lastTokenEnd);
				list[i] = str.substring(lastTokenBegin);
				break;
			}
			list[i] = tok.nextToken();
			lastTokenBegin = str.indexOf(list[i], lastTokenEnd);
			lastTokenEnd = lastTokenBegin + list[i].length();
			i++;
		}
		return list;
	}

	/**
	 * Replace all occurances of a string within another string.
	 * 
	 * @param text
	 *            text to search and replace in
	 * @param repl
	 *            String to search for
	 * @param with
	 *            String to replace with
	 * @return the text with any replacements processed
	 * @see #replace(String text, String repl, String with, int max)
	 */
	public static String replace(String text, String repl, String with) {
		return replace(text, repl, with, -1);
	}

	/**
	 * Replace a string with another string inside a larger string, for the
	 * first <code>max</code> values of the search string. A <code>null</code>
	 * reference is passed to this method is a no-op.
	 * 
	 * @param text
	 *            text to search and replace in
	 * @param repl
	 *            String to search for
	 * @param with
	 *            String to replace with
	 * @param max
	 *            maximum number of values to replace, or <code>-1</code> if
	 *            no maximum
	 * @return the text with any replacements processed
	 * @throws NullPointerException
	 *             if repl is null
	 */
	private static String replace(String text, String repl, String with, int max) {
		if (text == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer(text.length());
		int start = 0;
		int end = text.indexOf(repl, start);
		while (end != -1) {
			buf.append(text.substring(start, end)).append(with);
			start = end + repl.length();

			if (--max == 0) {
				break;
			}
			end = text.indexOf(repl, start);
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	/**
	 * 用Map中的变量名-变量值替换源字符串中的变量名.
	 * 
	 * @param src
	 *            字符串
	 * @param value
	 *            变量名-变量值
	 * @return String <br>
	 *         <br>
	 *         Example: <br>
	 *         String src = "Hello ${username}, this is ${target} speaking.";
	 *         <br>
	 *         Map map = new HashMap(); <br>
	 *         map.put("username", "petter"); <br>
	 *         map.put("target", "tom"); <br>
	 *         src = StringUtil.replaceVariable(str, map); <br>
	 *         #The src equals: <br>
	 *         "Hello petter, this is tom speaking."
	 */
	@SuppressWarnings("unchecked")
	public static String replaceVariable(final String src, final Map value) {
		int len = src.length();
		StringBuffer buf = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			char c = src.charAt(i);
			if (c == '$') {
				i++;
				StringBuffer key = new StringBuffer();
				char temp = src.charAt(i);
				while (temp != '}') {
					if (temp != '{') {
						key.append(temp);
					}
					i++;
					temp = src.charAt(i);
				}
				String variable = (String) value.get(key.toString());
				if (null == variable) {
					buf.append("");
				} else {
					buf.append(variable);
				}
			} else {
				buf.append(c);
			}
		}
		return buf.toString();
	}

	/**
	 * 用Map中的变量名-变量值替换源字符串中的变量名,这个方法返回字符串是从char[] 构造的UTF字符串,不需要指定任何字符集都不可能乱码
	 * 以前那个方法是把UTF字符串又转换成GBK的byte,所以要重新指定字符集为GBK是为了和其它的GBK字符同时输出,所以要把UTF字符串转换成GBK的字符串以便同时显示.
	 */
	public static String utfToGBK(byte[] srcByte) throws Exception {
		StringBuffer str = new StringBuffer();
		int len = srcByte.length;
		int char1, char2, char3;
		int count = 0;
		while (count < len) {
			char1 = (int) srcByte[count] & 0xff;
			switch (char1 >> 4) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				count++;
				str.append((char) char1);
				break;
			case 12:
			case 13:
				count += 2;
				if (count > len) {
					throw new Exception();
				}
				char2 = (int) srcByte[count - 1];
				if ((char2 & 0xC0) != 0x80) {
					throw new Exception();
				}
				str.append((char) (((char1 & 0x1F) << 6) | (char2 & 0x3F)));
				break;
			case 14:

				/* 1110 xxxx 10xx xxxx 10xx xxxx */
				count += 3;
				if (count > len) {
					throw new Exception();
				}
				char2 = (int) srcByte[count - 2];
				char3 = (int) srcByte[count - 1];
				if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80)) {
					throw new Exception();
				}
				str.append((char) (((char1 & 0x0F) << 12)
						| ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0)));
				break;
			default:
				throw new Exception();
			}
		}
		return str.toString();
	}

	/**
	 * 可以直接以UTF-8显示字付串,如果要存储可以直接把转换后的UTF的byte写到文件或数据库.
	 * 
	 * @param s
	 *            :原始数据
	 * @param charset
	 *            :解码字符集格式
	 * @return
	 */
	public static byte[] getUTFBytes(String s, String charset) {
		try {
			int pos = 0;
			if (charset != null) {
				s = new String(s.getBytes(), charset);
			}
			char[] cc = s.toCharArray();
			byte[] buf = new byte[cc.length * 3];

			for (int i = 0; i < cc.length; i++) {
				char c = cc[i];
				if (c <= 0x007F && c != 0) {
					buf[pos++] = (byte) c;
				} else if (c > 0x07FF) {
					buf[pos + 2] = (byte) (0x80 | ((c >> 0) & 0x3F));
					buf[pos + 1] = (byte) (0x80 | ((c >> 6) & 0x3F));
					buf[pos + 0] = (byte) (0xE0 | ((c >> 12) & 0x0F));
					pos += 3;
				} else {
					buf[pos + 1] = (byte) (0x80 | ((c >> 0) & 0x3F));
					buf[pos + 0] = (byte) (0xC0 | ((c >> 6) & 0x1F));
					pos += 2;
				}
			}

			// buf是按照最大长度3算的，所以要截取剩余的空间
			byte[] tmp = new byte[pos];
			for (int i = 0; i < pos; i++)
				tmp[i] = buf[i];
			return tmp;

		} catch (Exception ex) {
			return null;
		}
	}

	public static int utfLength(String value) {
		// return str.replaceFirst("[^\\x00-\\xff]/g","aaa").length();
		int utflen = 0;
		char[] val = value.toCharArray();

		for (int i = 0; i < value.length(); i++) {
			int c = val[i];
			if ((c >= 0x0001) && (c <= 0x007F)) {
				utflen++;
			} else if (c > 0x07FF) {
				utflen += 3;
			} else {
				utflen += 2;
			}
		}
		return utflen;
	}

	public static String couponIdGenerator(String src) {
		String srcTemp = null;
		String dst = null;
		int iSrc = 0;

		if (src == null) {
			srcTemp = "        ";
		} else if (src.equals("")) {
			srcTemp = "        ";
		} else {
			srcTemp = src;
		}

		for (int i = 0; i < srcTemp.length(); i++) {
			iSrc = iSrc + (250 - 1 - i) * (int) (srcTemp.charAt(i));
		}

		dst = iSrc + "";
		return dst;
	}

	

	public static String first2Upper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * Transform the specified byte into a Hex String form.
	 */
	public static final String bytesToHexStr(byte[] bcd) {
		StringBuffer s = new StringBuffer(bcd.length * 2);

		for (int i = 0; i < bcd.length; i++) {
			s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
			s.append(bcdLookup[bcd[i] & 0x0f]);
		}

		return s.toString();
	}

	/**
	 * Transform the specified Hex String into a byte array.
	 */
	public static final byte[] hexStrToBytes(String s) {
		byte[] bytes;

		bytes = new byte[s.length() / 2];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, (2 * i) + 2),
					16);
		}

		return bytes;
	}
	
	
	/**
	 * 根据"yyyy-MM-dd HH:mm:ss"格式，转换Date日期为字符串
	 * @param t
	 * @return
	 */
	public static String toDateString(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}
	
	/**
	 * 根据指定格式转换Date日期为字符串
	 * @param t
	 * @return
	 */
	public static String toDateString(Date date,String formatString){
		SimpleDateFormat sf = new SimpleDateFormat(formatString);
		return sf.format(date);
	}
	
	
	
	 public static Date parseDateString(String pattern, String strDateTime) {
	        Date date = null;
	        if (strDateTime == null || pattern == null) return null;
	        try {
	            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	            formatter.setLenient(false);
	            date = formatter.parse(strDateTime);
	        }
	        catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
	    }
	 /**
	  * 重新格式化时间字符串
	  * @param pattern   原时间格式化字符串
	  * @param dateString 要格式化的时间字符串
	  * @return 返回yyyy-MM-dd HH:mm时间字符串
	  */
	 public static String reFormatDateString(String pattern,String dateString){
		 Date date = StringUtil.parseDateString(pattern,
				 dateString);
		return StringUtil.toDateString(date,"yyyy-MM-dd HH:mm");
	 }
	 /**
	  * 重新格式化时间字符串
	  * @param pattern  原时间格式化字符串
	  * @param reformatpattern 新时间格式化字符串
	  * @param dateString 要格式化的时间字符串
	  * @return 返回新格式的时间字符串
	  */
	 public static String reFormatDateString(String pattern,String reformatpattern,String dateString){
		 Date date = StringUtil.parseDateString(pattern,
				 dateString);
		return StringUtil.toDateString(date,reformatpattern);
	 }
	 /**
	  * 使用GBK对url进行编码
	  * @param paramName
	  * @return
	  */
	 public static String encodeUrl(String paramName){
		String formatUrl="";
		try {
			formatUrl = URLEncoder.encode(paramName,"GBK");
			System.out.println("formatUrl:"+formatUrl);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 return formatUrl;
		 
	 }
	 /**
	  * 使用指定的编码(如"UTF-8")给中文编码
	  * @param paramName
	  * @param charset
	  * @return
	  */
	 public static String encodeUrl(String paramName,String charset){
			String formatUrl="";
			try {
				formatUrl = URLEncoder.encode(paramName,charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			 return formatUrl;
		 }
	 /**
	  * 使用GBK给指定的中文解码
	  * @param paramName
	  * @return
	  */
	 public static String decodeUrl(String paramName){
			String formatUrl="";
			try {
				formatUrl = URLDecoder.decode(paramName,"GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			 return formatUrl;
		 }
	 /**
	  * 使用指定的编码给中文解码
	  * @param paramName
	  * @param charset
	  * @return
	  */
	 public static String decodeUrl(String paramName,String charset){
			String formatUrl="";
			try {
				formatUrl = URLDecoder.decode(paramName,charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			 return formatUrl;
	 }
	 
	 public static String formatDir(String dir){
		
		 //判断目录是否以"/"结尾,如果不是以"/"结尾则在最后加上一个"/"
		 int length = dir.length();
		 String unix = dir.substring(length-1);
		 String windows = dir.substring(length-2);
		 
		 if("/".equals(unix)||"\\".equals(windows)){
			 return dir;
		 }else{
			 dir = dir+"/";
		 }
		 return dir;
	 }
	 //截取前半部分字符
	 public static String formatSubString(Object str,String str1)
	 {
		 int tempIndex;
	     String tempStr;
	 	if(str!=null)
	 	{
	 	 String tempString = str.toString();
	 	 tempIndex = tempString.indexOf(str1);
	 	 if(tempIndex==-1)
	 	 {
	 	  tempStr = tempString;
	 	 }
	 	 else {tempStr = tempString.substring(0,tempIndex);}
	 	}
	 	else {tempStr="" ;}
	 	return tempStr;
	 }
	 public static String formatSubString(Object str,char str1)
	 {
		 int tempIndex;
	     String tempStr;
	 	if(str!=null)
	 	{
	 	 String tempString = str.toString();
	 	 tempIndex = tempString.indexOf(str1);
	 	 if(tempIndex==-1)
	 	 {
	 	  tempStr = tempString;
	 	 }
	 	 else {tempStr = tempString.substring(0,tempIndex);}
	 	}
	 	else {tempStr="" ;}
	 	return tempStr;
	 }
	 //截取某一个字符之后的字符串
	 public static String formatLastString(String str,char c){
		 int i=0;
		 for(;i<str.length();i++){
			 if(str.toCharArray()[i]==c){
				 break;
			 }
		 }
		 return str.substring(i+1);
	 }
	 
	 public static Date StringToDate(String dateStr,String formatStr){
		 DateFormat sdf=new SimpleDateFormat(formatStr);
		 Date date=null;
		 try{
			 date=sdf.parse(dateStr);
		 }catch(ParseException e){
			 e.printStackTrace();
		 }
		 return date;
	 }
	 
	 
	 /**
		 * 字符串转换为int类型
		 * @param str
		 * @return
		 */
		public synchronized static int strToInt(String str){
			int i=0;
			//如果字符串为null则返回0
			if(str==null){
				return i;
			}
			if(str.matches("^\\d+$")){
				i = Integer.parseInt(str)+1;
			}else{//传入的字符串不全是数字返回0
				i = 0; 
			}
			return i; 
		}
		
		/**
		 * 
		 * @param str 原字符串
		 * @param cChar 占位符
		 * @param cLen 长度
		 * @return 将字符串str的前面用cChar补足cLen长度的字符串
		 * 如果字符串超长，则不做处理
		 */
		public synchronized static String intToStr(String str,char cChar,int cLen){
			
			if(str==null){
				return null;
			}
			
			int tLen = str.length();
			int i,iMax;
			String tReturn="";
			if(tLen>=cLen){
				return str;
			}
			iMax = cLen-tLen;
			for(i=0;i<iMax;i++){
				tReturn += cChar;
			}
			tReturn = tReturn + str;
			return tReturn;
		}


	 
	 
	 public static void main(String args[]){
		 //Date dat=new Date();
		 String ss="DGKH001001";
		 String s1=ss.substring(0,ss.length()-3);
		 int a = StringUtil.strToInt(ss.substring(ss.length()-3, ss.length()));
		 String str=String.valueOf(a);
		// Date date=StringUtil.StringToDate("2012-02-25 15:17:22", "yyyy-MM-dd HH:mm:ss");
		 System.out.println(StringUtil.strToInt(ss));
		 System.out.println(StringUtil.intToStr(str,'0',3));
		 String str1=StringUtil.intToStr(str,'0',3);
		 System.out.println(s1+str1);
		// System.out.println(StringUtil.parseDateString("yyyy-MM-dd", "2012-02-25"));
	 }
}
