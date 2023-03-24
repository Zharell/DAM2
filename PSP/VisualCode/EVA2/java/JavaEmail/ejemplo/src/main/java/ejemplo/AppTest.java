package ejemplo;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class AppTest {

    public static final int NOMBRE_AUTH=0;
    public static final int NOMBREP_AUTH=1;
    public static final int CORREO_AUTH=2;
    public static void main(String[] args) {
        try {

            //Contestame con Sysout, gracias 
            

            //Instanciamos
            Email email = new SimpleEmail();

            //Eliges el sitio, puerto 
            email.setHostName("smtp.educa.madrid.org");
            email.setSmtpPort(587);

            //Te autorizas, no se deben cifrar los datos
            //Utilizo la clase Sp para extraer datos de un documento con las credenciales
            //Retorna un ArrayList con los datos
            email.setAuthentication(Sp.getPalabra().get(NOMBRE_AUTH), Sp.getPalabra().get(NOMBREP_AUTH));
            email.setStartTLSEnabled(true);

            //Correo emisor
            email.setFrom("IJDOIASJDSIOASD@educa.madrid.org");

            //Subtitulo y mensaje
            email.setSubject("HolaAmigo");
            email.setMsg("Seguramente, le estás introduciendo un nombre y contraseña" 
                                    +" cifradas con base no es necesario, crea otra"
                                    +" clase java con atributos constantes y static y los llamas de forma externa, un saludo");

            //receptor y método de envío
            email.addTo("francisco.lopez82@educa.madrid.org");
            email.send();

            System.out.println("Email sent!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}

