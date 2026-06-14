import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDB {

    public static Connection conectar() {
        Properties props = new Properties();
        
        // Lê o arquivo diretamente da raiz do projeto
        try (InputStream input = new FileInputStream("config.properties")) {
            
            // Carrega as propriedades
            props.load(input);

            // Pega as chaves lidas
            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.user");
            String senha = props.getProperty("db.password");

            // Tenta estabelecer a conexão
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Sucesso! Conexão segura estabelecida com o FreeDB!");
            return conexao;

        } catch (SQLException e) {
            System.out.println("❌ Erro de SQL (Banco fora do ar ou senha errada): " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("❌ Erro de Arquivo (Não achou o config.properties na raiz): " + e.getMessage());
            return null;
        }
    }
}