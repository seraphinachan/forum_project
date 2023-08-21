package com.youngrong.forumproject.Controller;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class BoardController {
    @GetMapping("/")
    public String indexPage() {
        return "index.html";
    }

    @GetMapping("/register")
    public String registerFront() {
        return "register.html";
    }
    @GetMapping("/okay")
    public String regTask() {
        String rawURL = "https://localhost:8080/register.html";
        URL url = null;
        try {
            url = new URL(rawURL);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String FORMS = null;
        try {
            for(String line = rd.readLine();line!=null; FORMS+=line,line=rd.readLine());
            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = fac.newDocumentBuilder();
            InputSource iSrc = new InputSource(new StringReader(FORMS));
            Document doc = builder.parse(iSrc);
            String mail = doc.getElementById("user-mail").getTextContent();
            String name = doc.getElementById("user-name").getTextContent();
            String pw  = doc.getElementById("user-pw").getTextContent();
            String rn  = doc.getElementById("user-rn").getTextContent();
            UniversalSafe.saveUserName(mail,name,pw,rn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "okay.html";
    }


    @GetMapping("/new")
    public String newPage() {
        return "new.html";
    }
}
