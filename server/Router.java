package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.nio.file.*;
import db.DataBase;
import org.xml.sax.SAXException;
import java.sql.Statement;
import java.sql.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import server.Router;
import db.Genres;

public class Router {
    private final static String FILEPATH = "/home/stream/Programs/lesha/";

    public static String run(String url) throws Exception {
        String out = "";

        switch (url) {
        case "public/articles":
            System.out.println("111111111");
            String res = DataBase.executeCommant("select * from article;");
            System.out.print(res + "\t");
            try {
                Path wiki_path = Paths.get(FILEPATH, "/public/articles.html");
                List<String> lines = Files.readAllLines(wiki_path, Charset.defaultCharset());
                String responce = "";
                for (String line : lines) {
                    System.out.println(line);
                }

                for (String line : lines) {
                    String s = line;
                    responce += s.replace("<!--{{tableData}}-->", res) + "\n";

                }

                out = responce;

            } catch (FileNotFoundException e) {
                out = res;
            }

            break;
        case "public/authors":
            System.out.println("22222222");
            res = DataBase.executeCommant("select * from author;");
            System.out.print(res + "\t");
            try {
                Path wiki_path = Paths.get(FILEPATH, "/public/authors.html");
                List<String> lines = Files.readAllLines(wiki_path, Charset.defaultCharset());
                String responce = "";
                for (String line : lines) {
                    System.out.println(line);
                }
                for (String line : lines) {
                    String s = line;
                    responce += s.replace("<!--{{tableData}}-->", res) + "\n";
                }

                out = responce;

            } catch (FileNotFoundException e) {
                out = res;
            }

            break;
        case "public/genres":
            System.out.println("22222222");
            res = DataBase.executeCommant("select * from genre;");
            System.out.print(res + "\t");
            try {
                Path wiki_path = Paths.get(FILEPATH, "/public/genres.html");
                List<String> lines = Files.readAllLines(wiki_path, Charset.defaultCharset());
                String responce = "";
                for (String line : lines) {
                    System.out.println(line);
                }
                for (String line : lines) {
                    String s = line;
                    responce += s.replace("<!--{{tableData}}-->", res) + "\n";
                }
                Genres p = new Genres(0, "TEST", "GOVNO");
                System.out.println(p);
                out = responce;

            } catch (FileNotFoundException e) {
                out = res;
            }

            break;
        case "public/subscribers":
            System.out.println("22222222");
            res = DataBase.executeCommant("select * from subscriber;");
            System.out.print(res + "\t");
            try {
                Path wiki_path = Paths.get(FILEPATH, "/public/subscribers.html");
                List<String> lines = Files.readAllLines(wiki_path, Charset.defaultCharset());
                String responce = "";
                for (String line : lines) {
                    System.out.println(line);
                }
                for (String line : lines) {
                    String s = line;
                    responce += s.replace("<!--{{tableData}}-->", res) + "\n";
                }

                out = responce;

            } catch (FileNotFoundException e) {
                out = res;
            }

            break;
        case "public/authorships":
            System.out.println("22222222");
            res = DataBase.executeCommant("select * from authorship;");
            System.out.print(res + "\t");
            try {
                Path wiki_path = Paths.get(FILEPATH, "/public/authorships.html");
                List<String> lines = Files.readAllLines(wiki_path, Charset.defaultCharset());
                String responce = "";
                for (String line : lines) {
                    System.out.println(line);
                }
                for (String line : lines) {
                    String s = line;
                    responce += s.replace("<!--{{tableData}}-->", res) + "\n";
                }

                out = responce;

            } catch (FileNotFoundException e) {
                out = res;
            }

            break;
        case "/articles":

            out = "";
            break;

        default:

            out = "";
            break;

        }

        return out;
    }
};
