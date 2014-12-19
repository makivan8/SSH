import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
 
	public static void Mail(String Ip, String Time) {
 
		final String username = "makivan8@gmail.com";
		final String password = "makivan1991sep8";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		String msg = "Some one try to login the server from this " + Ip + " address at " + Time; 
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("makivan8@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("makivan1991@gmail.com"));
			message.setSubject("About login failure");
			message.setText(msg);
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
