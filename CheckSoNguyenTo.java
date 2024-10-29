/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksonguyento;

import java.util.Scanner;

/**
 *
 * @author khoac
 */
public class CheckSoNguyenTo {
    public static boolean isPrimeNumber(int b){
        if (b<2) {
            return false;
        }
        for (int i=2;i<b;i++){
            if (b%i==0){
                return false;
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao mot so nguyen: ");
        String a = sc.nextLine();
        
        try {
            int b = Integer.parseInt(a);
            if (isPrimeNumber(b)) {
                System.out.println("Day la so nguyen to");
            }
            else 
                System.out.println("Day khong la so nguyen to");
        }catch (NumberFormatException exception){
            System.out.println("Day khong la so nguyen");
            System.out.println("Vui long nhap so nguyen");
        }
        sc.close();
     
    }
    
}
