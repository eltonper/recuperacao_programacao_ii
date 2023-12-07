package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Aluno;

public class ListarAlunos {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select a from Aluno a");

		List<Aluno> lista = query.getResultList();

		System.out.printf("%-5s%-20s%-30s%-15s%-20s%-20s%-30s%n", "Id", "Nome", "E-mail", "CPF", "Data de Nascimento",
				"Naturalidade", "Endereco");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");

		for (Aluno a : lista) {
			System.out.printf("%-5s%-20s%-30s%-15s%-20s%-20s%-30s%n", a.getId(), a.getNome(), a.getEmail(), a.getCpf(),
					a.getDataDeNascimento(), a.getNaturalidade(), a.getEndereco());
		}

		manager.close();
		factory.close();

	}

}