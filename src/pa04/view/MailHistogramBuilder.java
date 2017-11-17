package pa04.view;

import pa04.model.Histogram;
import pa04.model.Mail;
import java.util.List;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> mail){
        Histogram<String> histo = new Histogram<>();
        for (Mail mail1 : mail) {
            histo.increment(mail1.getDomain());
        }
        return histo;
    }

}
