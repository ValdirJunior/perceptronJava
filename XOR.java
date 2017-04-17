public class XOR
{
	public static void main(String args[])
	{
		Perceptron p1 = new Perceptron(2);
		Perceptron p2 = new Perceptron(2);
		Perceptron p3 = new Perceptron(2);
		
		int entradas[][] = 	{
							{0,0},
							{0,1},
							{1,0},
							{1,1},
						};
		
		int entradasp3[][] = 	{
							{0,1},
							{1,0},
							{1,1},
						};				
						
		int dj1[] = {1,1,1,0};
		int dj2[] = {0,1,1,1};
		int dj3[] = {0,0,1};
		
		p1.treinar(entradas,dj1,0.2);
		p2.treinar(entradas,dj2,0.2);
		p3.treinar(entradasp3,dj3,0.3);
	
		int x[] = {1,1};
		int s1 = p1.Y(x);
		int s2 = p2.Y(x);
		
		System.out.printf("Saida para %d, %d = %d", x[0],x[1], p3.Y(new int[]{s1,s2}));
	}
}
