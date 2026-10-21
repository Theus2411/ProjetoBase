
public class ListaDupla {
    NoD primeiro;
    NoD ultimo;
    int tamanho;

    public boolean vazia() {
        return primeiro == null;
    }

    public void inserirInicio(int k) {
        NoD novo = new NoD(k);
        if (vazia()) {
            primeiro = ultimo = novo;
        } else {
            novo.prox = primeiro;
            primeiro.ant = novo;
            primeiro = novo;
        }
        tamanho++;
    }

    public void inserirFim(int k) {
        NoD novo = new NoD(k);
        if (vazia()) {
            primeiro = ultimo = novo;
        } else {
            novo.ant = ultimo;
            ultimo.prox = novo;
            ultimo = novo;
        }
        tamanho++;
    }


    public boolean inserirPosicao(int pos, int k) {
        if (pos < 0 || pos > tamanho) return false;
        if (pos == 0) { inserirInicio(k); return true; }
        if (pos == tamanho) { inserirFim(k); return true; }
        NoD p = primeiro;
        for (int i = 0; i < pos; i++) p = p.prox;
        NoD novo = new NoD(k);
        novo.ant = p.ant;
        novo.prox = p;
        p.ant.prox = novo;
        p.ant = novo;
        tamanho++;
        return true;
    }


    public void inserirOrdenado(int k) {
        NoD p = primeiro;
        while (p != null && p.chave < k) p = p.prox;
        if (p == null) {
            inserirFim(k);
        } else if (p.ant == null) {
            inserirInicio(k);
        } else {
            NoD novo = new NoD(k);
            novo.ant = p.ant;
            novo.prox = p;
            p.ant.prox = novo;
            p.ant = novo;
            tamanho++;
        }
    }


    public NoD buscar(int k) {
        for (NoD p = primeiro; p != null; p = p.prox) {
            if (p.chave == k) return p;
        }
        return null;
    }


    public boolean remover(int k) {
        NoD p = buscar(k);
        if (p == null) return false;
        if (p.ant != null) p.ant.prox = p.prox; else primeiro = p.prox;
        if (p.prox != null) p.prox.ant = p.ant; else ultimo = p.ant;
        tamanho--;
        return true;
    }

    public void percorrer() {
        StringBuilder sb = new StringBuilder("[");
        for (NoD p = primeiro; p != null; p = p.prox) {
            sb.append(p.chave);
            if (p.prox != null) sb.append(", ");
        }
        System.out.println(sb.append("]"));
    }

    public void percorrerInverso() {
        StringBuilder sb = new StringBuilder("[");
        for (NoD p = ultimo; p != null; p = p.ant) {
            sb.append(p.chave);
            if (p.ant != null) sb.append(", ");
        }
        System.out.println(sb.append("]"));
    }
}
