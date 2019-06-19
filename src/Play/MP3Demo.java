package Play;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import java.util.Random;
import java.util.Scanner;


class MP3Demo {

    private static final InputStream FileInputStream = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.순차재생 2.랜덤 재생 3.전체반복");
        int a = sc.nextInt();


        try{
            File mtDir = new File("./mp3");
            File[] contents =  mtDir.listFiles();
            for (int i=0; i<contents.length; i++) {
                if (contents[i].isFile()) {
                    if(a==1) {//일반재생
                        Player playMp3 = new Player(new FileInputStream(contents[i]));
                        playMp3.play();
                    }
                    else if(a==2) {//랜덤값재생
                        Random R = new Random();
                        Player playMp3 = new Player(new FileInputStream(contents[R.nextInt(contents.length)]));
                        playMp3.play();
                    }
                    else {//전체반복
                        while(a==3) {
                            Player playMp3 = new Player(new FileInputStream(contents[i]));
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