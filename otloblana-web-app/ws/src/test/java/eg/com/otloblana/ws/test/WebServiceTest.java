package eg.com.otloblana.ws.test;

import eg.com.otloblana.common.rest.ResponseEntity;
import eg.com.otloblana.common.util.RestUtil;
import eg.com.otloblana.model.dto.UserDto;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed_2 on 11/20/2015.
 */
public class WebServiceTest {


    RestUtil restUtil;



    @Before
    public void init() {
        restUtil = RestUtil.getInstance("localhost",8080,"otloblana/rest/");
    }


    @Test
    public void userAuthTest () {

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username","eltntawy"));
        params.add(new BasicNameValuePair("password", "123"));

        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>();

        try {

            responseEntity = restUtil.get("Auth", params, responseEntity.getClass());

            Assert.assertNotNull(responseEntity);

            Assert.assertNotNull(responseEntity.getObject());

            Assert.assertTrue(responseEntity.getObject() instanceof UserDto);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
