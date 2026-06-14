import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AgendamentoDAO {

    public void inserirAgendamento(Agendamento agendamento) {
        // Adaptando as colunas padrão que costumam ser usadas em scripts SQL
        String sql = "INSERT INTO agendamento (id_cliente, id_servico, data_hora, observacoes, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Pega o ID do Cliente e do Serviço associados ao agendamento
            // NOTA: Se os seus métodos get se chamarem apenas getId(), altere nas duas linhas abaixo!
            stmt.setInt(1, agendamento.getCliente().getIdCliente()); 
            stmt.setInt(2, agendamento.getServico().getIdServico()); 
            
            // Converte o LocalDateTime do Java para o formato de Data e Hora do MySQL
            stmt.setTimestamp(3, Timestamp.valueOf(agendamento.getDataHora()));
            
            stmt.setString(4, agendamento.getObservacoes());
            stmt.setString(5, agendamento.getStatus());

            stmt.execute();
            System.out.println("✅ Agendamento salvo com sucesso no banco de dados!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar agendamento: " + e.getMessage());
        }
    }
}