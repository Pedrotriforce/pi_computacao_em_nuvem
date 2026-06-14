import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoDAO {

    public void inserirServico(Servico servico) {
        String sql = "INSERT INTO servico (nome_servico, preco) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getNomeServico());
            stmt.setDouble(2, servico.getPreco());

            stmt.execute();
            System.out.println("✅ Serviço '" + servico.getNomeServico() + "' salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar serviço: " + e.getMessage());
        }
    }
}