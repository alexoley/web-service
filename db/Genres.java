package db;

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

public class Genres {
    public Integer id = 0;
    public String Name = "";
    public String Type = "text/html";

    public Genres(int id, String Name, String Type) {
        this.Name = Name;
        this.Type = Type;
        this.id = id;

    }

    @Override
    public String toString() {
        String out = "{\n\"name\":" + this.Name + ",\n\"type\":" + this.Type + ",\n\"id\":" + this.id + " }";
        return out;
    };
};