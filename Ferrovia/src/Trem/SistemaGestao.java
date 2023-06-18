package Trem;

public class SistemaGestao {

	Composicao composicao1;
    Composicao composicao2;
    int desembarquesR1;
    int desembarquesR2;

    public SistemaGestao() {
        composicao1 = new Composicao();
        composicao2 = new Composicao();
        desembarquesR1 = 0;
        desembarquesR2 = 0;
    }
    
    public void embarcarProduto(char identificador, String tipoCarga, int quantidade) {
        Vagao vagao = encontrarVagao(identificador);
        if (vagao != null) {
            vagao.setTipoCarga(tipoCarga);
            vagao.setQuantidade(quantidade);
            System.out.println("Produto embarcado com sucesso no vagão " + vagao.getIdentificador());
        } else {
            System.out.println("Vagão não encontrado!");
        }
    }

    public void desembarcarProduto(char identificador) {
    	Vagao vagao = encontrarVagao(identificador);
        if (vagao != null) {
            String tipoCarga = vagao.getTipoCarga();
            vagao.setTipoCarga("");
            vagao.setQuantidade(0);
            System.out.println("Produto desembarcado do vagão " + vagao.getIdentificador());
            
            // Atualizar contagem de desembarques por tipo de commodities
            if (tipoCarga.equals("Minerio") && vagao.getQuantidade() > 0) {
                desembarquesR1++;
            } else if (tipoCarga.equals("Grao") && vagao.getQuantidade() > 0) {
                desembarquesR2++;
            }
        } else {
            System.out.println("Vagão não encontrado!");
        }
    }

    public void transferirVagao(char identificador) {
    	Vagao vagao = encontrarVagao(identificador);
        if (vagao != null) {
            Composicao composicaoAtual = encontrarComposicao(vagao);
            if (composicaoAtual != null) {
                if (composicaoAtual.equals(composicao1)) {
                    composicao1.removerVagao(vagao);
                    composicao2.adicionarVagao(vagao);
                    System.out.println("Vagão " + vagao.getIdentificador() + " transferido para a composição 2");
                } else {
                    composicao2.removerVagao(vagao);
                    composicao1.adicionarVagao(vagao);
                    System.out.println("Vagão " + vagao.getIdentificador() + " transferido para a composição 1");
                }
            } else {
                System.out.println("Vagão não encontrado na composição!");
            }
        } else {
            System.out.println("Vagão não encontrado!");
        }
    }

    // Métodos auxiliares

    private Vagao encontrarVagao(char identificador) {
        for (Vagao vagao : composicao1.getVagoes()) {
            if (vagao.getIdentificador() == identificador) {
                return vagao;
            }
        }
        for (Vagao vagao : composicao2.getVagoes()) {
            if (vagao.getIdentificador() == identificador) {
                return vagao;
            }
        }
        return null;
    }
    
    public void impedirOperacaoTransferencia(Vagao vagao) {
        Composicao composicaoAtual = encontrarComposicao(vagao);
        if (composicaoAtual != null) {
            System.out.println("Operação de transferência do vagão " + vagao.getIdentificador() + " impedida, pois o vagão está em uma composição em posição de carga/descarga ou em movimento");
        } else {
            System.out.println("Vagão não encontrado na composição!");
        }
    }

    public void consultarDesembarques() {
        System.out.println("Quantidade de desembarques por tipo de commodities:");
        System.out.println("Região R1 (Minérios): " + desembarquesR1);
        System.out.println("Região R2 (Grãos): " + desembarquesR2);
    }

    public void listarVagoesComposicao1() {
        System.out.println("Vagões na composição 1:");
        for (Vagao vagao : composicao1.getVagoes()) {
            System.out.println("Identificador: " + vagao.getIdentificador());
            System.out.println("Tipo de Carga: " + vagao.getTipoCarga());
            System.out.println("Quantidade: " + vagao.getQuantidade());
            System.out.println("---------------------------");
        }
    }

    public void listarVagoesComposicao2() {
        System.out.println("Vagões na composição 2:");
        for (Vagao vagao : composicao2.getVagoes()) {
            System.out.println("Identificador: " + vagao.getIdentificador());
            System.out.println("Tipo de Carga: " + vagao.getTipoCarga());
            System.out.println("Quantidade: " + vagao.getQuantidade());
            System.out.println("---------------------------");
        }
    }

    private Composicao encontrarComposicao(Vagao vagao) {
        if (composicao1.getVagoes().contains(vagao)) {
            return composicao1;
        }
        if (composicao2.getVagoes().contains(vagao)) {
            return composicao2;
        }
        return null;
    }
}

    

