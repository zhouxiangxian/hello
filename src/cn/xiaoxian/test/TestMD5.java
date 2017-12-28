package cn.xiaoxian.test;

import cn.xiaoxian.util.MD5Code;

public class TestMD5 {
	public static void main(String[]args){
		System.out.println("admin:"+new MD5Code().getMD5ofStr("admin"));
		System.out.println("xiaoxian:"+new MD5Code().getMD5ofStr("xiaoxian"));
	}
}
