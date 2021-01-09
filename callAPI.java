package com.company;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Lớp chứa các phương thức truyền tham số được nhập vào tới restFul API đã có
//SignUp, Login, Logout đã tồn tại

public class callAPI {
    //Truyền tham số tới API SignUp
    public static Response callAPISignUp(String phonenumber, String pass, String uuid, String linkurl) throws IOException {
        URL url = new URL(linkurl + "?phonenumber=" + phonenumber + "&password=" + pass + "&uuid=" + uuid);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(conn.getOutputStream())) {

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            Gson g = new Gson();
            System.out.println(content.toString());
            return g.fromJson(content.toString(), Response.class);
        } finally {
            conn.disconnect();
        }
    }


    //Truyền tham số tới API Logout
    public static ResponseLogin callAPILogin(String phonenumber, String password, String uuid, String linkurl) throws Exception {
        URL url = new URL(linkurl + "?phonenumber=" + phonenumber + "&password=" + password + "&uuid=" + uuid);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(con.getOutputStream())) {

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            Gson g = new Gson();
            System.out.println(content.toString());
            ResponseLogin t = g.fromJson(content.toString(), ResponseLogin.class);
            return t;
        } finally {
            con.disconnect();
        }
    }

//Truyền tham số tới API Logout
    public static Response callAPILogout(String token, String linkurl) throws Exception {
        URL url = new URL(linkurl + "?token=" + token);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(con.getOutputStream())) {

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            Gson g = new Gson();
            System.out.println(content.toString());
            return g.fromJson(content.toString(), Response.class);
        } finally {
            con.disconnect();
        }
    }






    public static ResponseGet_verify_code callAPIGVC(String phonenumber, String linkurl) throws Exception {
            URL url = new URL(linkurl + "?phonenumber=" + phonenumber);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            try (DataOutputStream writer = new DataOutputStream(con.getOutputStream())) {
                StringBuilder content;
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
                Gson g = new Gson();
                System.out.println(content.toString());
                return g.fromJson(content.toString(), ResponseGet_verify_code.class);
            } finally {
                con.disconnect();
            }
    }



}