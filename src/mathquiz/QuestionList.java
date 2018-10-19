package mathquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class QuestionList {
    private File file;
    private HashSet<Question> qlist;

    public HashSet<Question> getQlist() throws FileNotFoundException {
        Scanner sc=new Scanner(getFile());
        while(sc.hasNext()){
            String line=sc.nextLine();
            String results[]=line.split("-");
        }
        return qlist;
    }
    public File getFile(){
        File file=new File("GeneralQuestions.txt");
        this.file=file;
        return file;
    }
}
