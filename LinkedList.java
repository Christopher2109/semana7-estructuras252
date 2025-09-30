public class LinkedList {
    Node head;

    // Insertar al final
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Imprimir lista
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("/");
    }

    // Eliminar nodo por índice
    public Node delete(int index) {
        if (head == null) {
            return null;
        }

        // Caso especial: borrar la cabeza
        if (index == 0) {
            Node newHead = head.next;
            head.next = null;
            head = newHead;
            return head;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        // Avanzar hasta el índice
        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count++;
        }

        if (current != null) {
            previous.next = current.next;
            current.next = null;
        } else {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        return head;
    }
}
