package Trem;
import java.util.*;
public class Vagao {

	    private char identificador;
	    private String tipoCarga;
	    private int quantidade;

	    public Vagao(char identificador) {
	        this.identificador = identificador;
	        this.tipoCarga = "";
	        this.quantidade = 0;
	    }

	    // Getters e setters

	    public char getIdentificador() {
	        return identificador;
	    }

	    public String getTipoCarga() {
	        return tipoCarga;
	    }

	    public void setTipoCarga(String tipoCarga) {
	        this.tipoCarga = tipoCarga;
	    }

	    public int getQuantidade() {
	        return quantidade;
	    }

	    public void setQuantidade(int quantidade) {
	        this.quantidade = quantidade;
	    }
	}
	

