package com.youngrong.forumproject.BoardController;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.net.*;
import java.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class BoardController {
    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/")
    public String registerPage() {
        return "register";
    }
    @GetMapping("/register")
    public String DataBaseManipulation()  {
        String rawURL = "https://localhost:8080/register";
        URL url = new URL(rawURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStreamReader()));
        String FORMS = null;
        for(String line = br.readLine();line!=null; FORMS+=line,line=br.readLine());
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fac.newDocumentBuilder();
        InputSource iSrc = new InputSource(new StringReader(FORMS));
        Document doc = builder.parse(iSrc);
        String mail = doc.getElementById("user-mail").getText();
        String name = doc.getElementById("user-name").getText();
        String pw  = doc.getElementById("user-pw").getText();
        UniversalSafe.saveUserName(mail,name,pw);
    }

    @GetMapping("/new")
    public String newPage() {
        return "new";
    }
}
