import Data.XML_Reading;
import Data.XML_wirte;

import java.io.File;

public class Red {
    public static void main(String[] args){
        File file = new File("Red_List.xml");

        // 파일 존재 여부 판단
        if (!file.isFile()) {
            XML_wirte XML_Wirte = new XML_wirte("test","test");
            XML_Wirte.Wirte(1);
        }else {
            XML_Reading XML_Reading = new XML_Reading("");
            XML_Reading.start();
        }
    }
}
