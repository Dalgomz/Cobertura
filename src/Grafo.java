import java.util.ArrayList;
import java.util.Random;

public class Grafo {
	private boolean[][] matriz;

	Grafo(int n){
		matriz = new boolean[n][n];
		Random ran = new Random();
		int value;
		for(int x=0;x<n;x++) 
			for(int y=x;y<n;y++) {
				value = ran.nextInt(2);
				if(value == 0) 
					matriz[x][y] = true;
				else
					matriz[x][y] = false;
				if(x != y)
					matriz[y][x] = matriz[x][y]; 
			}
	}

	Grafo(boolean[][] matriz){
		this.matriz = matriz;
	}

	boolean[][] getMatriz(){
		return this.matriz;
	}

	ArrayList<Integer> getAristas(int vertice){
		ArrayList<Integer> aux = new ArrayList<>();
		for(int i=0;i<matriz[vertice].length;i++) {
			if(matriz[vertice][i])
				aux.add(i);
		}
		return aux;
	}
	int size() {
		return matriz.length;
	}
}
