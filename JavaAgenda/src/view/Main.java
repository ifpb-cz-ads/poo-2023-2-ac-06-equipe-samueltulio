package view;

import dao.UsuarioDao;
import model.Usuario;
import java.util.List;
import javax.swing.*;

//Alterações foram feitas durante testes

public class Main {
    public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDao();
        int choice;
        do {
            String input = JOptionPane.showInputDialog("1.Adicionar Usuario\n" + "2.Listar Usuario\n" + "3.Buscar por Email\n" + "0.Sair");
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
                    String email = JOptionPane.showInputDialog("Digite o email do usuário: ");
                    Usuario novoUsario = new Usuario(nome, email);
                    boolean added = UsuarioDao.addUsuario(novoUsario);
                    if (added) {
                        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao adicionar usuário.");
                    }
                    break;
                case 2:
                    List<Usuario> usuarios = UsuarioDao.listarUsuarios();
                    JOptionPane.showMessageDialog(null, "Lista de Usuarios:\n" + usuarios);
                    break;
                case 3:
                    String searchEmail = JOptionPane.showInputDialog("Digite o email a ser buscado:");
                    Usuario foundUser = UsuarioDao.buscarPorEmail(searchEmail);
                    if (foundUser != null) {
                        JOptionPane.showMessageDialog(null, "Usuário encontrado:\n" + foundUser);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha inválida. Tente novamente.");

            }

        } while (choice != 0);

    }
}
