//package httpurlconnection;
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//class Send_HTTP_Post_Request {
//    public static void main(String[] args) {
//        try {
//            Send_HTTP_Post_Request.call_me();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static void call_me() throws Exception {
//        URL url = new URL("https://httpbin.org/post");
//        Map params = new LinkedHashMap<>();
//        params.put("name", "Jinu Jawad");
//        params.put("email", "helloworld@gmail.com");
//        params.put("CODE", 1111);
//        params.put("message", "Hello Post Test success");
//        StringBuilder postData = new StringBuilder();
//        for (param : params.entrySet()) {
//            if (postData.length() != 0) postData.append('&');
//            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//            postData.append('=');
//            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//        }
//        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
//        conn.setDoOutput(true);
//        conn.getOutputStream().write(postDataBytes);
//        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//        StringBuilder sb = new StringBuilder();
//        for (int c; (c = in.read()) >= 0;)
//            sb.append((char)c);
//        String response = sb.toString();
//        System.out.println(response);
//
//    }
//}