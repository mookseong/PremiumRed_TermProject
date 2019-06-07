package Play;

import javafx.scene.media.MediaPlayer;

import javax.swing.text.View;
import java.io.IOException;

import static javafx.scene.input.KeyCode.R;

public class Activity {
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedlnstanceState){
        super.onCreate(savedlnstanceState);
        setContentView(R.layout.activity_main);
        music.setLooping(true);
    }
    public void button(View v){
        if(music,isPlaying()){//music.isPlaying이  true : 음악이 현재 재생중, false : 재생중이 아님
            music.stop();
            try {
                music.prepare();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            music.seekTo(0); // 음악 진행정도를 처음으로 되돌림
        }else{
            music.start();
            button.setText(string.stop);
            Thread();//쓰래드를 메소드화 하여 다시 재사용
        }
    }
    public void Thread(){
        Runnable task = new Runnable(){
            public void run(){
                while(music.isPlaying()){//while문을 돌려서 음악이 실행중일때 계속 돌아가게 설정
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
