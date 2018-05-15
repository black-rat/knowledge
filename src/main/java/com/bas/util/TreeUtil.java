package com.bas.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bas.bean.Menu;

public class TreeUtil {

	/**
	 * 使用占位符拼接字符串  
	 * 建立等级——等级对应的实体个数
	 * @param menu
	 * @return
	 */
	public static String getTreeJson(List<Menu> menu){
		
		//默认最顶级
		StringBuffer sb=new StringBuffer();
		Map<String,Menu> param=new HashMap<String,Menu>();
		
		//存放 pid——pid个数
		List<String> numlist=new ArrayList<String>();
		for(Menu vo: menu){
			param.put(vo.getId().toString(), vo);
			if(numlist.contains(vo.getPid())){
				continue;
			}else{
				numlist.add(vo.getPid());
			}
		}
		String pid="0";
		Boolean flag=true;
		int i=1;
		for(String num:numlist){
			i=1;
			flag=true;
			String len="&"+num+"&";
			StringBuffer sbf=new StringBuffer();
			if(num.equals("0")){
				Menu pvo=param.get("1");
				 sb=sb.append("{ text :'"+pvo.getName()+"',id :'"+pvo.getId()+"'&"+pvo.getId()+"&}");
				 param.remove("1");
			}else{
				for(Menu vo: param.values()){
					pid=vo.getPid();
					if(num.equals(pid)){
						if(sb.indexOf(len)>0){
							if(flag){
								sb.insert(sb.indexOf(len), ",nodes: [");
								sb.insert( sb.indexOf(len)+len.length(), "]");
								flag=false;
							}
							if(i==1){
								String s="{ text :'"+vo.getName()+"',id :'"+vo.getId()+"'&"+vo.getId()+"&}";
								sbf.append(s);
								i=i+1;
								continue;
							}if(i>1){
								String s=",{ text :'"+vo.getName()+"',id :'"+vo.getId()+"'&"+vo.getId()+"&}";
								sbf.append(s);
								i=i+1;
								continue;
							}
						}
					}
				}
				if(sb.indexOf(len)>0){
					sb.replace(sb.indexOf(len),sb.indexOf(len)+len.length() , sbf.toString());
				}
			}
		}
		while(sb.indexOf("&")>0){
			sb.delete(sb.indexOf("&"), sb.indexOf("&", sb.indexOf("&")+1)+1);
		}
		return sb.toString();
	}
}
