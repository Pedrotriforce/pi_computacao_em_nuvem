import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        
        System.out.println("Iniciando o sistema do Neula Araújo Studio de Beleza...");
        
        // Liga o garçom (servidor) e deixa ele escutando a porta 8080
        ServidorWeb.iniciar();
        
    }
}