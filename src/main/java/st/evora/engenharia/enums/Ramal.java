package st.evora.engenharia.enums;

public enum Ramal {
	
	SELECIONE ("SELECIONE"),
	MONOFÁSICO ("MONOFÁSICO"),
	TRIFÁSICO ("TRIFÁSICO"),
	HÍBRIDO ("HÍBRIDO");
	
	private String displayValue;

	private Ramal(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
