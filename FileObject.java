
import java.util.Locale;
import java.lang.Character;
public class FileObject {


  private String originalFileName;
  private String newFileName;

  private String fileExtention; // includes with . prefix.
  public String getOriginalFileName(){ return this.originalFileName; }

  public String getNewFileName(){ return this.newFileName;}

  public FileObject(String originalFileName){
    this.originalFileName = originalFileName;
    this.newFileName = originalFileName;
    this.extractFileExtentionName();
    this.removeEPDFPrefix();
    this.removeSpecialCharacters();
    this.createNewExtention();

  }

  private void createNewExtention(){
    this.newFileName = this.newFileName+this.fileExtention;
  }
  private void extractFileExtentionName(){
    int i = newFileName.lastIndexOf('.');
    if (i > 0) {
      this.fileExtention = "."+newFileName.substring(i+1);
      this.newFileName = this.newFileName.replace(fileExtention,"");
    }
  }


  private void removeEPDFPrefix(){
    this.newFileName = this.newFileName.replace("epdf.pub_","");
  }


  private void removeSpecialCharacters(){
    this.newFileName = this.newFileName.replace("_"," ");
    this.newFileName = this.newFileName.replace("-"," ");
    this.newFileName = this.newFileName.replaceAll("\\(.*\\)","");
    this.newFileName = this.newFileName.replaceAll("\\[.*\\]","");
    this.newFileName = this.newFileName.replaceAll("\\s{2,}", " ").trim();
    this.newFileName = this.newFileName.trim();
    this.newFileName = this.toTitleCase(this.newFileName);
    this.newFileName = this.capitalizeFirstLetterOfString(this.newFileName);
  }

  private String capitalizeFirstLetterOfString(String name){
    return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();

  }

  private String toTitleCase(String text) {
    String c = (text != null)? text.trim() : "";
    String[] words = c.split(" ");
    String result = "";
    for(String w : words){
        result += (w.length() > 1? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase(Locale.US) : w) + " ";
    }
    return result.trim();
  }
}
