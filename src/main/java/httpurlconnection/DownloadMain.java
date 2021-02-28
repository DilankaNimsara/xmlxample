package httpurlconnection;

public class DownloadMain {
    public static void main(String[] args) {
        String urlLink = "https://www.codejava.net/download-attachment?fid=87";
        String filePath = "C:\\Users\\ASUS\\Desktop";
        try {
            HttpUrlConnectionExample.downloadFile(urlLink,filePath);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
