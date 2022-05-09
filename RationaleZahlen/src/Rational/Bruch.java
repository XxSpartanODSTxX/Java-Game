/**
 * 
 */
package Rational;

/**
 * @author rupp
 *
 */
public class Bruch {

	int z; // Zähler
	int n; // Nenner
	
	public Bruch(int z, int n) {
		if(n<0) {
			n = -n;
			z = -z;
		}
		
		int g= ggT(Math.abs(z),n);
		this.z = z/g;
		this.n = n/g;
	}
	
	
	public String toString() {
		return "( " + z + " / " + n +" )";
	}
	
	/**
	 * Multiplikation von 2 Brüchen
	 * @param b Bruch mit dem multipliziert wird
	 * @return das Ergebnis der multiplikation als neuer Bruch
	 */
	public Bruch mul( Bruch b) {
	 return new Bruch(	z * b.z , n* b.n);
	}
	/**
	 * Division von 2 Brüchen
	 * @param b Bruch mit dem dividiert wird
	 * @return das Ergebnis der Division
	  */
	public Bruch div( Bruch b) {
	 return new Bruch(z* b.n, n * b.z );
	}
	
	
	/**
	 * Addition von 2 Brüchen
	 * @param b Bruch der addiert wird
	 * @return das Ergebnis der Addition als neuer Bruch
	 */
	public Bruch add( Bruch b) {
	 return new Bruch(	z * b.n + n* b.z , n*b.n);
	}
	
	/**
	 * Subtraktion von 2 Brüchen
	 * @param b Bruch der abgezogen wird
	 * @return das Ergebnis der Subtraktion als neuer Bruch
	 */
	public Bruch sub( Bruch b) {
	 return new Bruch(	z * b.n - n* b.z , n*b.n);
	}	
	/**
	 * Suche grössten gemeinsammer Teiler
	 * @return
	 */
	 int primT() {
		 int c=2;
		 int t=1;
		 while (c<=z && c<=n){
		  while(z % c ==0 && n % c ==0) {
			 z /= c;
			 n /= c;
			 t *= c;
		  }
		  c++;
	     }
		 return t;
	 }
	 
	 /** 
	  * euclidscher Algorithmus zum finden des ggT
	  * @return
	  */
	 int ggT(int a, int b) {
		 if(a==0)
			 return b;
		 else {
		 while(b != 0) {
			 if(a>b)
			    a = a-b;
			 else
				b = b-a;
		 }
		 }
	 return a;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bruch p1 = new Bruch(4,9);
		Bruch p2 = new Bruch(3,2);
		System.out.println(p1 +" * "+   p2  + " = " + p1.mul(p2));
		Bruch p3= p1.mul(p2);
		int z0= p3.primT();
		Bruch p4 = new Bruch (80, 320);
		int z1= p4.primT();
		System.out.println("GGT: " + z0 +" aus: " +p3);
		System.out.println("GGT: " + z1 +" aus: " +p4);
		Bruch p5 = new Bruch (2*5*7*7*11, 2*3*7*11);
		System.out.println(p5);
		//int z5= p5.primT();  // alternativer Aufruf
		int z5= p5.ggT(p5.z,p5.n);
		//p5.z /= z5;
		//p5.n /= z5;
		System.out.println("GGT: " + z5 +" aus: " +p5);
		
		System.out.println(p4 + " + " + p5 +" = " + p4.add(p5));
		
		System.out.println(p4 + " / " + p5 +" = " + p4.div(p5));
	
		System.out.println(p5 + " / ("+ p4 + "- " + p4 +") = " + p5.div(p4.sub(p4)));

	}
	
	

}
