package Trem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
		
		public static void main(String[] args) {
			SistemaGestao sistema = new SistemaGestao();

	        // Adicionar vag�es nas composi��es
	        for (char ch = 'A'; ch <= 'M'; ch++) {
	            Vagao vagao = new Vagao(ch);
	            sistema.composicao1.adicionarVagao(vagao);
	        }

	        for (char ch = 'N'; ch <= 'Z'; ch++) {
	            Vagao vagao = new Vagao(ch);
	            sistema.composicao2.adicionarVagao(vagao);
	        }

	        // Testar as opera��es do sistema

	        // Embarcar produtos em um vag�o
	        sistema.embarcarProduto('B', "Min�rio", 500);
	        sistema.embarcarProduto('G', "Gr�o", 1000);

	        // Desembarcar produto de um vag�o
	        sistema.desembarcarProduto('B');

	        // Transferir um vag�o de uma composi��o para outra
	        sistema.transferirVagao('K');

	        // Impedir opera��o de transfer�ncia em um vag�o
	        Vagao vagao = new Vagao('C');
	        sistema.impedirOperacaoTransferencia(vagao);

	        // Consultar quantidade de desembarques por tipo de commodities
	        sistema.consultarDesembarques();

	        // Listar vag�es nas composi��es
	        sistema.listarVagoesComposicao1();
	        sistema.listarVagoesComposicao2();
	    
	     // Escrever os dados em um arquivo
	        EscritorDados.escreverDadosEmArquivo(sistema);
	    }

	   
}
