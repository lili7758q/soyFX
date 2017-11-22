package soyUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/** 
* @author Soy 
* @date 2017年11月22日 下午4:21:49 
* @version 1.0 
*/
public class SoyGet implements Callable<Map>{
	static Logger log = Logger.getLogger(SoyGet.class);
	private CloseableHttpClient client;
	private HttpGet get;
	private String charset;

	public SoyGet(CloseableHttpClient client,HttpGet get,String charset){
		this.charset = charset;
		this.client = client;
		this.get = get;
	}
	
	public Map call() throws Exception {
		Map retMap = new HashMap();
		HttpResponse response = client.execute(get);
		int code = response.getStatusLine().getStatusCode();
		String body = EntityUtils.toString(response.getEntity(),charset);
		log.info("Method get() -- " + get.getURI());
		log.info("code: "+ code);
		retMap.put("code", code);
		retMap.put("body",body );
		get.releaseConnection();
		return retMap;
	}

}
