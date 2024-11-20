import java.sql.*;

public class UserCorrigido {
    // Conexão com o banco de dados
    public Connection conectarBD() throws SQLException {
        Connection conn = null;
        try {
            // Carrega o driver JDBC para MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // URL de conexão com o banco de dados 
            String url = "jdbc:mysql://localhost:3306/banco_de_dados?user=usuario&password=senha";
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        }
        return conn;
    }

    // Verifica se um usuário existe no banco de dados
    public boolean verificaUsuario(String login, String senha) throws SQLException {
        String nome = ""; // Variável para armazenar o nome do usuário, se encontrado
        boolean result = false;

        try (Connection conn = conectarBD();
             PreparedStatement stmt = conn.prepareStatement("SELECT nome FROM usuarios WHERE login = ? AND senha = ?")) {
            // Define os valores dos parâmetros na query
            stmt.setString(1, login);
            stmt.setString(2, senha);

            // Executa a query e obtém o resultado
            ResultSet rs = stmt.executeQuery();

            // Verifica se há registros
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar usuário: " + e.getMessage());
        }
        return result;
    }
}