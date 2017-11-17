package pa04.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pa04.model.Mail;

public class MailListReader {
    public static ArrayList<Mail> read() throws ClassNotFoundException, SQLException{
        ArrayList<Mail> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        
        Statement st = connection.createStatement();
                
        String query = "SELECT * FROM MAIL";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            String mail = rs.getString("mail");
            if(!mail.contains("@")){
                continue;
            }
           Mail correo = new Mail(rs.getString("mail"));
           mailList.add(correo);
        }
        
        return mailList;
    }
}
