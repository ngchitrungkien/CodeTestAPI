package com.company;

//Lớp để thực thi các Test Case của API theo cách tự người dùng chọn test case muốn test, nhập vào tham số hợp lệ
//Sau khi kết thúc sẽ trả về response tương ứng
public class TestAPItuchon {
    public static void giaodientuchon() throws Exception {
        String url = ChonHost.HOST(); //Lấy link url của Host và API đã được chọn
        System.out.println(url);

        //kiểm tra url gọi tới API nào và thực thi test case cho API đó
        if(url.contains("signup")) {
            ChonTestAPISignUp.link = url; //gán link url gọi API signUp
            System.out.println(url); //kiểm tra lại link url
            System.out.println("Nhập tài khoản chưa đăng ký");
            ChonTestAPISignUp.TestSignUp(); //Chọn Test Case muốn test với API Sign Up, sau đó thực thi test case đã chọn

        } else if (url.contains("login")) {
            ChonTestAPILogin.link = url; //gán link url gọi tới API login
            System.out.println(url); //kiểm tra lại link url
            ChonTestAPILogin.TestLogin(); //Chọn Test Case muốn test với API Login, sau đó thực thi test case đã chọn

        } else if (url.contains("logout")){
            ChonTestAPILogOut.link = url; //gán link url gọi tới API logout
            String loginlink1 = url.replace("logout", "login"); //gán link url gọi tới API login
            ChonTestAPILogOut.loginlink = loginlink1;


            //Đăng nhập tài khoản đã có để thực thi test case
            System.out.println("Đăng nhập tài khoản: ");
            Input.Login.nhap();
            System.out.println(url);

            String getvflink = url.replace("logout", "get_verify_code");
            String checkvflink = url.replace("logout", "check_verify_code");
            ResponseGet_verify_code resget = callAPI.callAPIGVC(Input.Login.phonenumber, getvflink);
          //  ResponseCheck_verify_code rescheck = callAPI.callAPCheckVC(Input.Login.phonenumber, resget.data.verifyCode, checkvflink);

            //Chọn test case và thực thi test case đã chọn
            System.out.println("Chọn trường hợp test api log out: ");
            ChonTestAPILogOut.TestLogout();



            //Đăng nhập tài khoản đã có để thực thi test case
            System.out.println("Đăng nhập tài khoản: ");
            Input.Login.nhap();


        } else if(url.contains("get_verify_code")){
            ChonTestAPIGetverifycode.link = url;
            String signuplink = url.replace("get_verify_code", "signup");
            System.out.println("Đăng ký tài khoản");
            Input.SignUp.nhap();
            Response res = callAPI.callAPISignUp(Input.SignUp.phonenumber, Input.SignUp.password, Input.SignUp.uuid, signuplink);
            ChonTestAPIGetverifycode.TestGet_verify_code();


        }
    }

}
