package cn.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSONObject;

public class Test1 {
	public static String URL = "https://open.ys7.com/api/lapp/token/get";

	public static void main(String[] args) {

		JSONObject jsobj = new JSONObject();
		jsobj.put("appKey", "a5746267b1fa4d0489b643706236a8ac");
		jsobj.put("appSecret", "aae7b3a877341a47bd5258dfd9bd2f18");

		post(jsobj);
		// System.out.println(post(jsobj));

	}

	public static String post(JSONObject json) {

		HttpClient client = null;
		HttpPost post = null;

		String result = "";

		try {
			client = new DefaultHttpClient();
			post = new HttpPost(URL);
			post.setHeader("Content-Type", "application/json");
			post.addHeader("Authorization", "Basic YWRtaW46");
			System.out.println(json.toString());
			StringEntity s = new StringEntity(json.toString(), "utf-8");
			s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(s);
			System.out.println(post);
			// 发送请求
			HttpResponse httpResponse = client.execute(post);
			System.out.println(httpResponse);
			// 获取响应输入流
			InputStream inStream = httpResponse.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
			StringBuilder strber = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
				strber.append(line + "\n");
			inStream.close();

			result = strber.toString();
			System.out.println(result);

			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				System.out.println("请求服务器成功，做相应处理");

			} else {

				System.out.println("请求服务端失败");

			}

		} catch (Exception e) {
			System.out.println("请求异常");
			throw new RuntimeException(e);
		}

		return result;
	}
}
