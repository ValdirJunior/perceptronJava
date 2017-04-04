import java.util.Scanner; 

public class Principal
{
	public static void main(String args[])
	{
		Scanner reader = new Scanner(System.in);
		
		int opProblem = 0;
		
		
		System.out.println("Qual problema deseja treinar?\n1 -  AND\n2 - Letras");
		opProblem = reader.nextInt();
		System.out.println(opProblem);
		
		if(opProblem == 1)
		{
			//cria um Perceptron com 2 entradas
			Perceptron p = new Perceptron(2);
			
			int padroes[][] = 	{
							{0,0},
							{0,1},
							{1,0},
							{1,1},
						};
			
			int dj[] = {0,
						0,
						0,
						1};// para perceptron multicamada, os desejaveis são diferentes para cada perceptron, desmembrar o problema.
			
			//treinar usando eta=0.2
			p.treinar(padroes,dj,0.2);
			
			System.out.printf("0, 0 = %d\n", p.Y(new int[]{0,0}));
			System.out.printf("0, 1 = %d\n", p.Y(new int[]{0,1}));
			System.out.printf("1, 0 = %d\n", p.Y(new int[]{1,0}));
			System.out.printf("1, 1 = %d\n", p.Y(new int[]{1,1}));
		}
		else if(opProblem == 2)
		{
			//cria um Perceptron com 25 entradas
			Perceptron p = new Perceptron(25);
			
			int padroes[][] = {
								{1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1},
								{1,1,1,1,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0}
							};

			int dj[] = {0,1};

			//treinar usando eta=0.2
			p.treinar(padroes,dj,0.2);
			
			System.out.printf("1,1,1,1,1\n1,0,0,0,1\n1,0,0,0,1\n1,1,1,1,1\n1,0,0,0,1 = %d\n\n", p.Y(new int[]{
															1,1,1,1,1,
															1,0,0,0,1,
															1,0,1,0,1,
															1,1,0,1,1,
															1,0,0,0,1}));
			System.out.printf("1,1,1,1,1\n0,0,1,0,0\n0,0,1,0,0\n0,0,1,0,0\n0,0,1,0,0 = %d\n\n", p.Y(new int[]{
															1,1,1,1,1,
															0,0,1,0,0,
															0,0,1,0,0,
															0,0,1,0,0,
															0,0,1,0,0}));
			
		}	
	}
}
