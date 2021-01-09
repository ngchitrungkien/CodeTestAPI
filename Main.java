package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        System.out.println("Chọn 0 để test API tự chọn\n"+
                "Chọn 1 để test API tự động\n");
        Scanner sc = new Scanner(System.in);
        int kiemtra = Integer.parseInt(sc.next());
        if(kiemtra == 0) {
            TestAPItuchon.giaodientuchon();
        } else {
            TestAPItudong.giaodientudong();
        }
        System.out.println("đúng");
   //0592242010
   //123456789
   //a1997
    }
}