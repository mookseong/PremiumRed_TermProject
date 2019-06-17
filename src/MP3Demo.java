import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

import javax.swing.*;

public class MP3Demo {

private JList jl;
private JFileChooser fileChooser = new JFileChooser();
private JMenuItem itemDel;
private JMenuItem imtePlay;





    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(".mp3");
            Player playMp3 = new Player(fis);
            playMp3.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}