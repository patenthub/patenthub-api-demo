package com.patenthub.api.demo;

import com.google.gson.Gson;
import com.patenthub.api.model.Pagination;
import com.patenthub.api.model.PatentModel;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 专利基本信息接口 调用演示
 */
public class QueryPatentDetailDemo {

    private static Logger logger = LoggerFactory.getLogger(QueryPatentDetailDemo.class);

    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static HttpClientBuilder clientBuilder = null;
    private static RequestConfig requestConfig = null;
    public static int REQUEST_TIMEOUT = 3000;
    public static int CONNECT_TIMEOUT = 3000;
    public static int SOCKET_TIMEOUT = 3000;
    public static int MAX_CONNECTION = 100;
    public static int MAX_HOST_CONNECTION = 30;
    public static String UTF_8 = "UTF-8";
    public static int READER_SIZE = 8192;

    static {
        requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTION);
        connectionManager.setDefaultMaxPerRoute(MAX_HOST_CONNECTION);
        clientBuilder = HttpClients.custom().setConnectionManagerShared(true);
        clientBuilder.setConnectionManager(connectionManager);
    }

    public static void main(String[] args){

        String baseUrl = "http://www.patenthub.cn/api/patent/base?";
        String token = "81c38e8597cb41a8e19468a24ff4f64b11ce761f";
        String id = "CN106898940A";
        int version = 1;

        StringBuffer url = new StringBuffer();
        url.append(baseUrl).append("t=").append(token).append("&id=").append(id).append("&v=").append(version);

        String result = search(url.toString());

        PatentModel patent = new Gson().fromJson(result,PatentModel.class);

        System.out.println(new Gson().toJson(patent));

    }

    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static String search(String url){
        CloseableHttpClient httpClient = clientBuilder.build();
        StringBuilder entityStringBuilder = null;

        try {
            HttpGet get = new HttpGet(url);
            get.setConfig(requestConfig);
            CloseableHttpResponse httpResponse = httpClient.execute(get);
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;

            try {
                HttpEntity entity = httpResponse.getEntity();
                entityStringBuilder = new StringBuilder();
                if (null != entity) {
                    inputStreamReader = new InputStreamReader(httpResponse.getEntity().getContent(), UTF_8);
                    bufferedReader = new BufferedReader(inputStreamReader, READER_SIZE);
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        entityStringBuilder.append(line + "\n");
                    }
                }
            }
            catch (Exception e) {
                logger.error("Request {} Exception {}",url,e);
            }
            finally {
                try {
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                }
                catch (Exception e) {
                    logger.error("inputStreamReader close error Request {} Exception {}",url,e);
                }
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
                catch (Exception e) {
                    logger.error("bufferedReader close error Request {} Exception {}",url,e);
                }
                try {
                    if (httpResponse != null) {
                        httpResponse.close();
                    }
                }
                catch (Exception e) {
                    logger.error("httpResponse close error Request {} Exception {}",url,e);
                }
            }
        }
        catch (Exception e) {
            logger.error("Request {} Exception {}",url,e);
        }
        finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            }
            catch (Exception e) {
                logger.error("httpClient close error Request {} Exception {}",url,e);
            }
        }

        return entityStringBuilder==null?"":entityStringBuilder.toString();
    }


}
