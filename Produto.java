package linkedList;

public class Produto {
	
	private int id;
	private String produto;
	
	public Produto(int id, String nome) {
		this.id = id;
		this.produto = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduto(String nome) {
		this.produto = nome;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome do produto=" + produto + "]";
	}
	
	public String getProduto() {
		return "ID: " + id + ", Nome: " + produto;
	 }
}
