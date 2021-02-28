package httpurlconnection;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionExample {

    public static void downloadFile(String urlLink, String downloadPath) throws Exception {

        URL url = new URL(urlLink);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpsURLConnection.HTTP_OK) {
            String fileName = null;
            String disposition = connection.getHeaderField("Content-Disposition");
            String contentType = connection.getContentType();
            int contentLength = connection.getContentLength();

            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                } else {
                    fileName = urlLink.substring(urlLink.indexOf("/") + 1);
                }
            }

            System.out.println("Content-Type : " + contentType);
            System.out.println("Content-Disposition : " + disposition);
            System.out.println("Content-Length : " + contentLength);
            System.out.println("File-Name : " + fileName);

            InputStream inputStream = connection.getInputStream();
            String saveFile = downloadPath + File.separator + fileName;

            FileOutputStream fileOutputStream = new FileOutputStream(saveFile);

            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            Thread.sleep(60000);
            while ((bytesRead = inputStream.read()) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);

            }

            inputStream.close();
            fileOutputStream.close();

            System.out.println("File Downloaded");

        } else {
            System.out.println("No file downloaded, Response code : " + connection.getResponseCode());
        }

        connection.disconnect();
    }

}
