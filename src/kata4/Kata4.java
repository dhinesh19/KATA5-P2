package kata4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import pa04.model.Histogram;
import pa04.model.Mail;
import pa04.view.HistogramDisplay;
import pa04.view.MailHistogramBuilder;
import pa04.view.MailListReader;

public class Kata4 {
    public static void main(String[] args) throws IOException, Exception {
        Kata4 histo = new Kata4();
        histo.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
        
    private void execute() throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        filename = "/Users/DaniMangtani/NetBeansProjects/Kata4/emails.txt";
        mailList = MailListReader.read(filename);
    }
    
    private void process() throws Exception{
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
