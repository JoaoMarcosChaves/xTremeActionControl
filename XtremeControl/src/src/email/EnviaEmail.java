
package src.email;
import java.security.Security;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.swing.JOptionPane;



public class EnviaEmail {
 //   private String mailhost = "smtp.gmail.com";
    public void enviarEMail(String dest, String conteudo,String assun,String end, String senha){
  	
		Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
  //      props.put("SSL","true");
        
        
//        try {
//        	FileInputStream in = new FileInputStream("C:\\Backup_SistemaVenda\\223251.bak");
//    		props.load(new java.io.FileInputStream("c:\\Backup_SistemaVenda\\225456.bak"));
        
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        
        
        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
                         {
//                               return new javax.mail.PasswordAuthentication("joaomarcoschaves7@gmail.com", "gisele19");
                             return new javax.mail.PasswordAuthentication(end, senha);
                         }
                    });

        
        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {
        	  String remetente = "Emailton";
        	  String nome = "user";
        	  String assunto = "Assunto";
        	  Message message = new MimeMessage(session);
            
                 message.setFrom(new InternetAddress(remetente)); //Remetente
              
              Address[] toUser = InternetAddress.parse(dest);             //Destinatário(s)
  
 
              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject(assun);//Assunto
              message.setText(conteudo);
//            message.setFileName("Backup do dia 17/12 ás 22:32");
              
              
              
//              MimeBodyPart mbp2 = new MimeBodyPart();    
//              FileDataSource fds = new FileDataSource("c:\\Backup_SistemaVenda\\225456.bak");          
//              mbp2.setDataHandler(new DataHandler(fds));          
//               mbp2.setFileName(fds.getName());         
   
//              Multipart mp = new MimeMultipart();          
//              mp.addBodyPart(mbp2);          
             
                   

//               Transport.send(message);        
              
              
              
              /**Método para enviar a mensagem criada*/
              Transport.send(message);
              
              JOptionPane.showMessageDialog(null, "Mensagem enviada para o email "+dest+"");

         } catch (MessagingException e) {
        	 
        	 JOptionPane.showMessageDialog(null, "Favor verificar conexão com a internet, ou o endereço de E-mail.\n"+e);
        	 
         //     throw new RuntimeException(e);
              
         }


}
    
    
}