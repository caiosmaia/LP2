package Trem;

import java.util.ArrayList;
import java.util.List;

public class Composicao {
	private List<Vagao> vagoes;

    public Composicao() {
        vagoes = new ArrayList<>();
    }

    public void adicionarVagao(Vagao vagao) {
        vagoes.add(vagao);
    }

    public void removerVagao(Vagao vagao) {
        vagoes.remove(vagao);
    }

    public List<Vagao> getVagoes() {
        return vagoes;
    }
}

