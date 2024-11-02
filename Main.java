package linkedList;

public class Main {
    public static void main(String[] args) {
        // Criando a LinkedList de Produtos
        LinkedList lista = new LinkedList();

        Produto produto1 = new Produto(101, "Abacaxi");
        Produto produto2 = new Produto(102, "Limão");
        Produto produto3 = new Produto(103, "Perá");
        Produto produto4 = new Produto(104, "Banana");
        Produto produto5 = new Produto(105, "Alface");
        Produto produto6 = new Produto(106, "Laranja");
        Produto produto8 = new Produto(106, "Laranja");
        Produto produto7 = new Produto(107, "Cereja"); //deixar esse erro ele é necessario.

        System.out.println("Lista está vazia? " + lista.isEmpty());

        // Adicionar elementos à lista antes

        lista.adicionarOrdenado( produto1); 
        lista.adicionarOrdenado( produto2); 
        lista.adicionarOrdenado( produto3); 
        lista.adicionarOrdenado( produto4); 
        lista.adicionarOrdenado( produto5); 
        lista.adicionarOrdenado( produto6);
        lista.adicionarOrdenado( produto8);

        // Adicionar elementos à lista
        // Adiciona na posição 3
        // lista.adicionarNaPosicao(3, produto7); // Adiciona na posição específica

        // Exibir lista original
        System.out.println("\nLista Original:");
        for (int i = 0; i < lista.size; i++) {
            System.out.println(lista.get(i));
        }

        // Remover duplicados
        lista.removeDuplicates();
        System.out.println("\nLista sem duplicatas:");
        for (int i = 0; i < lista.size; i++) {
            System.out.println(lista.get(i));
        }

        // // Inverter a lista
        // lista.inverter();
        // System.out.println("\nLista Invertida:");
        // for (int i = 0; i < lista.size; i++) {
        //     System.out.println(lista.get(i));
        // }

        // // Obter o nó do meio
        // Node meio = lista.pegarNoMeio();
        // System.out.println("\nNó do Meio da Lista: " + (meio != null ? meio.produto : "Lista vazia"));

        // // Remover um elemento pelo valor
        // System.out.println("\nRemovendo 'Produto D' da lista...");
        // boolean removido = lista.removerElemento(produto4);
        // System.out.println("Remoção bem-sucedida? " + removido);

        // // Exibir lista final após todas as operações
        // System.out.println("\nLista Final:");
        // for (int i = 0; i < lista.size; i++) {
        //     System.out.println(lista.get(i));
        // }
    }
}
