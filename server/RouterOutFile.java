package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

public class RouterOutFile {
    public String Name = "";
    public String Type = "text/html";

    public RouterOutFile(String Name, String Type) {
        this.Name = Name;
        this.Type = Type;

    }

    public RouterOutFile(String Name) {

        if (Name.indexOf("css")!=-1) {
            this.Name = Name;
            this.Type = "text/css";
        } else {
            if (Name.indexOf("jpg")!=-1) {
                this.Name = Name;
                this.Type = "image/webp,image/*,*/*";
            } else {
                if (Name.indexOf("ttf")!=-1) {
                    this.Name = Name;
                    this.Type = "application/octet-stream";
                } else {
                    this.Name = Name;
                    this.Type = "*/*";
                }
            }
        }

    }

    public RouterOutFile() {

    }
};