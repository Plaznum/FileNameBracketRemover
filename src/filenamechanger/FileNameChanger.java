
package filenamechanger;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Yelloninja
 */
public class FileNameChanger {

    public static String removeBracket(String oldString){
        String fileName = oldString;
        String newfileName = "";
        boolean inBracket = false;
        for(int i = 0; i<fileName.length(); i++){
            if(fileName.charAt(i)=='['){
                inBracket = true;
            }else if(fileName.charAt(i)== ']' && inBracket == true){
                inBracket = false;
                i++;
            }
            
            if(!inBracket)
                newfileName = newfileName + fileName.charAt(i);
        }
        return newfileName;
    }
    
    

    public static void nameFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                
            } else {
                File newFile = new File(file.getParent(), removeBracket(file.getName()));
                if (file.renameTo(newFile))
                    System.out.println("Success");
                else
                    System.out.println("Failed");
                
            }
        }
    }
    public static void main(String[] args) {
        JFileChooser rc = new JFileChooser();
        rc.setCurrentDirectory(new java.io.File("C:"));
        rc.setDialogTitle("Select Video Folder");
        rc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        rc.showOpenDialog(null);
        File[] files = new File(rc.getSelectedFile().getAbsolutePath()).listFiles();
        nameFiles(files);
    }
}
