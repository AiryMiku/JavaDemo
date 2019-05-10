//package network;
//
//import okhttp3.*;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Created by Airy on 2018/8/19
// */
//
//public class OKHTTPTest {
//
//    static class Theme{
//        String name;
//        HashMap<String,String> map = new HashMap<>();
//    }
//
//    static String patternString = "<div class=\"box\">+<div class=\"header\">\\S<span class=\"fr fade\">$";
//
//    public static void main(String[] args) {
//        String data = callNetwork("https://www.v2ex.com/planes");
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(data);
//        while (matcher.find()){
//            System.out.println(matcher.group());
//        }
//
//
//    }
//
//    public static String callNetwork(String url){
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .build();
//
//        Call call = client.newCall(request);
//
//        try {
//            Response response = call.execute();
//            return response.body().string();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
