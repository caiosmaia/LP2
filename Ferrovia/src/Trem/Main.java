package Trem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
		
		public static void main(String[] args) {
			SistemaGestao sistema = new SistemaGestao();

	        // Adicionar vagões nas composições
	        for (char ch = 'A'; ch <= 'M'; ch++) {
	            Vagao vagao = new Vagao(ch);
	            sistema.composicao1.adicionarVagao(vagao);
	        }

	        for (char ch = 'N'; ch <= 'Z'; ch++) {
	            Vagao vagao = new Vagao(ch);
	            sistema.composicao2.adicionarVagao(vagao);
	        }

	        // Testar as operações do sistema

	        // Embarcar produtos em um vagão
	        sistema.embarcarProduto('B', "Minério", 500);
	        sistema.embarcarProduto('G', "Grão", 1000);

	        // Desembarcar produto de um vagão
	        sistema.desembarcarProduto('B');

	        // Transferir um vagão de uma composição para outra
	        sistema.transferirVagao('K');

	        // Impedir operação de transferência em um vagão
	        Vagao vagao = new Vagao('C');
	        sistema.impedirOperacaoTransferencia(vagao);

	        // Consultar quantidade de desembarques por tipo de commodities
	        sistema.consultarDesembarques();

	        // Listar vagões nas composições
	        sistema.listarVagoesComposicao1();
	        sistema.listarVagoesComposicao2();
	    
	     // Escrever os dados em um arquivo
	        EscritorDados.escreverDadosEmArquivo(sistema);
	    }

	   
}
