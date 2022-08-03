package n2exercici1;


	@FileDestinationAnnotation(Folder="C:\\Users\\sarag\\Desktop\\Cosas programacion\\Intinerari mentoritzat", FileName="jugador.json")
	public class Jugador {
		
		private int id;
		private String nom;
		private String cognoms;

		public Jugador(int id, String nom, String cognoms) {
			this.id = id;
			this.nom = nom;
			this.cognoms = cognoms;
		}

		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getCognoms() {
			return cognoms;
		}

		public void setCognoms(String cognoms) {
			this.cognoms = cognoms;
		}

		@Override
		public String toString() {
			return "Jugador [id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + "]";
		}

}
