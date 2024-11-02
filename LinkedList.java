package linkedList;

import java.util.HashSet;

public class LinkedList {

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void adicionarOrdenado(Produto produto) {
        Node newNode = new Node(produto);

        // Caso a lista esteja vazia ou o novo produto deva ser o primeiro
        if (isEmpty() || head.produto.getId() >= produto.getId()) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode; // Se a lista estava vazia, atualiza o tail
            }
        } else {
            // Percorre a lista para encontrar a posição correta
            Node current = head;
            while (current.next != null && current.next.produto.getId() < produto.getId()) {
                current = current.next;
            }
            // Insere o novo nó na posição encontrada
            newNode.next = current.next;
            current.next = newNode;

            // Atualiza o tail se necessário
            if (newNode.next == null) {
                tail = newNode;
            }
        }
        size++; // Incrementa o tamanho da lista com o size assim da para ver o tamanho da bagaça
    }

    // Adicionar elemento em uma posição que nos desejar :D  - Complexidade: O(n) eu acho kkkkk
    public void adicionarNaPosicao(int index, Produto produto) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        // criando o nózinho :D
        Node newNode = new Node(produto);
        //aqui ele se trata para add no inicio na posição 0 ja q o indeex == 0 :3
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) { // aqui ele so ve se é o primeiro iten msm verifica se o tail for null 
                tail = newNode; // a aqui ele via apontar para o newNode
            }
        } else {
            Node aux = head; //aqui o aux vai percorrer a lista com o for ai abaixo :D
            for (int i = 0; i < index - 1; i++) {
                aux = aux.next; //o novo no deve ser apontado para o proximo nó da lista 
            }
            newNode.next = aux.next;
            aux.next = newNode;
            if (newNode.next == null) { //aqui verifica se ele foi add no final da lista se for ele irar receber o NewNode
                tail = newNode;
            }
        }
        size += 1;
    }

    // Remover um elemento 
    public boolean removerElemento(Produto produto) {
        Node aux = head;
        Node prev = null;

        while (aux != null) {
            if (aux.produto.equals(produto)) {
                if (prev == null) {
                    head = aux.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.next = aux.next;
                    if (aux.next == null) {
                        tail = prev;
                    }
                }
                size -= 1;
                return true;
            }
            prev = aux;
            aux = aux.next;
        }
        return false; // Elemento não encontrado
    }

    // Inverter a lista
    public void inverter() {
        if (isEmpty() || size == 1) {
            return;
        }

        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        tail = head;
        head = previous;
    }

    // Retornar o nó que está no meio da lista 
    public Node pegarNoMeio() {
        if (isEmpty()) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Remover nós duplicados
    public void removeDuplicates() {
        if (isEmpty() || size == 1) {
            System.out.println("A lista está vazia ou tem apenas um elemento. Nenhuma duplicata para remover.");
            return;
        }

        HashSet<Integer> seenIds = new HashSet<>(); // armazenar os IDs dos produtos
        Node aux = head;
        Node prev = null;

        // boolean temDuplicatas = false;

        while (aux != null) {
            // vai verificar se o id foi colocado na parada seila no conj
            if (seenIds.contains(aux.produto.getId())) {
                // Se já existe, remove o nó atual 
                prev.next = aux.next;
                size -= 1;
                // temDuplicatas = true;
                if (aux.next == null) {
                    tail = prev; // Atualiza o tail se necessário
                }
            } else {
                // Se não existe, adiciona o ID ao conjunto
                seenIds.add(aux.produto.getId());
                prev = aux; // Avança para o próximo nó 
            }
            aux = aux.next; // Avança para o próximo nó assim criando o infinito da alegria

            // Aviso sobre duplicatas tentativa para avisar se possui e se nao possui.
            // if (temDuplicatas) {
            //     System.out.println("Duplicatas removidas da lista.");
            // } else {
            //     System.out.println("Nenhuma duplicata encontrada na lista.");
            // }
        }
    }

    public Produto get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora do limite: " + index);
        }

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.produto;
    }

}
