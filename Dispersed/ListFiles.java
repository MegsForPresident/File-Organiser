package Dispersed;

import java.io.File;
import java.util.*;

public class ListFiles {
    public static LinkedList<String> returnFiles(LinkedList<String> discardPile,File file,String path){

        LinkedList<String> files = new LinkedList<String>();

        String[] fileNames = file.list(); 

        for(String fileName : fileNames){


            if(new File(path + "\\" + fileName).isFile()){

                try{

                    if(!discardPile.contains(fileName)){

                        files.add(fileName);

                    }

                }


                catch(NullPointerException e){

                    files.add(fileName);

                }

            }

        }

        return files;


    }


    
    public static LinkedList<String> exe(LinkedList<String> file){
    
        LinkedList<String> files = new LinkedList<String>();
    
        for(String fileName:file){

            if(!files.contains(fileName.substring(fileName.lastIndexOf(".")))){
            
                files.add(fileName.substring(fileName.lastIndexOf(".")));
            
            }
    
        }
    
        return files;
    
    }
}
