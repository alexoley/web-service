package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HttpRequest {

    public String method = "";
    public String url = "";

    public HttpRequest(String method, String url) {
        this.method = method;
        this.url = url;

    }
      public HttpRequest() {
      

    }

    // public static String run(String method, String url) {
    //     String fileName = "";

    //     switch (url) {
    //     case "/users":
    //         fileName = "users.html";
    //         break;
    //     case "/index":
    //         fileName = "index.html";
    //         break;

    //     default:
    //         break;
    //     }

    //     return fileName;
    // }

    // private String readInputHeaders() throws Throwable {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(is));
    //     String out = "";
    //     while (true) {
    //         String s = br.readLine();
    //         out += s;
    //         System.out.println(s);
    //         if (s == null || s.trim().length() == 0) {
    //             break;
    //         }
    //     }
    //     return out;
    // }

}
