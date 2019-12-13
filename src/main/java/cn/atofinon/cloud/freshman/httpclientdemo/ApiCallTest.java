package cn.atofinon.cloud.freshman.httpclientdemo;

import lombok.Data;
import org.apache.http.Header;

/**
 * @Author yangjw@tuya.com
 * @Date 2019/12/13 2:57 PM
 * @Descrition
 */


@Data
public class ApiCallTest {

    private String apiKey;
    private String token;
    private String uri;
    private Header[] headers;
    private String reqBody;
    private int responseStatus;
    private String resBody;
    private String errorMsg;

}
