public class Telefono

{
    
	private int pais=52;
    
	private int lada=982;
    
	private int numero=6612672;
    
	private String numCelular;
    
    

	public String toString(){
        
		numCelular="+"+pais+" "+lada+"-"+numero;
        
		return numCelular;
    
	}

}

