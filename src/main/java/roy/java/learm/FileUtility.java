package roy.java.learm;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtility {
    public static void main(String[] args) {
        FileUtility fileUtility = new FileUtility();
        System.out.println(fileUtility.getFilePath("Test.Feature"));
        System.out.println(fileUtility.getFilesFolderPath("/Users/avishek/Desktop"));
    }


    public String getFilePath(String FileName){

       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       return classLoader.getResource(FileName).getPath();
    }
    public String getFilesFolderPath (String directoryPath){
        StringBuffer sb = new StringBuffer();
        try (Stream<Path> walk = Files.walk(Paths.get(directoryPath))){
            sb.append("Files");
            System.out.println(walk.filter(Files::isRegularFile).map(x->x.toString()).collect(Collectors.joining("-")));
            sb.append(walk.filter(Files::isRegularFile).map(x->x.toString()).collect(Collectors.joining("-\n")));
            sb.append("\nFolder");
            sb.append(walk.filter(Files::isDirectory).map(x->x.toString()).collect(Collectors.joining("-\n")));
            return sb.toString();

        }catch (Exception ex){
             ex.printStackTrace();
        }
        return sb.toString();
    }



    ///Users/avishek/Downloads

}
