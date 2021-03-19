import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws RunningOrderError {
        Main.work();
    }
    private static Scanner scan = new Scanner(System.in);
    private static void work() throws RunningOrderError{
        String path = ask("Path: ");
        
        LinkedList<String> discardPile = new LinkedList<String>();

        boolean discard = (ask("Do you want to Discard some  Files: ").trim().toLowerCase().contentEquals("yes")) ? true : false;

        String discardSet = "";

        if(discard){

            discardSet = ask("Type the files(file1, file2):");

        }

        for(String discardName : discardSet.split(", ")){

            discardPile.add(discardName);

        }

        LinkedList<String> file = returnFiles(discardPile, new File(path), path);
        
        LinkedList<String> exe = exe(file);

        LinkedList<String> files = new LinkedList<String>();
        
        boolean custom = (ask("Do you want to customize the Files: ").trim().toLowerCase().contentEquals("yes")) ? true : false;

        HashMap<String,String> map = new HashMap<String,String>();

        if(custom){

            for(String exeName : exe){
                
                String name = ask("Name for " + exeName + " files: ");
                
                if(name.isEmpty()){

                    name = exeName.replace(".","").replace(exeName.charAt(0) + "", (exeName.charAt(0) + "").toUpperCase()) + " files";

                }

                map.put(exeName,name);

                files.add(name);

            }

        }

        createFolders(path, files);

        move(file,map,path);
    
    }
    private static String ask(String a){
        System.out.print(a);
        return scan.nextLine();
    }
    public static void createFolders(String folder,LinkedList<String> folders){
        for(String folderName : folders){
            File Folder = new File(folder + "\\" + folderName);
            Folder.mkdir();
        }
    }
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
    public static void move(LinkedList<String> fileSet,HashMap<String,String> map,String path){
        
        for(String fileName : fileSet){
        
            String a = map.get(fileName.substring(fileName.lastIndexOf(".")));
        
            if(a != null){
        
                File b = new File(path + "\\" + fileName);
                b.renameTo(new File(path + "\\" + a + "\\" + fileName));
        
            }
        
        }
    
    } 
}
class RunningOrderError extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    RunningOrderError(String s){
        super(s);
    }

}
