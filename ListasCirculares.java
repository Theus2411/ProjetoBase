
public class ListasCirculares {


    public static void remove_llcc(No ini, int k) {
        ini.chave = k;
        No p = ini;
        No q = ini.prox;
        while (q.chave != k) {
            p = q;
            q = q.prox;
        }
        if (q != ini) {
            p.prox = q.prox;
        }
    }


    public static void remove_ldlcc(NoD p) {
        p.ant.prox = p.prox;
        p.prox.ant = p.ant;
    }


    public static void insere_lcco(No ini, int k) {
        ini.chave = k;              // sentinela
        No p = ini;
        while (p.prox.chave < k) {
            p = p.prox;
        }
        No novo = new No(k);
        novo.prox = p.prox;
        p.prox = novo;
    }


    public static int Josephus(int N, int k) {
        No primeiro = new No(1);
        No p = primeiro;
        for (int i = 2; i <= N; i++) {
            p.prox = new No(i);
            p = p.prox;
        }
        p.prox = primeiro;

        while (p.prox != p) {
            for (int i = 1; i < k; i++) {
                p = p.prox;
            }
            p.prox = p.prox.prox;
        }
        return p.chave;
    }


    public static void imprime(No ini) {
        StringBuilder sb = new StringBuilder("[");
        for (No q = ini.prox; q != ini; q = q.prox) {
            sb.append(q.chave);
            if (q.prox != ini) sb.append(", ");
        }
        System.out.println(sb.append("]"));
    }
}
