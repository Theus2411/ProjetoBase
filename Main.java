public class Main {
    public static void main(String[] args) {

        No ini = new No(0);
        ini.prox = ini;
        for (int v : new int[]{5, 1, 8, 3, 7}) ListasCirculares.insere_lcco(ini, v);
        System.out.print("Após inserções: ");
        ListasCirculares.imprime(ini);

        ListasCirculares.remove_llcc(ini, 3);
        System.out.print("Após remover 3: ");
        ListasCirculares.imprime(ini);

        ListasCirculares.remove_llcc(ini, 42);
        System.out.print("Remover 42 (inexistente): ");
        ListasCirculares.imprime(ini);

        NoD h = new NoD(0);
        NoD a = new NoD(1), b = new NoD(2), c = new NoD(3);
        h.prox = a; a.prox = b; b.prox = c; c.prox = h;
        h.ant = c;  c.ant = b;  b.ant = a;  a.ant = h;
        ListasCirculares.remove_ldlcc(b);
        System.out.print("Dupla circular após remover 2: ");
        for (NoD q = h.prox; q != h; q = q.prox) System.out.print(q.chave + " ");
        System.out.println();


        ListaDupla ld = new ListaDupla();
        ld.inserirFim(10);
        ld.inserirFim(20);
        ld.inserirInicio(5);
        ld.inserirPosicao(2, 15);
        System.out.print("ListaDupla: ");
        ld.percorrer();
        System.out.print("Inversa: ");
        ld.percorrerInverso();
        System.out.println("Buscar 15: " + (ld.buscar(15) != null));
        ld.remover(5);
        ld.remover(20);
        System.out.print("Após remover 5 e 20: ");
        ld.percorrer();
        System.out.println("Tamanho: " + ld.tamanho);


        ListaDupla o = new ListaDupla();
        for (int v : new int[]{7, 2, 9, 4, 1}) o.inserirOrdenado(v);
        System.out.print("Inserção ordenada: ");
        o.percorrer();

        ListaDupla men = new ListaDupla(), mai = new ListaDupla();
        Operacoes.particionar(o, 5, men, mai);
        System.out.print("Menores que 5: ");  men.percorrer();
        System.out.print("Maiores/iguais: "); mai.percorrer();

        System.out.print("Invertida: ");
        Operacoes.inverter(o).percorrer();

        ListaDupla l2 = new ListaDupla(), l3 = new ListaDupla();
        for (int v : new int[]{3, 4, 8}) l2.inserirFim(v);
        for (int v : new int[]{0, 7, 10}) l3.inserirFim(v);
        System.out.print("Mescla de 3 listas: ");
        Operacoes.mesclarVarias(o, l2, l3).percorrer();

        System.out.print("Interseção: ");
        Operacoes.intersecao(o, l2).percorrer();

        Operacoes.balanceLine(o, l2);

        System.out.println("{[()]} balanceado? " + Operacoes.parentesesBalanceados("{[()]}")); // true
        System.out.println("([)] balanceado? " + Operacoes.parentesesBalanceados("([)]"));     // false


        System.out.println("J(5, 2) = " + ListasCirculares.Josephus(5, 2));    // 3
        System.out.println("J(7, 3) = " + ListasCirculares.Josephus(7, 3));    // 4
        System.out.println("J(41, 3) = " + ListasCirculares.Josephus(41, 3));  // 31
    }
}
