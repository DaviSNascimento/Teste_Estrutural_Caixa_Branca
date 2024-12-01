/**
 * Classe User responsável por gerenciar conexões e verificar usuários no banco de dados.
 * 
 * @author Davi Nascimento
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {

    /**
     * Método para conectar ao banco de dados.
     * 
     * @return Objeto Connection caso a conexão seja bem-sucedida, ou null caso contrário.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
        }
        return conn;
    }

    /**
     * Nome do usuário autenticado.
     */
    public String nome = "";

    /**
     * Resultado da verificação de login.
     */
    public boolean result = false;

    /**
     * Verifica se o login e a senha correspondem a um usuário no banco de dados.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return true se as credenciais forem válidas, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login= " + "'" + login + "'";
        sql += "and senha = " + "'" + senha + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
        }
        return result;
    }
}
