import java.util.ArrayList;
import java.util.Random;

public class Grafo {
	public static final boolean F = false;
	public static final boolean V = true;
	private boolean[][] matriz;

	Grafo(int n){
		matriz = new boolean[n][n];
		Random ran = new Random();
		int value;
		for(int x=0;x<n;x++) 
			for(int y=x+1;y<n;y++) {	
				value = ran.nextInt(2);
				if(value == 0) 
					matriz[x][y] = true;
				else
					matriz[x][y] = false;
				
				matriz[y][x] = matriz[x][y]; 			
				matriz[x][x] = false;
				
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
	
	// Suma = sumadorUno(0,1,Suma), Se usa max 2^n -1 veces
	static int[] sumadorUno(int pos, int val, int[] numero) {
		if(val == 1) {
			numero[pos]++;
			val = numero[pos] - 1;
			numero[pos] = numero[pos] % 2;
			return sumadorUno(pos+1, val, numero);
		}
		return numero;
	}
	
	void showList() {
		for(int i=0;i<this.size();i++) {
			System.out.println(i + " - " + this.getAristas(i));	
		}
		
	}
	void showMatrix() {
		for(int x=0;x<size();x++) {
			for(int y=0;y<size();y++) 
				if(matriz[x][y]) System.out.print("T ");
				else System.out.print("F ");
			System.out.println();
		}
	}
	
	@SuppressWarnings("unchecked")
	ArrayList<Integer> fuerzaBruta(){
		int[] uso = new int[size()];
		ArrayList<Integer> min = new ArrayList<Integer>(); 
		for(int i=0;i<size();i++) {
			min.add(i);
			uso[i] = 0;
		}
		ArrayList<Integer> act = new ArrayList<Integer>();
		for(int x=0;x<Math.pow(2, size())-1;x++) {
			System.out.println(min);
			uso = sumadorUno(0, 1, uso);
			act.clear();
			System.out.println(min);
			for(int i=0;i<size();i++) {
				if(uso[i] == 1) {
					act.add(i);
				}
			}
			if(cubierto(act)) {
				if(act.size() < min.size()) {
					min = (ArrayList<Integer>) act.clone();
				}
			}
		}
		return min;
	}
	
	boolean cubierto(ArrayList<Integer> vertices) {
		boolean si = false;
		boolean[][] copia = new boolean[size()][size()];
		for(int i=0;i<size();i++)
			for(int j=0;j<size();j++)
				copia[i][j] = matriz[i][j];
				
		for(Integer vertice : vertices) {
			for(int i = 0;i<size();i++) {
				copia[vertice][i] = F;
				copia[i][vertice] = F;
			}
			si = true;
			for(int i=0;i<size();i++) {
				for(int j=0;j<size();j++) {
					if(copia[i][j] == V) {
						si = false;
					}
				}
			}
			if(si)
				return si;
		}

		for(int i=0;i<size();i++)
			for(int j=0;j<size();j++)
				copia[i][j] = matriz[i][j];
		
		return si;
	}
	
}
