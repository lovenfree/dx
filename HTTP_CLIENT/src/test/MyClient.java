package test;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

public class MyClient {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
//		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.GET)
//				.send();
//		System.out.println(contentRes.getContentAsString());
		

        Request request =  httpClient.POST("http://127.0.0.1:8080/CREATE/test");
        request.header(HttpHeader.CONTENT_TYPE, "application/json");
        request.content(new StringContentProvider("{\"username\":\"jliu\",\"password\":\"123456\"}","utf-8"));

        ContentResponse response = request.send();
        String res = new String(response.getContent());
        System.out.println(res);
        httpClient.stop();
	}
}

//https://blog.naver.com/PostView.naver?blogId=ambidext&logNo=222434508009&categoryNo=60&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView