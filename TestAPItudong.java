package com.company;

//params test cho get_verify_code, check_verify_code, login, logout,changepass


public class TestAPItudong {
    public static void giaodientudong() throws Exception {
        System.out.println("Chào mừng tới test tự động");
        String url = ChonHost.HOST(); //Lấy link url của Host và API đã được chọn
        System.out.println(url);
        if (url.contains("signup")) {
            System.out.println(url); //kiểm tra lại link url
            System.out.println("Đăng ký tài khoản");
            Input.SignUp.nhap();
            TestCaseSignUp.Unittest1(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseSignUp.Unittest2(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseSignUp.Unittest3("1111111111111111", "87tyeet67", "019d4ad6-4077-11eb-b378-0242ac130002", url);
            TestCaseSignUp.Unittest4("0972112000", "0", "f6dad910-4076-11eb-b378-0242ac130002", url);
            TestCaseSignUp.Unittest5("", "", "", url);
        } else if(url.contains("get_verify_code")) {
            ChonTestAPIGetverifycode.link = url;
            String signuplink = url.replace("get_verify_code", "signup");
            System.out.println("Đăng ký tài khoản");
            Input.SignUp.nhap();
            Response res = callAPI.callAPISignUp(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, signuplink);
            TestCaseGetverifycode.Unittest1(url);
            //TestCaseGetverifycode.Unittest3(url); test tay se chay dc
            TestCaseGetverifycode.Unittest4(url);
           // TestCaseGetverifycode.Unittest5(url); test tay se chay dc


        } else if (url.contains("login")) {
            String signuplink = url.replace("login", "signup");
            System.out.println(url); //kiểm tra lại link url
            System.out.println("Nhập vào tài khoản đã được kích hoạt mã xác thực");
            Input.SignUp.nhap();
            TestCaseLogin.Unittest1(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseLogin.Unittest2("0392232073", Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseLogin.Unittest3("111111111111", Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseLogin.Unittest4(Input.SignUp.phonenumber, "0", Input.SignUp.uuid, url);
            TestCaseLogin.Unittest5("", "", Input.SignUp.uuid, url);
            TestCaseLogin.Unittest6(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseLogin.Unittest7(Input.SignUp.phonenumber, Input.SignUp.phonenumber, Input.SignUp.uuid, url);
            TestCaseLogin.Unittest8(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, url);
            TestCaseLogin.Unittest9(Input.SignUp.phonenumber, Input.SignUp.password, "", url);
        }else if (url.contains("logout")) {
            String loginlink = url.replace("logout", "login"); //gán link url gọi tới API login
            String signuplink = url.replace("logout", "signup"); //gán link url gọi tới API login

            //Đăng nhập tài khoản đã có để thực thi test case
            System.out.println("Đăng ký tài khoản: ");

            System.out.println("Nhập vào tài khoản đã đượcc kíchc hoạt mã xác thực");
            Input.SignUp.nhap();
            System.out.println(url);

            TestCaseLogout.Unittest1(url, loginlink);
            TestCaseLogout.UnitTest2(url, loginlink);
            TestCaseLogout.UnitTest3(url, loginlink);
            TestCaseLogout.UnitTest4(url, loginlink);

        }

    }
}
