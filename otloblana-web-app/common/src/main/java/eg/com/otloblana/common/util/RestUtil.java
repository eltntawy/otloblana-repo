package eg.com.otloblana.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import eg.com.otloblana.common.dto.GenericDto;
import eg.com.otloblana.common.rest.ResponseEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohamed on 2015/07/11.
 */
public class RestUtil {

    // Global Service properties
    private final String PROTOCOL = "http";
    private final String HOST;
    private final int PORT;
    private final String WS_URL;

    // Access Credentials
    private static final String AUTH_USERNAME = "sms_blocker_user";
    private static final String AUTH_PASSWORD = "$m$_blocker_p@$$w0rd";

    // HttpClient
    private HttpClient httpClient;
    private Gson gson;


    private RestUtil(String host, int port, String contextPath) {

        if (contextPath!= null && !contextPath.endsWith("/")) {
            contextPath += "/";
        }

        if (contextPath!= null && !contextPath.startsWith("/")) {
            contextPath = "/"+contextPath;
        }

        HOST = host;
        PORT = port;
        WS_URL = PROTOCOL + "://" + HOST + ":" + PORT + contextPath;


        init();
    }

    /***
     * init httpClient with access credentials
     */
    protected void init() {
        httpClient = HttpClients.createDefault();

//        AuthScope authScope = new AuthScope(HOST, PORT);
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(authScope, new UsernamePasswordCredentials(AUTH_USERNAME, AUTH_PASSWORD));
//        Credentials credential = credsProvider.getCredentials(authScope);

//        httpClient.getCredentialsProvider().setCredentials(authScope, credential);

        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

        gson = builder.create();
    }


    /***
     * @param url         service Url
     * @param returnClass return type to convert from json
     * @return response object from web service
     * @throws IOException
     */
    public <T> ResponseEntity get(String url, Class<T> returnClass) throws IOException {
        return get(url, null, returnClass);
    }

    /***
     * @param path         service path
     * @param params      send parameters
     * @param returnClass return type to convert from json
     * @return response object from web service
     * @throws IOException
     */
    public <T> ResponseEntity get(String path, List<NameValuePair> params, Class<T> returnClass) throws IOException {

        if (params != null) {
            path += getParamterAsString(params);
        }

        String url = WS_URL + path;
        HttpGet httpGet = new HttpGet(url);

        return processedRequest(httpGet, returnClass);
    }

    /***
     * @param path         service path
     * @param returnClass return type to convert from json
     * @return response object from web service
     * @throws IOException
     */
    public <T> ResponseEntity post(String path, Class<T> returnClass) throws IOException {
        String url = WS_URL + path;
        return post(url, null, returnClass);
    }

    /***
     * @param path        service path
     * @param params      send parameters
     * @param returnClass return type to convert from json
     * @return response object from web service
     * @throws IOException
     */
    public <T> ResponseEntity post(String path, List<NameValuePair> params, Class<T> returnClass) throws IOException {
        String url = WS_URL + path;
        HttpPost httpPost = new HttpPost(url);

        if (params != null) {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
        }

        return processedRequest(httpPost, returnClass);
    }


    /***
     * @param path service path
     * @return response object from web service
     * @throws IOException
     */
    public ResponseEntity<String> delete(String path) throws IOException {
        String url = WS_URL + path;
        return delete(url, null);
    }


    /***
     * @param path   service path
     * @param params send parameters
     * @return response object from web service
     * @throws IOException
     */
    public ResponseEntity<String> delete(String path, List<NameValuePair> params) throws IOException {


        if (params != null) {
            path += getParamterAsString(params);
        }

        String url = WS_URL + path;
        HttpDelete httpDelete = new HttpDelete(url);

        return processedRequest(httpDelete);
    }


    /***
     * @param path       web service path
     * @param sendObject the object will be converted to json then send it
     * @param tClass     object class type
     * @return response object from web service
     * @throws IOException
     */
    public <T> ResponseEntity<T> postJson(String path, GenericDto sendObject, Class<T> tClass) throws IOException {

        String url = WS_URL + path;
        HttpPost httpPost = new HttpPost(url);

        String json = gson.toJson(sendObject);
        StringEntity entityJson = new StringEntity(json);

        httpPost.setEntity(entityJson);
        httpPost.addHeader("content-type", "application/json");

        return processedRequest(httpPost, tClass);
    }

    /***
     * @param requestBase request method like HttpPost or HttpGet
     * @param tClass      object class type
     * @return response object from web service
     * @throws IOException
     */
    private <T> ResponseEntity<T> processedRequest(HttpRequestBase requestBase, Class<T> tClass) throws IOException {

        HttpResponse response = httpClient.execute(requestBase);
        HttpEntity entity = response.getEntity();
        Reader reader = new InputStreamReader(entity.getContent());

        Type type = new TypeToken<ResponseEntity<T>>() {}.getType();

        ResponseEntity<T> responseEntity = gson.fromJson(reader, type);

        return responseEntity;
    }

    /***
     * @param requestBase request method like HttpPost or HttpGet
     * @return response object from web service
     * @throws IOException
     */
    private ResponseEntity<String> processedRequest(HttpRequestBase requestBase) throws IOException {

        HttpResponse response = httpClient.execute(requestBase);
        HttpEntity entity = response.getEntity();
        Reader reader = new InputStreamReader(entity.getContent());

        Type type = new TypeToken<ResponseEntity>() {}.getType();

        ResponseEntity<String> responseEntity = gson.fromJson(reader, type);

        return responseEntity;
    }


    private String getParamterAsString (List<NameValuePair> params) {
        String urlParams = "?";

        for(NameValuePair pair : params) {
            urlParams+=pair.getName()+"="+pair.getValue()+"&";
        }

        return urlParams;
    }
    private static RestUtil instance;

    public static RestUtil getInstance(String host, int port, String contextPath) {
        if (instance == null) {
            synchronized (RestUtil.class) {
                if (instance == null) {
                    instance = new RestUtil(host, port, contextPath);
                }
            }
        }

        return instance;
    }


}
