package com.Mookseong.examples.Red_TermProject.Play;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import java.util.Random;
import java.util.Scanner;

class MP3Demo {
    private static boolean PlayImg = false;//controller에 이게 True False일때 정지 재생으로 나누길래 일단은 이렇게설정
    private static final InputStream FileInputStream = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.순차재생 2.랜덤 재생 3.전체반복");//GUI 연결전에 실험을 위해서 설정함
        int mode = sc.nextInt();

        try{
            File mtDir = new File("./mp3");
            File[] contents =  mtDir.listFiles();
            for (int i=0; i<contents.length; i++) {
                if (contents[i].isFile()) {
                    if(mode==1) {//일반재생
                        Player playMp3 = new Player(new FileInputStream(contents[i]));
                        while(!PlayImg) {//스레드 이용해서 정지
                            Thread.sleep(1000);
                        }
                        playMp3.play();
                    }
                    else if(mode==2) {//랜덤값재생
                        Random R = new Random();
                        Player playMp3 = new Player(new FileInputStream(contents[R.nextInt(contents.length)]));
                        while(!PlayImg) {//스레드 이용해서 정지
                            Thread.sleep(1000);
                        }
                        playMp3.play();
                    }
                    else {//전체반복
                        while(mode==3) {
                            Player playMp3 = new Player(new FileInputStream(contents[i]));
                            while(!PlayImg) {
                                Thread.sleep(1000);
                            }
                            playMp3.play();
                        }

                    }

                }
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}