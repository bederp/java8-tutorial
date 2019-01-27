package lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

	/**
	 * Rewrite this class to use lambda expression to find
	 */
    public static void main(String[] args) {
        
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        
        File dir = new File("./src/lambda");
        
        File[] files = dir.listFiles(filter);
        
        for (File f : files) {
            System.out.println(f);
        }
    }
}
