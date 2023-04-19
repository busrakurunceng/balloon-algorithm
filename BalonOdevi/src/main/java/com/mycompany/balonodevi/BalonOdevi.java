/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.balonodevi;


import java.util.Scanner;

public class BalonOdevi {
    
   public static boolean negatifSayiKontrol(int n, int m) {
    if(n<=0 && m<=0) {
        System.out.println("N ve M değerleri negatif olamaz! Lütfen kontrol ediniz.");
        return false;
        }
        else if(n<=0)
                {
                    System.out.println("N değeri negatif olamaz! Lütfen kontrol ediniz.");
                    return false;
                }
                else if (m<=0)
                {
                    System.out.println("M değeri negatif olamaz! Lütfen kontrol ediniz.");
                    return false;
                }
    return true;
}

   // Bir düğüm sınıfı tanımlanıyor
    static class Node {
        int data;       // düğümün değeri
        Node next;      // düğümün bir sonraki düğüm ile bağlantısı

        // constructor (yapıcı fonksiyon)
        Node(int data) {
            this.data = data;   // düğümün değeri atanıyor
            this.next = null;   // düğümün bağlantısı null olarak ayarlanıyor
        }
}

    static void balonPozisyonuBul(int n, int m) {
        
       // N adet balondan oluşan bağlı listeyi oluşturma
        Node head = new Node(1);
        Node gecici = head;
        /* "gecici" değişkeni başlangıçta head değişkenine atanır ve 
        her döngüde bir sonraki düğüme geçer. Son balon kalana kadar bu döngü devam eder */
        
        
        // N adet balondan oluşan bağlı liste
        for (int i = 2; i <= n; i++) {
            Node yeniDugum = new Node(i);
            gecici.next = yeniDugum;
            gecici = yeniDugum;
        }
        //her bir balon için yeni bir düğüm oluşturulur ve bu düğüm bağlı listenin sonuna eklenir. 
        //Son olarak, geçici düğüm, bağlı listenin son düğümü olarak ayarlanır.
        
        gecici.next = head; // Listenin son elemanının bağı ilk elemana bağlanıyor
        
        
        // Son kalan balonu bulmak için algoritma
        
        while (head.next != head) { // Tek bir eleman kalana kadar döngüye devam et
            for (int i = 1; i < m; i++) { // M-1 kadar balon atla ve M.pozisyondaki balonu bul
                gecici = head;  //Her döngü turunda, gecici değişkeni head değişkeninin değerini alıyor
                head = head.next; 
            }
            
            System.out.println(head.data + ". pozisyondaki balon patladı...");
            gecici.next = head.next; // M. balonu patlat
            head = gecici.next; // M. balondan sonraki pozisyondan saymaya devam et
            
            //patlatılan balonu atladım ve sonraki balon üzerinde işleme devam ettim.
        }
        
        // Son kalan balonun pozisyonunu yazdır
        System.out.println("Son kalan balonun pozisyonu: " + head.data);
        
    }
    
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        // n ve m değerlerini kullanıcıdan al
        System.out.print("N değerini giriniz: ");
        int n = scanner.nextInt();
        System.out.print("M değerini giriniz: ");
        int m = scanner.nextInt();
        
    //N ve M değerleri Negatif olamaz! Bunun kontrolü için yeni bir kontrol fonksiyonu yazdım
        if(negatifSayiKontrol(n, m)) {
            System.out.println("N değeri: " + n + " M değeri: " + m);
            
            balonPozisyonuBul(n, m);
}

        
    }
}
