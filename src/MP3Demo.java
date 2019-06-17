import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;


class MP3Demo {

    private static final InputStream FileInputStream = null;

    public static void main(String[] args) {

        try{
            File mtDir = new File("./mp3");
            File[] contents =  mtDir.listFiles();
            for (int i=0; i<contents.length; i++) {
                if (contents[i].isFile()) {
                    Player playMp3 = new Player(new FileInputStream(contents[i]));
                    playMp3.play();
                }
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}