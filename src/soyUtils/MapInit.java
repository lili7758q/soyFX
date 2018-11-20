package soyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import entity.MapValue;

/** 
* @author Soy 
* @date 2017��12��15�� ����11:27:37 
* @version 1.0 
*/
public class MapInit {
	
	public Map initMapPT () {
		Map retMap = new HashMap();
		Map map = new HashMap();
		List retList = new ArrayList<>();
		retMap.put("map",map);
		retMap.put("key", retList);
		
		MapValue map1 = new MapValue(Const.MAP_PT_XSJD,"���ֻ���");
		MapValue map2 = new MapValue(Const.MAP_PT_YJSL,"����ɭ��");
		MapValue map3 = new MapValue(Const.MAP_PT_CXHY,"��ϫ����");
		MapValue map4 = new MapValue(Const.MAP_PT_JSSM,"��ʯɽ��");
		MapValue map5 = new MapValue(Const.MAP_PT_HJL,"�ƽ���");
		MapValue map6 = new MapValue(Const.MAP_PT_CRST,"����ɳ̲");
		MapValue map7 = new MapValue(Const.MAP_PT_YMHS,"�����ɽ");
		MapValue map8 = new MapValue(Const.MAP_PT_SWSM,"����ɳĮ");
		MapValue map9 = new MapValue(Const.MAP_PT_HSSL,"����ʢ¥");
		MapValue map10 = new MapValue(Const.MAP_PT_BT,"��̲");
		MapValue map11= new MapValue(Const.MAP_PT_HDSJ,"��������");
		
		map.put(map1.getName(), map1);
		map.put(map2.getName(), map2);
		map.put(map3.getName(), map3);
		map.put(map4.getName(), map4);
		map.put(map5.getName(), map5);
		map.put(map6.getName(), map6);
		map.put(map7.getName(), map7);
		map.put(map8.getName(), map8);
		map.put(map9.getName(), map9);
		map.put(map10.getName(), map10);
		map.put(map11.getName(), map11);
		
		 List<Map.Entry<String,MapValue>> list = new ArrayList<Map.Entry<String,MapValue>>(map.entrySet());
	        Collections.sort(list,new Comparator<Map.Entry<String,MapValue>>() {
	            //��������
	            public int compare(Entry<String, MapValue> o1,
	                    Entry<String, MapValue> o2) {
	                return Integer.parseInt(o1.getValue().getId())-Integer.parseInt(o2.getValue().getId());
	            }

	        });
	        for(Map.Entry<String,MapValue> mapping:list){ 
	        		retList.add(mapping.getKey());
	          } 
	        retList.add("ʥ��С��");
			map.put("ʥ��С��", new MapValue(Const.MAP_PT_SDXW,"ʥ��С��"));

		return retMap;
	}

	public Map initMapXDL () {
		Map retMap = new HashMap();
		Map map = new HashMap();
		List retList = new ArrayList<>();
		retMap.put("map",map);
		retMap.put("key", retList);
		
		MapValue map1 = new MapValue(Const.MAP_XDL_SZ,"ʯ��");
		MapValue map2 = new MapValue(Const.MAP_XDL_PY,"ƽԭ");
		MapValue map3 = new MapValue(Const.MAP_XDL_LYL,"������");
		MapValue map4 = new MapValue(Const.MAP_XDL_WZSY,"��ָʯӡ");
		MapValue map5 = new MapValue(Const.MAP_XDL_GW,"����");
		MapValue map6 = new MapValue(Const.MAP_XDL_TKZC,"���֮��");
		MapValue map7 = new MapValue(Const.MAP_XDL_TZL,"��֮·");
		MapValue map8 = new MapValue(Const.MAP_XDL_WZL,"Σ֮·");
		
		map.put(map1.getName(), map1);
		map.put(map2.getName(), map2);
		map.put(map3.getName(), map3);
		map.put(map4.getName(), map4);
		map.put(map5.getName(), map5);
		map.put(map6.getName(), map6);
		map.put(map7.getName(), map7);
		map.put(map8.getName(), map8);

		
		 List<Map.Entry<String,MapValue>> list = new ArrayList<Map.Entry<String,MapValue>>(map.entrySet());
	        Collections.sort(list,new Comparator<Map.Entry<String,MapValue>>() {
	            //��������
	            public int compare(Entry<String, MapValue> o1,
	                    Entry<String, MapValue> o2) {
	                return Integer.parseInt(o1.getValue().getId())-Integer.parseInt(o2.getValue().getId());
	            }

	        });
	        for(Map.Entry<String,MapValue> mapping:list){ 
	        		retList.add(mapping.getKey());
	          }
	        map.put("ʥ���Ƶ�", new MapValue(Const.MAP_XDL_SSYD,"ʥ���Ƶ�"));
	        retList.add("ʥ���Ƶ�");
		return retMap;
	}
	
	public Map initMapSS () {
		Map retMap = new HashMap();
		Map map = new HashMap();
		List retList = new ArrayList<>();
		retMap.put("map",map);
		retMap.put("key", retList);
		
		MapValue map1 = new MapValue(Const.MAP_SS_MGZD,"���֮��");
		MapValue map2 = new MapValue(Const.MAP_SS_BZL,"������");
		MapValue map3 = new MapValue(Const.MAP_SS_MWSL,"����ɭ��");
		MapValue map4 = new MapValue(Const.MAP_SS_JSHY,"��ʯ��Ұ");
		MapValue map5 = new MapValue(Const.MAP_SS_LLZQ,"����֮Ȫ");
		MapValue map6 = new MapValue(Const.MAP_SS_SZZT,"����֮��");

		map.put(map1.getName(), map1);
		map.put(map2.getName(), map2);
		map.put(map3.getName(), map3);
		map.put(map4.getName(), map4);
		map.put(map5.getName(), map5);
		map.put(map6.getName(), map6);

		
		 List<Map.Entry<String,MapValue>> list = new ArrayList<Map.Entry<String,MapValue>>(map.entrySet());
	        Collections.sort(list,new Comparator<Map.Entry<String,MapValue>>() {
	            //��������
	            public int compare(Entry<String, MapValue> o1,
	                    Entry<String, MapValue> o2) {
	                return Integer.parseInt(o1.getValue().getId())-Integer.parseInt(o2.getValue().getId());
	            }

	        });
	        for(Map.Entry<String,MapValue> mapping:list){ 
	        		retList.add(mapping.getKey());
	          } 
		return retMap;
	}
}
