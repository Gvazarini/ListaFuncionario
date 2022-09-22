package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) 
	{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Quantos Funcionários serão adicionados? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			System.out.println();
			System.out.println("Funcionario #" + (i+1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id))
			{
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
		}

		
		sc.nextLine();
		System.out.println();
		System.out.println("Qual funcionário receberá aumento de salário?");
		System.out.print("ID do funcionário: ");
		int idIncrease = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		if (emp == null)
		{
			System.out.println("Id não existente.");
		}
		else 
		{
			System.out.print("Entre com a porcentagem de aumento: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		
		System.out.println("Empregados listados:");
		for (Employee emp1 : list) 
		{
			 System.out.println(emp1);
		}
				
		sc.close(); 
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;}
}

