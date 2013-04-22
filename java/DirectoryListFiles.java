import java.io.File;
import java.util.*;

public class DirectoryListFiles {
	public static void main(String[] args) {
    	List<File> files = getFilesMatchingFromDir(".*?\\.java", System.getProperty("user.dir"));

    	System.out.println(files);
	}

	public static List<File> getFilesMatchingFromDir(String regexp, String directory) {
		File folderToScan = new File(directory); 
		File[] listOfFiles = folderToScan.listFiles();
		List<File> result = new ArrayList<File>();

		for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
            	if (listOfFiles[i].getName().matches(regexp)) {
                	result.add(listOfFiles[i]);
            	}
            }
        }

        return result;
	}
}