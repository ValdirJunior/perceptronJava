import java.util.*;

public class Perceptron
{
	public double w[];//pesos sinapticos
	public double x0 = 1;
	public int n;
	public boolean error = false;
	
	public Perceptron(int n)
	{
		this.n = n;
		Random r = new Random();
		
		w = new double[n+1];
		for(int i = 0; i <= n; i++)
		{
			//w[0] = -0.5;
			//w[1] = 0.6;
			//w[2] = 0.6;
			w[i] = -1 + (1 - (-1)) * r.nextDouble();
			System.out.printf("w"+i+" = "+ w[i]+"\n");
		}
	}
	
	public double somatorio(int entradas[])
	{
		double s = 0;
		//somar wi*xi
		//OBS: lembrar que x0 = 1
		
		for(int i = 0; i <= this.n; i++)
		{
			if(i == 0)
				s +=this.x0 * this.w[i];
			else
				s += entradas[i-1] * this.w[i];
		}
		
		return s;
	}
	
	public int Y(int entradas[])
	{
		if(somatorio(entradas) >= 0)
			return 1;
		else
			return 0;
	}
	
	public void treinar(int padroes[][], int dj[], double eta)
	{
		int ry = 0;
		int verror = 0;
		
		do
		{
			error = false;
			for(int i = 0; i < padroes.length; i++)
			{
				ry = Y(padroes[i]);
				//System.out.println(padroes[i][0]+" "+padroes[i][1]+" Compare: "+ ry+ " " +dj[i]);
				
				if(ry != dj[i])
				{
					error = true;
					//System.out.println("Linha erro:"+i);
					verror = dj[i] - ry;
					
					for(int j = 0; j <= this.n; j++)
					{
						if(j == 0)
						{
							//System.out.printf(w[j]+" + "+ eta +" * "+ verror+" * "+ this.x0);
							w[j] = w[j] + (eta*verror*this.x0);
						}
						else
						{
							//System.out.printf(w[j]+" + "+ eta +" * "+ verror+" * "+ i+" "+(j-1));
							w[j] = w[j] + (eta*verror*padroes[i][j-1]);
						}
							
						//System.out.printf("w"+j+" = "+ w[j]+"\n");
					}
				}
			
				for(int k = 0; k <= this.n; k++)
				{
					//w[0] = -0.5;
					//w[1] = 0.6;
					//w[2] = 0.6;
					System.out.printf("w"+k+" = "+ w[k]+"\n");
				}
				
				System.out.printf("\n---------------------\n");
			}	
		}while(error);
	}
}
