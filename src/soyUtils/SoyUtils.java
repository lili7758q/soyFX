package soyUtils;

import java.util.ArrayList;
import java.util.List;

/** 
* @author Soy 
* @date 2017年11月27日 下午6:53:37 
* @version 1.0 
*/

/**
 * @author Strong
 * @Description 
 */
public class SoyUtils {
	List getTagList = new ArrayList();

	public List<String> getTagList (String head,String last,String parse){
		if((parse.indexOf(head) == -1) || (parse.indexOf(last) == -1)){
			return this.getTagList;
		}else{
			int hd = parse.indexOf(head)+head.length();
			int ls = parse.indexOf(last);
			getTagList.add(parse.substring(hd,ls));
			parse = parse.substring(parse.indexOf(last)+last.length());
			getTagList (head,last,parse);
		}
		return this.getTagList;
	}
	
	public String getTag (String head,String last,String parse){
		String ret = "";
		if((parse.indexOf(head) == -1) || (parse.indexOf(last) == -1)){
			return ret;
		}else{
			int hd = parse.indexOf(head)+head.length();
			parse = parse.substring(hd);
			int ls = parse.indexOf(last);
			ret = parse.substring(0,ls);
		}
		return ret;
	}
}
