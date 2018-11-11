package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test1 {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\Strong\\Desktop\\«¿π∫…Ã≥«.txt");
		FileReader reader = new FileReader(file);
		BufferedReader bf = new BufferedReader(reader);
		StringBuffer sb=new StringBuffer();
		String rt = "";
		while((rt=bf.readLine())!=null){
			sb.append(rt);
		}
		String bagHtml = sb.toString();

	}

}
