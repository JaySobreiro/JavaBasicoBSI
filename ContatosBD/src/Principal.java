import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException {

		/* teste de conexão
		Connection conn = new ConnectionFactory().getConnection();
		System.out.println("Conectado com sucesso!\n");
		conn.close();*/

		int op, op2;
		Scanner leitor = new Scanner(System.in);
		ContatoDAO dao = new ContatoDAO();	
		int id;
		Contato busca;

		do {

			System.out.println("\n-----CONTATOS-----");
			System.out.println("1) Cadastrar");
			System.out.println("2) Listar todos");
			System.out.println("3) Buscar");
			System.out.println("4) Excluir");
			System.out.println("0) Sair");
			System.out.print("Informe uma opção: ");
			op = leitor.nextInt();

			switch (op) {

			case 1: // cadastro

				leitor.nextLine();

				Contato c = new Contato();

				System.out.println("\nNovo Contato:");
				System.out.print("Nome: ");
				c.setNome(leitor.nextLine());
				System.out.print("Fone: ");
				c.setFone(leitor.nextLine());
				System.out.print("E-mail: ");
				c.setEmail(leitor.nextLine());

				dao.cadastrarContato(c);

				System.out.println("\nContato cadastrado com sucesso!");

				break;

			case 2: // listagem

				ArrayList<Contato> listaContatos = dao.getContatos();

				if(listaContatos.isEmpty()) {

					System.out.println("\nAtenção: não há contatos cadastrados!");
				}else {

					System.out.print("\nContatos Cadastrados:");
					for(Contato temp : listaContatos) {

						System.out.println("\n" + temp.toString());
					}


				}

				break;

			case 3: // buscar contato

				System.out.print("\nInforme o ID do contato que deseja encontrar: ");
				id = leitor.nextInt();

				busca = dao.getContato(id);

				if(busca == null) {
					System.out.println("\nNão foi encontrado contato com este id...");
				}else {

					System.out.println("\nContato localizado:");
					System.out.println(busca.toString());
				}

				break;

			case 4: // deletar

				System.out.print("\nInforme o ID do contato que deseja excluir: ");
				id = leitor.nextInt();

				busca = dao.getContato(id);

				if(busca == null) { // o contato não existe
					System.out.println("\nNão foi encontrado contato com este id...");

				}else { // o contato existe

					// exibe contato
					System.out.println("\nContato localizado: ");
					System.out.println(busca.toString());

					System.out.println("\nDeseja excluir este contato?");
					System.out.println("1) Sim");
					System.out.println("2) Não");
					System.out.print("Sua opção: ");
					op2 = leitor.nextInt();

					while(op2 != 1 && op2 != 2) {
						System.out.println("\nOpção invlálida");
						System.out.println("\nDeseja excluir este contato?");
						System.out.println("1) Sim");
						System.out.println("2) Não");
						System.out.print("Sua opção: ");
						op2 = leitor.nextInt();
					}

					if(op2 == 1) {

						dao.deletarContato(id);
						System.out.println("\nContato nº " + id +" excluido com sucesso!");
					}

				}

				break;

			case 0: // sair

				System.out.println("\nO sistema foi finalizado...");
				break;

			default:
				System.out.println("\nATENÇÃO: opção inválida!");
				break;
			}

			System.out.println();

		} while (op != 0);

	}

}
