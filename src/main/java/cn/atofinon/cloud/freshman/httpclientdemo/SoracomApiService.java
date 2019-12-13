package cn.atofinon.cloud.freshman.httpclientdemo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

/**
 * @Author yangjw@tuya.com
 * @Date 2019/12/13 2:57 PM
 * @Descrition
 */


@Slf4j
public class SoracomApiService {

    private static String apiKey = "api-93bff630-e7a9-4b01-81c8-60aa0b0b4924";
    private static String token = "eyJraWQiOiJBUUVDQUhnYmdGdnFrclRTbGlNVmNCQnV0VXlVcnNvU1RqTTM4NlR5WGVsaEdlUWtOd0FBQVk0d2dnR0tCZ2txaGtpRzl3MEJCd2FnZ2dGN01JSUJkd0lCQURDQ0FYQUdDU3FHU0liM0RRRUhBVEFlQmdsZ2hrZ0JaUU1FQVM0d0VRUU1OM0dZckhJSDlIdGNmajBjQWdFUWdJSUJRYkh2djg0OGZYRTFCQkw1U294ZDlMaTdaVzhZWUN5NDFIbW4rSFg2RzVpU0Yva3l0bkQwWFhUT3lBeGROc2Vtbm9FQWp2YS9CRU02U2VRazRHYlVHZDdOb2RwMHUydG5EQ1VmK1JHWU96NXJmVlNpVkU0UTlGV0o4Tk9Xc0JXNlBIcENmTzdUN3pyOHhoUTZPcE00akJuS2REU3RKekxtNG82NHJPcjlPNit0NVpvN21kUW4wbjJWcFJqaC96YUtqdkx3QldocVZUL0pWdmg4VVdvQW9CM2FRMWp6WUdqL2JGVjdZWHpzSU9PczlTWnJoMWtmU1FFK09RbWJDNzk2WTdDbkM5N1o5TWhmRDJESUFUY0k4ZDU5MW4rREkzcjVLeTNBRytZRDlQMkU3dzNueEJYeXF6b056WS9ZSWRjL1E4ZHJHNUVhQUw4ZWJPNy9sSVhjU0FrNVl3VGNUVGdqcWs5RVlyRXZ1VXhaeXZSZ3FPdDBFQmdqc0U4Q2FCdG5PSStoTmZDR01xNHFDYURnSURaNGQrSm1YL29xbjU0SStaZDJDLzI3M3ZuazFRPT0iLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzb3JhY29tLmlvIiwiYXVkIjoiT3BlcmF0b3IiLCJleHAiOjE1NzYzMDUzMzQsImp0aSI6Im15S0ZBd2FNRmhOQ2VpdXhXem41elEiLCJpYXQiOjE1NzYyMTg5MzQsIm5iZiI6MTU3NjIxODgxNCwic3ViIjoic29yYWNvbSIsIm9wZXJhdG9yIjp7ImNvdmVyYWdlVHlwZXMiOlsiZyJdLCJwZXJtaXNzaW9ucyI6W3sic3RhdGVtZW50cyI6W3siZWZmZWN0IjoiYWxsb3ciLCJhcGkiOlsiKiJdfV19XSwiYWNjb3VudFR5cGUiOiIxIiwib3BlcmF0b3JJZCI6Ik9QMDAyMjg1ODk1MiIsImhvbWVDb3VudHJ5IjoiVVMiLCJjb3ZlcmFnZVR5cGVBdHRyaWJ1dGVzIjp7ImciOnsidGVybXNWZXJzaW9uIjoiMSIsInBheW1lbnRNZXRob2RTdGF0dXMiOiJyZWdpc3RlcmVkIiwiY29udHJhY3RzIjpbXSwiY29udHJhY3REZXRhaWwiOnt9fX19fQ.HJSj7DkaPYaN4gS_6lMBdq9PHE4OTBbg2NUKj9VRnRvsbJE3cJs88CabJX3gYmhEA0cZH78q4C7Ji4dYZICNYQ29nlp7br7m6Slu1gEu81h040jLWZYXU8pXF0YGNJDgJRWaJV2EvFUZIhms0jfL9SOJKfyj6pDGECYkHg_ncd7m-xeVmr5LhtRVD3mFVybtlqhnIGumi4tiTFh76KH1k0EDUfLcaYu_hO2xzRR4wXaXM6E1_lhHvdwH2aLxzUovIlGf0YSLW4u0233WW39VkS8l-e0WVb4ELe2U_vf4koC1412_Vgcdl1FLsfvSD10MrcA1FBUuF99Xrg6oMc55YA";


    /**
     * get请求
     *
     * @param url
     * @param pathParams
     * @param requestParams
     * @param headParams
     * @return
     */
    public static ApiCallTest getCall(String url, Map<String, String> pathParams, Map<String, String> requestParams, Map<String, String> headParams) {

        CloseableHttpClient client = null;

        ApiCallTest apiCallTest = new ApiCallTest();
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = null;
        HttpGet get = null;

        try {
            // path params
            if (pathParams != null) {
                for (String name : pathParams.keySet()) {
                    String value = pathParams.get(name);
                    String placeHolder = "{" + name + "}";
                    url = url.replace(placeHolder, value);
                }
            }

            // request params
            if (requestParams != null && requestParams.size() > 0) {
                if (url.indexOf("?") < 0) {
                    url += "?";
                }

                for (String name : requestParams.keySet()) {
                    String value = requestParams.get(name);
                    if (name != null && !name.isEmpty() && value != null) {
                        if (!url.endsWith("?")
                                && !url.endsWith("&")) {
                            url += "&";
                        }
                        url += String.format("%s=%s", name,
                                URLEncoder.encode(value, "utf-8"));
                    }
                }
            }
            get = new HttpGet(url);
            get.addHeader("Connection", "keep-alive");

            // head params
            if (headParams != null) {
                for (String key : headParams.keySet()) {
                    String val = headParams.get(key);
                    get.addHeader(key, val);
                }
            }
            apiCallTest.setHeaders(get.getAllHeaders());
            apiCallTest.setUri(get.getURI().toString());
            if (url.startsWith("https")) {
                httpClient = createSSLClientDefault();
                response = httpClient.execute(get);
            } else {
                response = client.execute(get);
            }

            apiCallTest.setResponseStatus(response.getStatusLine().getStatusCode());
            if (response.getEntity() != null) {
                String resBody = EntityUtils.toString(response.getEntity(), "utf-8");
                if (StringUtils.isNotBlank(resBody)) {
                    apiCallTest.setResBody(resBody);
                }
            }

        } catch (SocketException ex) {
            apiCallTest.setErrorMsg(ex.getMessage());
            ex.printStackTrace();
            log.error("DataCaller call other exception " + ex.getMessage(),
                    ex);
        } catch (ClientProtocolException e) {
            apiCallTest.setErrorMsg(e.getMessage());
            log.error(String.format("url:%s--\n ClientProtocolException:%s", url, e.getMessage()), e);
        } catch (IOException e) {
            apiCallTest.setErrorMsg(e.getMessage());
        } finally {
            if (get != null) {
                get.releaseConnection();
            }
        }
        return apiCallTest;
    }


    /**
     * post请求
     *
     * @param url
     * @param pars
     * @return
     * @throws Exception
     */
    public static ApiCallTest postCall(String url, Map<String, String> pars, Map<String, String> headParams, Map<String, String> pathParams) throws Exception {
        ApiCallTest apiCallTest = new ApiCallTest();
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = null;
        HttpPost post = null;
        CloseableHttpClient client = null;


        try {
            // path params
            if (pathParams != null) {
                for (String name : pathParams.keySet()) {
                    String value = pathParams.get(name);
                    String placeHolder = "{" + name + "}";
                    url = url.replace(placeHolder, value);
                }
            }


            post = new HttpPost(url);
//            post.addHeader("Connection", "keep-alive");
//            post.addHeader("Content-Type", "application/json;charset=UTF-8");
            // head params
            if (headParams != null) {
                for (String key : headParams.keySet()) {
                    String val = headParams.get(key);
                    post.addHeader(key, val);
                }
            }


            apiCallTest.setReqBody("utf-8");

            apiCallTest.setHeaders(post.getAllHeaders());
            apiCallTest.setUri(post.getURI().toString());
            if (url.startsWith("https")) {
                httpClient = createSSLClientDefault();
                response = httpClient.execute(post);
            } else {
                //client.execute(get, new BasicResponseHandler());
                response = client.execute(post);
            }

            apiCallTest.setResponseStatus(response.getStatusLine().getStatusCode());
            apiCallTest.setResBody(response.getEntity() != null ? EntityUtils.toString(response.getEntity(), "utf-8") : "");
            if (response.getEntity() != null) {
                String resBody = EntityUtils.toString(response.getEntity(), "utf-8");
                if (StringUtils.isNotBlank(resBody)) {
                    apiCallTest.setResBody(resBody);
                }
            }

        } catch (java.net.SocketException ex) {
            apiCallTest.setErrorMsg(ex.getMessage());
            ex.printStackTrace();
            log.error("DataCaller call other exception " + ex.getMessage(),
                    ex);
        } catch (ClientProtocolException e) {
            apiCallTest.setErrorMsg(e.getMessage());
            log.error(String.format("url:%s--\n ClientProtocolException:%s",
                    url, e.getMessage()), e);
        } catch (IOException e) {
            apiCallTest.setErrorMsg(e.getMessage());
        } finally {
            if (post != null) {
                post.releaseConnection();
            }
        }
        return apiCallTest;
    }


    public static void main(String[] args) {
        String url = "https://g.api.soracom.io/v1/subscribers/{imsi}";
        Map<String, String> pathParams = Maps.newHashMap();
        Map<String, String> requestParams = Maps.newHashMap();
        Map<String, String> headParams = Maps.newHashMap();

        List<NameValuePair> params = Lists.newArrayList();
        NameValuePair pair = new BasicNameValuePair("imsi", "295050910211490");
        params.add(pair);


        String postUrl = "https://g.api.soracom.io/v1/subscribers/{imsi}/deactivate";

        try {
            pathParams.put("imsi", "295050910211490");

            headParams.put("Accept", "application/json");
            headParams.put("X-Soracom-API-Key", apiKey);
            headParams.put("X-Soracom-Token", token);
            headParams.put("Content-Type", "text/plain");

//            ApiCallTest apiCallTest = getCall(url, pathParams, requestParams, headParams);

            ApiCallTest postCall = postCall(postUrl, null, headParams, pathParams);

//            System.out.println(apiCallTest);
            System.out.println(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                @Override
                public boolean isTrusted(X509Certificate[] chain,
                                         String authType) throws CertificateException {

                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

}
