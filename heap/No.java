
public class No {
    private No pai, filhoEsquerdo, filhoDireito;
    private int valor;

    

	public No(No pai, int valor) {
		this.pai = pai;
		this.valor = valor;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
	}
    
	public No getPai() {
		return pai;
	}
	public void setPai(No pai) {
		this.pai = pai;
	}
	public No getFilhoEsquerdo() {
		return filhoEsquerdo;
	}
	public void setFilhoEsquerdo(No filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	public No getFilhoDireito() {
		return filhoDireito;
	}
	public void setFilhoDireito(No filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

    
}