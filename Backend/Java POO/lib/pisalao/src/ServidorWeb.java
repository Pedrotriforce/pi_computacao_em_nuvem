import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ServidorWeb {

    public static void iniciar() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            // Rota 1: Apenas para teste (a que você acabou de acessar)
            server.createContext("/api/teste", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                    exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                    String resposta = "{\"mensagem\": \"Sucesso! O Front-end bateu na porta e o Java atendeu!\"}";
                    exchange.sendResponseHeaders(200, resposta.getBytes(StandardCharsets.UTF_8).length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(resposta.getBytes(StandardCharsets.UTF_8));
                    os.close();
                }
            });

            // Rota 2: A Rota Oficial de Cadastro de Clientes
            server.createContext("/api/clientes", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    // Configurações de Segurança (CORS) para não dar bloqueio no navegador
                    exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                    exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, OPTIONS");
                    exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

                    // Se for só uma verificação de segurança do navegador (OPTIONS), libera passagem
                    if ("OPTIONS".equals(exchange.getRequestMethod())) {
                        exchange.sendResponseHeaders(204, -1);
                        return;
                    }

                    // Se o Front-end estiver mandando dados (POST)
                    if ("POST".equals(exchange.getRequestMethod())) {
                        try {
                            // 1. Lê o pacote que chegou da internet
                            InputStream is = exchange.getRequestBody();
                            String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                            
                            // 2. Extrai o nome e o telefone (Modo Raiz de leitura de JSON)
                            // Esperamos receber algo como: {"nome":"Maria","telefone":"119999"}
                            String nome = body.split("\"nome\":\"")[1].split("\"")[0];
                            String telefone = body.split("\"telefone\":\"")[1].split("\"")[0];

                            // 3. Chama o DAO para salvar no banco
                            Cliente novoCliente = new Cliente(0, nome, telefone);
                            ClienteDAO dao = new ClienteDAO();
                            dao.inserirCliente(novoCliente);

                            // 4. Devolve a resposta de Sucesso para o Front-end
                            String resposta = "{\"status\": \"sucesso\", \"mensagem\": \"Cliente cadastrado com sucesso no FreeDB!\"}";
                            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                            exchange.sendResponseHeaders(201, resposta.getBytes(StandardCharsets.UTF_8).length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(resposta.getBytes(StandardCharsets.UTF_8));
                            os.close();

                        } catch (Exception e) {
                            // Se deu erro ao ler os dados
                            String erro = "{\"status\": \"erro\", \"mensagem\": \"Falha ao cadastrar cliente.\"}";
                            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                            exchange.sendResponseHeaders(400, erro.getBytes(StandardCharsets.UTF_8).length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(erro.getBytes(StandardCharsets.UTF_8));
                            os.close();
                        }
                    }
                }
            });

            server.setExecutor(null);
            server.start();
            System.out.println("🌐 Servidor Web iniciado! Escutando na porta 8080...");

        } catch (IOException e) {
            System.out.println("❌ Erro ao subir o servidor: " + e.getMessage());
        }
    }
}