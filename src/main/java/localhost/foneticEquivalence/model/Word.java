package localhost.foneticEquivalence.model;

public class Word {
	private String value;
	private String valueToCompare;
		
	public Word(String argument) {
		this.processValue(argument);
	}

	private void processValue(String argument) {
		 this.valueToCompare = argument.toLowerCase().replaceAll("[^a-z]", "");
		 //TODO Encontrar uma expressão regular para evitar esse subtring
		 String first = this.valueToCompare.substring(0, 1);
		 this.valueToCompare = this.valueToCompare.replaceAll("[a,e,i,h,o,u,w,y]+", "");	
		 this.valueToCompare = first + this.valueToCompare;
	}

	public String getValue() {
		return this.value;
	}
	
	public String getValueToCompare () {
		return this.valueToCompare;
	}
}
