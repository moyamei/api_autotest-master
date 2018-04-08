package test.com.sen.api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class testht {
    //public  static  void main(String []args) {
    public  void  post() throws Exception{
        // 创建HttpClient实例

        HttpClient client = new DefaultHttpClient();
        // 根据URL创建HttpPost实例
        HttpPost post = new HttpPost("https://workservice.lanrenyun.cn/lazyAuth/geetestRegiste");
      
        // 构造post参数

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //params.add(new BasicNameValuePair("name", "11"));
        params.add(new BasicNameValuePair("json","{}"));
        System.out.println("hhhhhhhh"+params);
        // 编码格式转换
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"UTF-8");
        //HttpEntity entity = new UrlEncodedFormEntity(params);
        //HttpEntity entity  = new UrlEncodedFormEntity(params,"form-data");
        // 传入请求体
        post.setEntity(entity);
        post.setHeader("content-type","application/x-www-form-urlencoded");

        // 发送请求，得到响应体
        HttpResponse response = client.execute(post);
        System.out.println("moyamei"+response);
        // 判断是否正常返回
        if (response.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            HttpEntity resEntity = response.getEntity();
            String data = EntityUtils.toString(resEntity);
            System.out.println(data);
        }

        System.out.println("hhhhhhhh");



    }
    public  static void main(String[]args){
     testht te=new testht();
        try {
            System.out.println("wangzhuzhu1");
            te.post();
            System.out.println("wangzhuzhu");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}


