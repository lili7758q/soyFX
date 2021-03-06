package soyUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import org.apache.http.client.methods.CloseableHttpResponse;

/** 
* @author Soy 
* @date 2017年11月15日 下午5:03:41 
* @version 1.0 
* @description 网络访问工具类
*/
public class IntUtil {
	private static String UMAIN = "";
	private static String CHARSET = "";
	static CookieStore cookieStore = null;
	static HttpClientContext context = null;
	static CloseableHttpClient client;
	static Logger log = Logger.getLogger(IntUtil.class);
	TextArea showText;
	TextArea rushBuyTips;
	TextArea buyRecordText;
	
	
	public IntUtil (String urlMain,String charset,TextArea showText){
		this.client = HttpClients.createDefault();
		this.UMAIN = urlMain;
		this.CHARSET = charset;
		this.showText = showText;
	}
	
	public void setRushBuyTips(TextArea rushBuyTips){
		this.rushBuyTips = rushBuyTips;
	}
	
	public void setBuyRecord(TextArea buyRecordText){
		this.buyRecordText = buyRecordText;
	}
	
	public void setCharset (String charset){
		this.CHARSET = charset;
	}
	
	public String getCharset(){
		return CHARSET;
	}
	/** 
	* @author Soy 
	* @date 2017年11月16日 下午7:06:02 
	* @description  POST
	*/ 
	public Map post(String url,Map<String,String> paraMap) throws Exception {
		List <NameValuePair>paraList = new ArrayList<NameValuePair>();
		map2ListParam(paraMap,paraList);
		Map map = new HashMap();
		
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paraList,CHARSET);
        HttpPost post = new HttpPost(UMAIN+url);  
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
		int code = response.getStatusLine().getStatusCode();
		String body = EntityUtils.toString(response.getEntity(),CHARSET);
		log.info("Method post() -- " + UMAIN+url);
		log.info("code: "+ code);
		map.put("code", code);
		map.put("body",body );
		post.releaseConnection();
		return map;
		
	}
	
	/** 
	* @author Soy 
	* @date 2017年11月16日 下午7:08:17 
	* @description  GET
	*/ 
	public Map get (String url) throws Exception {
		Map map = new HashMap();
		HttpGet get = new HttpGet(UMAIN+url);
		HttpResponse response = client.execute(get);
		int code = response.getStatusLine().getStatusCode();
		String body = EntityUtils.toString(response.getEntity(),CHARSET);
		log.info("Method get() -- " + UMAIN+url);
		log.info("code: "+ code);
		map.put("code", code);
		map.put("body",body );
		get.releaseConnection();
//		Callable c = new SoyGet(client,get,CHARSET);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future <Map> ret = executorService.submit(c);
//        map = ret.get();
		return map;
	}
	
	/** 
	* @author Soy 
	* @date 2017年11月17日 上午10:10:11 
	* @description  买东西
	*/ 
	public Map buyById (String bid , String n) throws Exception{
		Map buyMap = new HashMap();
		buyMap.put("bid", bid);
		buyMap.put("n", n);
		Map buyRetMap = this.post("function/paibuyGate.php", buyMap);
		log.error("购买东西 -- id: "+bid + ",  数量： "+n);
		return buyRetMap;
	}
	
	/** 
	* @author Soy 
	* @date 2017年11月17日 上午10:10:09 
	* @description  卖东西
	*/ 
	public Map saleById (String bid , String n , String price , String user) throws Exception{
		Map saleMap = new HashMap();
		saleMap.put("bid", bid);
		saleMap.put("n", n);
		saleMap.put("p", price);
		saleMap.put("bp", user);
		Map buyRetMap = this.post("function/paisellGate.php", saleMap);
		log.error("拍卖东西 -- id: "+bid + ",  数量： "+n+ ",  价格： "+price+ ",  购买人： "+user);
		return buyRetMap;
	}
	
	/** 
	* @author Soy 
	* @date 2017年11月17日 上午10:55:22 
	* @description 进化 
	*/ 
	public Map Jh (String type , String id , String pids,String bhid) throws Exception {
		Map jhMap = new HashMap();
		jhMap.put("n", type);//进化线路
		jhMap.put("id", id);//宠物ID
		jhMap.put("pids", pids);//使用物品
		jhMap.put("bhid", bhid);//进化保护
		Map jhRetMap = this.post("function/jhGate.php", jhMap);
		log.info("宠物"+id+" "+type+"线路进化,物品ID:"+pids);
		log.error("宠物"+id+"进化");
		return jhRetMap;
	}
	
	/** 
	* @author Soy 
	* @date 2017年11月17日 下午3:12:25 
	* @description  合成
	*/ 
	public Map hCheng (String aID, String bID, String p1, String p2 ,boolean type ,boolean type1) throws Exception {
		Map hcMap = new HashMap();
		hcMap.put("ap", aID);
		hcMap.put("bp", bID);
		hcMap.put("p1", p1);
		hcMap.put("p2", p2);
		if(type){
			hcMap.put("type", "do");
		}
		if(type1){
			hcMap.put("type1", "check");
		}
		Map hcRetMap = this.post("", hcMap);
		log.error("合成宠物:");
		return hcRetMap;
	}
	
	
	public static void setContext() {
	    System.out.println("----setContext");
	    context = HttpClientContext.create();
	    Registry<CookieSpecProvider> registry = RegistryBuilder
	        .<CookieSpecProvider> create()
	        .register(CookieSpecs.BEST_MATCH, new BestMatchSpecFactory())
	        .register(CookieSpecs.BROWSER_COMPATIBILITY,
	            new BrowserCompatSpecFactory()).build();
	    context.setCookieSpecRegistry(registry);
	    context.setCookieStore(cookieStore);
	  }

	  public static void setCookieStore(HttpResponse httpResponse) {
	    System.out.println("----setCookieStore");
	    cookieStore = new BasicCookieStore();
	    // JSESSIONID
	    String setCookie = httpResponse.getFirstHeader("Set-Cookie")
	        .getValue();
	    String JSESSIONID = setCookie.substring("JSESSIONID=".length(),
	        setCookie.indexOf(";"));
	    System.out.println("JSESSIONID:" + JSESSIONID);
	    // 新建一个Cookie
	    BasicClientCookie cookie = new BasicClientCookie("JSESSIONID",
	        JSESSIONID);
	    cookie.setVersion(0);
	    cookie.setDomain("127.0.0.1");
	    cookie.setPath("/CwlProClient");
	    // cookie.setAttribute(ClientCookie.VERSION_ATTR, "0");
	    // cookie.setAttribute(ClientCookie.DOMAIN_ATTR, "127.0.0.1");
	    // cookie.setAttribute(ClientCookie.PORT_ATTR, "8080");
	    // cookie.setAttribute(ClientCookie.PATH_ATTR, "/CwlProWeb");
	    cookieStore.addCookie(cookie);
	  }
	  
	  public HttpEntity getResponse(HttpResponse httpResponse,String charset)
		      throws Exception {
		  	Map map = new HashMap();
		    // 获取响应消息实体
		    HttpEntity entity = httpResponse.getEntity();
		    // 响应状态
		    System.out.println("status:" + httpResponse.getStatusLine());
		    System.out.println("headers:");
		    HeaderIterator iterator = httpResponse.headerIterator();
		    while (iterator.hasNext()) {
		      System.out.println("\t" + iterator.next());
		    }
		    // 判断响应实体是否为空
		    if (entity != null) {
		      String responseString = EntityUtils.toString(entity,charset);
		      System.out.println("response length:" + responseString.length());
		      System.out.println("response content:"
		          + responseString.replace("\r\n", ""));
		    }
		    return entity;
		  }
	
	  //参数转换
	  public void map2ListParam (Map<String,String> map,List param){
		  for (Map.Entry<String, String> entry : map.entrySet()) {
			  param.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		  }
	  }
	
	  public void showText(String text){
		  Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	if(showText.getText().length()>6000){
						  showText.clear();
					  }
					  log.error(text);
					  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					  //奇怪，单独append个换行符可能会报属java.lang.NullPointerException?
					  showText.appendText("["+format.format(new Date())+"]" + " - "+text+"\n");
			    }
			});
		  
	  }
	  
	  public void showTips(String text,boolean flag){
		  Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	if(flag){
			    		rushBuyTips.clear();
			    	}
					  log.error(text);
					  rushBuyTips.appendText(text+"\n");
			    }
			});
		  
	  }
	  
	  public void addBuyRecord(String text){
		  Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					  log.error(text);
					  buyRecordText.appendText(text+"\n");
			    }
			});
		  
	  }
	
}
