package cn.xiaoxian.util;
public class HTMLReplaceMark {
	public static String replaceMark(String data){
		data = data.replaceAll(";", "；");
		data=data.replaceAll("&", "&amp;");
		data=data.replaceAll(">", "&gt;");
		data=data.replaceAll("<","&lt;");
		data = data.replaceAll("\"", "&quot;");
	    data=data.replaceAll("'", "&apos;");
	    return data;
	}
}
