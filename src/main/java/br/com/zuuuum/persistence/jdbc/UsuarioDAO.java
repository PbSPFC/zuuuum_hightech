package br.com.zuuuum.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.zuuuum.persistence.entidade.Usuario;

public class UsuarioDAO {

	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome, login, senha) values(?,?,?)";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, usuario.getNome());
				stm.setString(2, usuario.getLogin());
				stm.setString(3, usuario.getSenha());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, usuario.getNome());
				stm.setString(2, usuario.getLogin());
				stm.setString(3, usuario.getSenha());
				stm.setInt(4, usuario.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Usuario usuario) {
		String sql = "delete from usuario where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setInt(1, usuario.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
