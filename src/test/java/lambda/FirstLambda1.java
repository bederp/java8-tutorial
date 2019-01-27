package lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda1 {

    public static void main(String[] args) {
        FileFilter filterLambda = (File pathname) -> 
                pathname.getName().endsWith(".java");
        
        File dir = new File("./src/lambda");
        
        File[] files = dir.listFiles(filterLambda);
        
        for (File f : files) {
            System.out.println(f);
        }
    }
}
