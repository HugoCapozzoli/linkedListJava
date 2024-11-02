package linkedList;
public class Node {

	Produto produto;
	Node next;

	public Node(Produto produto) {
		this.produto = produto;
		this.next = null;
	}
	
	@Override
    public String toString() {
        return "Node{" +
               "Produto=" + produto +
               ", next=" + (next != null ? next.produto.getProduto() : "null") +
               '}';
    }
	
}
