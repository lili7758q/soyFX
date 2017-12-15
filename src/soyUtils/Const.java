package soyUtils;
/** 
* @author Soy 
* @date 2017年11月16日 下午3:53:03 
* @version 1.0 
* @description 常量
*/
public class Const {
	/*常用返回码*/
	public static final String CODE_SUCCESSED = "0";
	
	/*Http状态码*/
	public static final int CODE_OK = 200;
	public static final int CODE_BAD_GATEWAY = 502;
	public static final int CODE_NOT_FOUND = 404;
	public static final int CODE_MOVE = 302; //账号密码不正确
	
	/*编码*/
	public static final String UTF_8 = "utf-8";
	public static final String GB2321 = "gb2312";
	
	/*
	 * 拍东西结果，没有枚举值就直接返回一个字符串
	 */
	public static final String SELL_0  = "0";//成功
	public static final String SELL_4  = "4";//您的拍卖物品个数已达上限,请取出已过期的物品！
	public static final String SELL_5  = "5";//该物品不可交易
	public static final String SELL_10 = "10";//您的背包中没有足够的物品可以拍卖！
	public static final String SELL_11 = "11";//此物品已经在拍卖所，请取回后再继续拍卖！
	public static final String SELL_12 = "12";//您操作太快，请稍候再试！
	
	/*
	 * 买东西结果，没有枚举值就直接返回一个字符串
	 */
	public static final String BUY_0  = "0";//成功
	public static final String BUY_3  = "3";//购买物品数量太多！
	public static final String BUY_4  = "4";//包裹空间不足！
	public static final String BUY_5  = "5";//您操作太快！
	public static final String BUY_7  = "7";//该物品不是卖给你的哦！
	public static final String BUY_8  = "8";//您太慢了，东西卖完了！
	public static final String BUY_10 = "10";//您的金币不够！
	
	/*
	 * 进化结果，没有枚举值就直接返回一个字符串
	 */
	public static final String JH_0  = "0";//进化失败！
	public static final String JH_1  = "1";//恭喜您，宝贝进化成功!!
	public static final String JH_2  = "2";//缺少进化必须品！
	public static final String JH_3  = "3";//宝宝的等级太低，还不能进化！
	public static final String JH_4  = "4";//宝贝暂时还不能进化到更高级
	public static final String JH_5  = "5";//您没有足够金币进行进化！
	public static final String JH_6  = "6";//您已经达到最大的进化次数了！
	
	/*
	 * 合成结果，没有枚举值就直接返回一个字符串
	 * 传参不含type1
	 * 带装备合，加参数type=do&type1=check
	 * 不加护宠类，加参数type1=check
	 */
	public static final String HC_0 = "";//合成失败！！
	public static final String HC_1 = "";//您没有相应的宠物
	public static final String HC_2 = "";//这两个宠物好像不能合成噢!
	public static final String HC_3 = "";//您的金币不足，不能合成!
	public static final String HC_5 = "";//成功
	public static final String HC_6 = "";//失败
	public static final String HC_10 = "";//数据读取失败!
	public static final String HC_11 = "";//冷却时间未到！
	public static final String HC_15 = "";//宠物成长未达到合成条件哦！
	public static final String HC_20 = "";//对不起，您的背包中没有此物品!
	public static final String HC_200 = "";//未添加护宠类道具
	public static final String HC_1000 = "";//宠物有装备
	
	/*物品pids*/
	public static final String pids_94   = "94";//进化之书
	public static final String pids_95   = "95";//高进
	public static final String pids_107  = "107";//妖泪
	public static final String pids_747  = "747";//超进
	public static final String pids_748  = "748";//A丹
	public static final String pids_749  = "749";//B丹
	public static final String pids_1221 = "1221";//玉露
	public static final String pids_1222 = "1222";//天仙玉露
	
	/*购买结果*/
	public static final String BUY_RET_SUCCESS = "0";//成功
	public static final String BUY_RET_TOOMANY = "3";//购买物品数量太多！
	public static final String BUY_RET_NEEDSPACE = "4";//包裹空间不足！
	public static final String BUY_RET_TOOFAST = "5";//您操作太快！
	public static final String BUY_RET_NOTYOU = "7";//该物品不是卖给你的哦！
	public static final String BUY_RET_SALEOUT = "8";//您太慢了，东西卖完了！
	public static final String BUY_RET_NOMONEY = "10";//您的金币不够！
	/*分割*/
	//bag
	public static final String BAG_LEFT = "<li><a >";
	public static final String BAG_RIGHT = "</a></li>";
	public static final String ID_LEFT = "id=\"t";
	public static final String ID_RIGHT = "\" onmouseover";
	public static final String NAME_LEFT = "copyWorda(\'";
	public static final String NAME_RIGHT = "');\" style";
	public static final String NUM_LEFT ="class=\"p4\">";
	public static final String NUM_RIGHT ="</p>";
	public static final String SORT_LEFT ="class=\"p3\">";
	public static final String SORT_RIGHT ="</p>";
	//sale
	public static final String SALELIST_LEFT = "shoplist\">";
	public static final String SALELIST_RIGHT = "</table>";
	public static final String SALE_LEFT = "sel(this);";
	public static final String SALE_RIGHT = "</td>";
	public static final String SALEID_LEFT = "bid=";
	public static final String SALEID_RIGHT = ";";
	public static final String SALENAME_LEFT = ">";
	public static final String SALENAME_RIGHT = "(";
	public static final String SALEPRICE_LEFT = "price=";
	public static final String SALEPRICE_RIGHT = ";\"";
	public static final String SALENUM_LEFT = "(";
	public static final String SALENUM_RIGHT = ")";
	
	//牧场
	public static final String MC_PSW_ERR = "1";
	public static final String MC_SUCCESS = "10";
	public static final String MCLIST_LEFT = "shoplist\">";
	public static final String MCLIST_RIGHT = "</table>";
	public static final String MC_LEFT = "sel(this);";
	public static final String MC_RIGHT = "</tr>";
	public static final String MC_NAME_LF = "copyWord(\'";
	public static final String MC_NAME_RT = "\');";
	public static final String MC_ID_LF = "Display(";
	public static final String MC_ID_RT = ");\">";
	public static final String MC_LEVEL_LF = "left;\" >";
	public static final String MC_LEVEL_RT = "</td>";
	public static final String MC_GENRE_LF = "left;\">";
	public static final String MC_GENRE_RT = "</td>";
	
	//个人信息
	public static final String PUB_NAME_LF = "玩家昵称：";
	public static final String PUB_NAME_RT = "</li>";
	public static final String PUB_JB_LF = "金币：";
	public static final String PUB_JB_RT = "</li>";
	public static final String PUB_SJ_LF = "水晶：";
	public static final String PUB_SJ_RT = "</li>";
	public static final String PUB_YB_LF = "元宝：";
	public static final String PUB_YB_RT = "</li>";
	
	//普通地图
	public static final String MAP_PT_XSJD = "1";
	public static final String MAP_PT_YJSL = "2";
	public static final String MAP_PT_CXHY = "3";
	public static final String MAP_PT_JSSM = "4";
	public static final String MAP_PT_HJL  = "5";
	public static final String MAP_PT_CRST = "6";
	public static final String MAP_PT_YMHS = "7";
	public static final String MAP_PT_SWSM = "8";
	public static final String MAP_PT_HSSL = "9";
	public static final String MAP_PT_BT   = "10";
	public static final String MAP_PT_HDSJ = "16";
	public static final String MAP_PT_SDXW = "15";
	
	//新大陆地图
	public static final String MAP_XDL_SZ   = "100";
	public static final String MAP_XDL_PY   = "103";
	public static final String MAP_XDL_LYL  = "106";
	public static final String MAP_XDL_WZSY = "109";
	public static final String MAP_XDL_GW   = "112";
	public static final String MAP_XDL_TKZC = "115";
	public static final String MAP_XDL_TZL  = "118";
	public static final String MAP_XDL_WZL  = "121";
	public static final String MAP_XDL_SSYD = "20";
	
	//神圣地图
	public static final String MAP_SS_MGZD = "131";//埋骨之地
	public static final String MAP_SS_BZL  = "134";//孢子林
	public static final String MAP_SS_MWSL = "137";//迷雾森林
	public static final String MAP_SS_JSHY = "140";//巨石荒野
	public static final String MAP_SS_LLZQ = "145";//蓝泪之泉
	public static final String MAP_SS_SZZT = "148";//赎罪之塔
	
	//副本
	public static final String MAP_FB_YSW = "11";
	public static final String MAP_FB_HLW = "12";
	public static final String MAP_FB_SFK = "13";//史芬克斯密穴
	public static final String MAP_FB_LLC = "14";//玲珑城
	
	public static final String MAP_FB_EFS = "50";
	public static final String MAP_FB_ART = "124";
	public static final String MAP_FB_FLK = "127";//菲拉苛
	
	public static final String MAP_FB_RYDG = "143";//熔岩地宫
	public static final String MAP_FB_MHZJ = "144";//幻魔之境
	
}
