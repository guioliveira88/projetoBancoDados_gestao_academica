package GestaoAcademica;

public class Universidade {
 
	private  String nome;
	    private static Universidade Instance;
	 
	    private Universidade() {
	    	
	    }
	    public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	 
	    public static  Universidade getInstance() {
	        if (Instance == null)
	            Instance = new Universidade();
	 
	        return Instance;
	    }
}