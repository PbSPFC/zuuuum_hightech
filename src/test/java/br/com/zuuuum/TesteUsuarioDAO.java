package br.com.zuuuum;

import javax.swing.JOptionPane;

import br.com.zuuuum.persistence.entidade.Usuario;
import br.com.zuuuum.persistence.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {

		int escolha = Integer.parseInt(
				JOptionPane.showInputDialog("1 - Cadastrar\n" + "2 - Alterar\n" + "3 - Listar\n" + "4 - Excluir"));

		switch (escolha) {
		case 1:
			TesteUsuarioDAO.testeCadastar();
			break;
		case 2:
			TesteUsuarioDAO.testeAlterar();
			break;
		case 3:
			
			break;
		case 4:
			TesteUsuarioDAO.testeDeletar();
			break;
		default:
			break;
		}

	}

	// Metodo para cadastro
	public static void testeCadastar() {
		// Criando o usuário
		Usuario usuario = new Usuario(JOptionPane.showInputDialog("Digite seu nome:"),
				JOptionPane.showInputDialog("Digite seu login:"), JOptionPane.showInputDialog("Digite sua senha:"));

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);

		JOptionPane.showMessageDialog(null, usuario.getNome() + " seu cadastro foi efetuado com sucesso!");

	}

	// Metodo para alterar
	public static void testeAlterar() {
		// Criando o usuário
		Usuario usuario = new Usuario();
		usuario.setId(5);
		usuario.setNome(JOptionPane.showInputDialog("Digite seu nome:"));
		usuario.setLogin(JOptionPane.showInputDialog("Digite seu login:"));
		usuario.setSenha(JOptionPane.showInputDialog("Digite sua senha:"));

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);

		JOptionPane.showMessageDialog(null, usuario.getNome() + " seu cadastro foi alterado com sucesso!");

	}

	// Metodo para deletar
	public static void testeDeletar() {
		// Criando o usuário
		Usuario usuario = new Usuario();
		usuario.setId(7);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.deletar(usuario);

		JOptionPane.showMessageDialog(null, usuario.getId() + " seu cadastro foi excluído com sucesso!");

	}

}
