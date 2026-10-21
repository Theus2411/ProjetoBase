
public class Pilha {
    private No topo;

    public void push(int x) {
        No n = new No(x);
        n.prox = topo;
        topo = n;
    }

    public int pop() {
        int x = topo.chave;
        topo = topo.prox;
        return x;
    }

    public boolean vazia() {
        return topo == null;
    }
}
