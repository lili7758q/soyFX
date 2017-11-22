package soyUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/** 
* @author Soy 
* @date 2017年11月22日 下午3:49:55 
* @version 1.0 
*/
public class SoyPost implements Callable<Map>{
	static Logger log = Logger.getLogger(SoyPost.class);
	private CloseableHttpClient client;
	private HttpPost post;
	private String charset;


	public SoyPost(CloseableHttpClient client,HttpPost post,String charset){
		this.client = client;
		this.post = post;
		this.charset=charset;
	}


	@Override
	public Map call() throws Exception {
		HttpResponse response = client.execute(post);
		int code = response.getStatusLine().getStatusCode();
		String body = EntityUtils.toString(response.getEntity(),charset);
		log.info("Method post() -- " + post.getURI());
		log.info("code: "+ code);
		Map retMap = new HashMap();
		retMap.put("code", code);
		retMap.put("body",body );
		post.releaseConnection();
		return retMap;
	}
	

}
