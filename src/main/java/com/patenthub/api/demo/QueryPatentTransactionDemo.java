package com.patenthub.api.demo;

import com.google.gson.Gson;
import com.patenthub.api.model.TransactionModel;
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
 * 专利事务数据接口 调用演示
 */
public class QueryPatentTransactionDemo {

    private static Logger logger = LoggerFactory.getLogger(QueryPatentTransactionDemo.class);

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

        String baseUrl = "http://localhost:8080/api/patent/tx?";
        String token = "07aec099649e23f9f0e9f23a30e04cf9e9253700";
        String an = "200910062869";
        int version = 1;

        StringBuffer url = new StringBuffer();
        url.append(baseUrl).append("t=").append(token).append("&an=").append(an).append("&v=").append(version);

        String result = search(url.toString());

        TransactionModel transactionModel = new Gson().fromJson(result,TransactionModel.class);

        System.out.println(new Gson().toJson(transactionModel));

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
