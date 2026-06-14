import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    // Metodo para inserir um cliente no banco de dados
    public void inserirCliente(Cliente cliente) {
        // Comando SQL para inserir um cliente, usando "?" para evitar SQL Injection
        String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";

        // Conectando ao banco e preparando o comando SQL
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // substituindo os "?" pelos valores do cliente
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());

            // Executando o comando SQL para inserir o cliente
            stmt.execute();
            System.out.println("✅ Cliente '" + cliente.getNome() + "' cadastrada no banco de dados com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar cliente no banco: " + e.getMessage());
        }
    }
}
