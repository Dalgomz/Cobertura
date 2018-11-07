import java.util.ArrayList;

public class Main {

	public static final boolean F = false;
	public static final boolean V = true;
	public static void main(String[] args) {
		boolean[][] y = {
				{F,V,F,F,F,F,F},
				{V,F,V,F,F,F,F},
				{F,V,F,V,V,F,F},
				{F,F,V,F,V,V,F},
				{F,F,V,V,F,V,V},
				{F,F,F,V,V,F,F},
				{F,F,F,F,V,F,F}};
		Grafo g = new Grafo(y);
		ArrayList<Integer> aristas;
		for(int i=0;i<g.size();i++) {
			aristas = g.getAristas(i);
			System.out.println(i + " - " + aristas);	
		}
		
		System.out.println(g.fuerzaBruta().size());
	}

}
