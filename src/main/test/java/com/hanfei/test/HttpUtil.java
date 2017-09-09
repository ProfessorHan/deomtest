package com.hanfei.test;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : HanFei
 * @date: 2017/9/8
 * @desc:发送http请求(依赖httpClient4.x)
 */
public final class HttpUtil {

    /**
     * 默认客户端代理
     */
    private final static String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36";
    /**
     * 编码方式
     */
    private final static Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    /**
     * GET请求标志
     */
    public final static int GET = 0;
    /**
     * POST请求标志
     */
    public final static int POST = 1;

    private HttpUtil() {

    }


    public static String execute(int method, String url) throws Exception {
        Map<String, Object> map = new HashMap<>();
        return method == GET ? httpGet(url, map) : httpPost(url, map);

    }

    public static String execute(int method, String url, String key, String value) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return method == GET ? httpGet(url, map) : httpPost(url, map);

    }

    public static String execute(int method, String url, String key1, String value1, String key2, String value2) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        return method == GET ? httpGet(url, map) : httpPost(url, map);
    }

    public static String execute(int method, String url, String key1, String value1, String key2, String value2, String key3, String value3) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);
        return method == GET ? httpGet(url, map) : httpPost(url, map);
    }


    /**
     * 发送GET请求,返回响应体(不带请求参数)
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpGet(String url) throws Exception {
        return httpGet(url, null);
    }

    /**
     * 发送GET请求,返回响应体(带请求参数)
     *
     * @param url
     * @param paramsMap
     * @return
     * @throws Exception
     */
    public static String httpGet(String url, Map<String, Object> paramsMap) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url).setCharset(DEFAULT_CHARSET);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                    paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                uriBuilder.setParameters(paramList);
            }
            String uri = uriBuilder.build().toString();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("User-Agent", DEFAULT_USER_AGENT);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
        } finally {
            httpClient.close();
        }
    }


    /**
     * 发送POST请求,返回响应体(不带请求参数)
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpPost(String url) throws Exception {
        return httpPost(url, null);
    }

    /**
     * 发送POST请求
     *
     * @param url
     * @param paramsMap
     * @return
     * @throws Exception
     */
    public static String httpPost(String url, Map<String, Object> paramsMap) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            String uri = new URIBuilder(url).setCharset(DEFAULT_CHARSET).build().toString();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("User-Agent", DEFAULT_USER_AGENT);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                    paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(paramList, "UTF-8");
                httpPost.setEntity(postEntity);
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
        } finally {
            httpClient.close();
        }
    }

    public static void main(String[] args) throws Exception {

//        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build();
//        CloseableHttpClient aDefault = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        CloseableHttpClient aDefault = HttpClients.createDefault();


       /* HttpPost httpPost = new HttpPost("http://172.16.18.88:8080/toLogin.do");
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("email", "hf"));
        paramList.add(new BasicNameValuePair("pwd", "1234"));
        paramList.add(new BasicNameValuePair("url", ""));
        UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(paramList, "UTF-8");
        httpPost.setEntity(postEntity);
        HttpEntity entity = aDefault.execute(httpPost).getEntity();
        System.out.println(EntityUtils.toString(entity,DEFAULT_CHARSET));*/


        HttpGet httpGet = new HttpGet("http://e-hentai.org");
        httpGet.setHeader("User-Agent", DEFAULT_USER_AGENT);
        CloseableHttpResponse execute = aDefault.execute(httpGet);
        System.out.println(EntityUtils.toString(execute.getEntity(), DEFAULT_CHARSET));


        String phone = "13920266937";
        String code = "北京，邢台，上海。";
        String tplId = "39638";
        String url = "http://v.juhe.cn/sms/send?mobile=" + phone + "&tpl_id=" + tplId + "&tpl_value=%23code%23%3D" + code + "&key=e3d4c483e58d86102bce4e05dcf071c1";
        String s = httpPost(url);
        System.out.println(s);
    }


}
