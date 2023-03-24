import java.nio.file.DirectoryStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class FileType{
   public static void main(String[] args) throws IOException{
      Path path = Paths.get("D:/Backup_25_4_2020/Studies/Kennesaw/Visa/");
      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
      for(Path p: directoryStream){
         System.out.println(Files.probeContentType(p));
      }
   }
}