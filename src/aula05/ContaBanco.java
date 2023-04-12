package aula05;

public class ContaBanco {

	public int numConta;
	protected String tipo;
	private String dono;
	private float saldo;
	private boolean status;

	public void estadoAtual() {
		System.out.println("---------------------------------------");
		System.out.println("Conta: " + this.getNumConta());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Dono: " + this.getDono());
		System.out.println("Saldo: " + this.getSaldo());
		System.out.println("Status: " + this.isStatus());
	}

	public void abrirConta(String t) {
		if (!this.isStatus()) {
			this.setTipo(t);
			this.setStatus(true);
			if (this.getTipo().equals("CC")) {
				this.setSaldo(50);
			} else if (this.getTipo().equals("CP")) {
				this.setSaldo(150);
			}
		} else {
			System.out.println("Já existe uma conta aberta");
		}
	}

	public void fecharConta() {
		if (this.isStatus()) {
			if (this.getSaldo() > 0) {
				System.out.println("A conta tem o saldo de R$" + this.getSaldo() + " , faça o saque primeiro");
			} else if (this.getSaldo() < 0) {
				System.out.println(
						"A conta está em débito, primeiro pague o débito pendente para solicar o fechamento da conta");
			} else {
				this.setStatus(false);
				System.out.println("Conta de " + this.getDono() + " fechada com sucesso!");
			}
		} else {
			System.out.println("Não existe uma conta para fechar");
		}
	}

	public void depositar(float v) {
		if (this.isStatus()) {
			this.setSaldo(getSaldo() + v);
			System.out.println("Depósito realizado na conta de " + this.getDono());
		} else {
			System.out.println("Não existe uma conta para depositar");
		}
	}

	public void sacar(float v) {
		if (this.isStatus()) {
			if (v <= this.getSaldo()) {
				this.setSaldo(this.getSaldo() - v);
				System.out.println("Saque realizado na conta de " + this.getDono());
			} else {
				System.out.println("Saldo insuficiente, consulte o seu saldo");
			}
		} else {
			System.out.println("Não existe uma conta para fazer saque");
		}
	}

	public void pagarMensal() {
		float v = 0;
		if (this.getTipo().equals("cc")) {
			v = 12;
		} else if (this.getTipo().equals("cp")) {
			v = 20;
		}
		if (this.isStatus()) {
			if (this.getSaldo() > v) {
				this.setSaldo(this.getSaldo() - v);
			} else {
				System.out.println("Saldo insuficiente, consulte o seu saldo");
			}
		} else {
			System.out.println("Não foi possível localizar a conta para fazer o pagamento, tente novamente");
		}
	}

	public ContaBanco() {
		this.setStatus(false);
		this.setSaldo(0);
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
