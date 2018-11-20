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
* @date 2017年12月15日 上午11:27:37 
* @version 1.0 
*/
public class MapInit {
	
	public Map initMapPT () {
		Map retMap = new HashMap();
		Map map = new HashMap();
		List retList = new ArrayList<>();
		retMap.put("map",map);
		retMap.put("key", retList);
		
		MapValue map1 = new MapValue(Const.MAP_PT_XSJD,"新手基地");
		MapValue map2 = new MapValue(Const.MAP_PT_YJSL,"妖精森林");
		MapValue map3 = new MapValue(Const.MAP_PT_CXHY,"潮汐海涯");
		MapValue map4 = new MapValue(Const.MAP_PT_JSSM,"巨石山脉");
		MapValue map5 = new MapValue(Const.MAP_PT_HJL,"黄金陵");
		MapValue map6 = new MapValue(Const.MAP_PT_CRST,"炽热沙滩");
		MapValue map7 = new MapValue(Const.MAP_PT_YMHS,"尤玛火山");
		MapValue map8 = new MapValue(Const.MAP_PT_SWSM,"死亡沙漠");
		MapValue map9 = new MapValue(Const.MAP_PT_HSSL,"海市盛楼");
		MapValue map10 = new MapValue(Const.MAP_PT_BT,"冰滩");
		MapValue map11= new MapValue(Const.MAP_PT_HDSJ,"海底世界");
		
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
	            //升序排序
	            public int compare(Entry<String, MapValue> o1,
	                    Entry<String, MapValue> o2) {
	                return Integer.parseInt(o1.getValue().getId())-Integer.parseInt(o2.getValue().getId());
	            }

	        });
	        for(Map.Entry<String,MapValue> mapping:list){ 
	        		retList.add(mapping.getKey());
	          } 
	        retList.add("圣诞小屋");
			map.put("圣诞小屋", new MapValue(Const.MAP_PT_SDXW,"圣诞小屋"));

		return retMap;
	}

	public Map initMapXDL () {
		Map retMap = new HashMap();
		Map map = new HashMap();
		List retList = new ArrayList<>();
		retMap.put("map",map);
		retMap.put("key", retList);
		
		MapValue map1 = new MapValue(Const.MAP_XDL_SZ,"石阵");
		MapValue map2 = new MapValue(Const.MAP_XDL_PY,"平原");
		MapValue map3 = new MapValue(Const.MAP_XDL_LYL,"绿荫林");
		MapValue map4 = new MapValue(Const.MAP_XDL_WZSY,"五指石印");
		MapValue map5 = new MapValue(Const.MAP_XDL_GW,"鬼屋");
		MapValue map6 = new MapValue(Const.MAP_XDL_TKZC,"天空之城");
		MapValue map7 = new MapValue(Const.MAP_XDL_TZL,"天之路");
		MapValue map8 = new MapValue(Const.MAP_XDL_WZL,"危之路");
		
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
	            //升序排序
	            public int compare(Entry<String, MapValue> o1,
	                    Entry<String, MapValue> o2) {
	                return Integer.parseInt(o1.getValue().getId())-Integer.parseInt(o2.getValue().getId());
	            }

	        });
	        for(Map.Entry<String,MapValue> mapping:list){ 
	        		retList.add(mapping.getKey());
	          }
	        map.put("圣兽云殿", new MapValue(Const.MAP_XDL_SSYD,"圣兽云殿"));
	        retList.add("圣兽云殿");
		return retMap;
	}
	
	public Map initMapSS () {
		Map retMap = new HashMap();
		Map map = new HashMap();
		List retList = new ArrayList<>();
		retMap.put("map",map);
		retMap.put("key", retList);
		
		MapValue map1 = new MapValue(Const.MAP_SS_MGZD,"埋骨之地");
		MapValue map2 = new MapValue(Const.MAP_SS_BZL,"孢子林");
		MapValue map3 = new MapValue(Const.MAP_SS_MWSL,"迷雾森林");
		MapValue map4 = new MapValue(Const.MAP_SS_JSHY,"巨石荒野");
		MapValue map5 = new MapValue(Const.MAP_SS_LLZQ,"蓝泪之泉");
		MapValue map6 = new MapValue(Const.MAP_SS_SZZT,"赎罪之塔");

		map.put(map1.getName(), map1);
		map.put(map2.getName(), map2);
		map.put(map3.getName(), map3);
		map.put(map4.getName(), map4);
		map.put(map5.getName(), map5);
		map.put(map6.getName(), map6);

		
		 List<Map.Entry<String,MapValue>> list = new ArrayList<Map.Entry<String,MapValue>>(map.entrySet());
	        Collections.sort(list,new Comparator<Map.Entry<String,MapValue>>() {
	            //升序排序
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
