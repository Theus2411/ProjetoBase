
public class Operacoes {


    public static void particionar(ListaDupla l, int pivo, ListaDupla menores, ListaDupla maiores) {
        for (NoD p = l.primeiro; p != null; p = p.prox) {
            if (p.chave < pivo) menores.inserirFim(p.chave);
            else maiores.inserirFim(p.chave);
        }
    }


    public static ListaDupla inverter(ListaDupla l) {
        Pilha pilha = new Pilha();
        for (NoD p = l.primeiro; p != null; p = p.prox) pilha.push(p.chave);
        ListaDupla inv = new ListaDupla();
        while (!pilha.vazia()) inv.inserirFim(pilha.pop());
        return inv;
    }


    public static ListaDupla mesclar(ListaDupla a, ListaDupla b) {
        ListaDupla r = new ListaDupla();
        NoD p = a.primeiro, q = b.primeiro;
        while (p != null && q != null) {
            if (p.chave <= q.chave) { r.inserirFim(p.chave); p = p.prox; }
            else { r.inserirFim(q.chave); q = q.prox; }
        }
        for (; p != null; p = p.prox) r.inserirFim(p.chave);
        for (; q != null; q = q.prox) r.inserirFim(q.chave);
        return r;
    }


    public static ListaDupla mesclarVarias(ListaDupla... listas) {
        ListaDupla r = new ListaDupla();
        for (ListaDupla l : listas) r = mesclar(r, l);
        return r;
    }


    public static ListaDupla intersecao(ListaDupla a, ListaDupla b) {
        ListaDupla r = new ListaDupla();
        for (NoD p = a.primeiro; p != null; p = p.prox) {
            if (b.buscar(p.chave) != null && r.buscar(p.chave) == null) {
                r.inserirFim(p.chave);
            }
        }
        return r;
    }


    public static void balanceLine(ListaDupla a, ListaDupla b) {
        ListaDupla soA = new ListaDupla(), soB = new ListaDupla(), ambas = new ListaDupla();
        NoD p = a.primeiro, q = b.primeiro;
        while (p != null && q != null) {
            if (p.chave == q.chave) { ambas.inserirFim(p.chave); p = p.prox; q = q.prox; }
            else if (p.chave < q.chave) { soA.inserirFim(p.chave); p = p.prox; }
            else { soB.inserirFim(q.chave); q = q.prox; }
        }
        for (; p != null; p = p.prox) soA.inserirFim(p.chave);
        for (; q != null; q = q.prox) soB.inserirFim(q.chave);
        System.out.print("Só em A: ");  soA.percorrer();
        System.out.print("Só em B: ");  soB.percorrer();
        System.out.print("Em ambas: "); ambas.percorrer();
    }


    public static boolean parentesesBalanceados(String s) {
        Pilha pilha = new Pilha();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.vazia()) return false;
                char t = (char) pilha.pop();
                if ((c == ')' && t != '(') || (c == ']' && t != '[') || (c == '}' && t != '{'))
                    return false;
            }
        }
        return pilha.vazia();
    }
}
