package st.evora.engenharia.enums;

public enum Amperagem {
	
	SELECIONE ("SELECIONE"),
	A60 ("60 AMPERAGEM"),
	A80 ("80 AMPERAGEM"),
	A90 ("90 AMPERAGEM");
	
	private String displayValue;

	private Amperagem(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
