package aula06;

public class ControleRemoto implements Controlador {
	// Atributos
	private int volume;
	private boolean ligado;
	private boolean tocando;

	// Métodos especiais
	public ControleRemoto() {
		this.setVolume(50);
		this.setLigado(false);
		this.setTocando(false);
	}

	private int getVolume() {
		return volume;
	}

	private void setVolume(int volume) {
		this.volume = volume;
	}

	private boolean isLigado() {
		return ligado;
	}

	private void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	private boolean isTocando() {
		return tocando;
	}

	private void setTocando(boolean tocando) {
		this.tocando = tocando;
	}

	// Métodos abstratos
	@Override
	public void ligar() {
		this.setLigado(true);
	}

	@Override
	public void desligar() {
		this.setLigado(false);
	}

	@Override
	public void abrirMenu() {
		if (isLigado()) {
			System.out.println("----- MENU -----");
			System.out.println("Está ligado? " + this.isLigado());
			System.out.println("Está tocando? " + this.isTocando());
			System.out.print("Volume: " + this.getVolume());
			for (int i = 0; i < this.getVolume(); i += 10) {
				System.out.print("|");
			}
			System.out.println();
		} else {
			System.out.println("Não é possível mostrar Menu");
		}
	}

	@Override
	public void fecharMenu() {
		if (isLigado()) {
			System.out.println("Fechando Menu...");
		} else {
			System.out.println("Não é possível fechar Menu");
		}
	}

	@Override
	public void maisVolume() {
		if (this.isLigado()) {
			this.setVolume(this.getVolume() + 5);
		} else {
			System.out.println("Impossível aumentar volume");
		}
	}

	@Override
	public void menosVolume() {
		if (this.isLigado()) {
			this.setVolume(this.getVolume() - 5);
		} else {
			System.out.println("Impossível diminuir volume");
		}
	}

	@Override
	public void ligarMudo() {
		if (this.isLigado() && this.getVolume() > 0) {
			this.setVolume(0);
		} else {
			System.out.println("Não é possível mutar");
		}
	}

	@Override
	public void desligarMudo() {
		if (this.isLigado() && this.getVolume() == 0) {
			this.setVolume(50);
		} else {
			System.out.println("Não é possível desmutar");
		}
	}

	@Override
	public void play() {
		if (this.isLigado() && (!this.isTocando())) {
			this.setTocando(true);
		} else {
			System.out.println("Não é possível reproduzir");
		}
	}

	@Override
	public void pause() {
		if (this.isLigado() && this.isTocando()) {
			this.setTocando(false);
		} else {
			System.out.println("Não é possível pausar");
		}
	}

}
