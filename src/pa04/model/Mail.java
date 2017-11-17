package pa04.model;

public class Mail {
    
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }  
    
    public String getDomain(){
        String[] dom = mail.split("@");
        return dom[1];
    }

}
