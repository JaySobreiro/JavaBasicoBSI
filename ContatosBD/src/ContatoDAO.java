import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAO {// DAO = Data Access Object

	private Connection conn;

	public ContatoDAO()  {
		// recebe uma conexão ativa com o banco de dados
		this.conn = new ConnectionFactory().getConnection();
	}

	public void cadastrarContato(Contato c) throws SQLException{

		try {

			String sql = "INSERT INTO tb_contatos (nome, fone, email) " +
					"VALUES (?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getFone());
			stmt.setString(3, c.getEmail());

			stmt.execute();
			stmt.close();

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}


	}// fim cadastrar


	public ArrayList<Contato> getContatos() throws SQLException {

		try {

			String sql = "SELECT id, nome, fone, email FROM tb_contatos";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet resultado = stmt.executeQuery();

			ArrayList<Contato> listaContatos  = new ArrayList<>();

			while(resultado.next()) {

				Contato c = new Contato();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setFone(resultado.getString("fone"));
				c.setEmail(resultado.getString("email"));

				listaContatos.add(c);

			}

			resultado.close();
			stmt.close();

			return listaContatos;


		}catch(SQLException e) {
			throw new RuntimeException(e);
		}


	}// fim listar

	public Contato getContato(int id) throws SQLException {

		try {

			String sql = "SELECT id, nome, fone, email FROM tb_contatos " +
					"WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if(resultado.next()) {

				Contato c = new Contato();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setFone(resultado.getString("fone"));
				c.setEmail(resultado.getString("email"));

				stmt.close();
				resultado.close();

				return c;

			}

			return null;

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}// fim metodo getContato


	public void deletarContato(int id) throws SQLException{

		try {
			
			String sql = "DELETE FROM tb_contatos WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();			

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}


	}

}// fim da classe











