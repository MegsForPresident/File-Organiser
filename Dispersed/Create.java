package Dispersed;

public class Create {
    public static void createFolders(String folder,LinkedList<String> folders){
        for(String folderName : folders){
            File Folder = new File(folder + "\\" + folderName);
            Folder.mkdir();
        }
    }
}
