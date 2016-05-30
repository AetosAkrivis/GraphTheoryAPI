package components;

public interface Vertex {
	
	String getLabel();
	void setLabel(String label);
	boolean equals(Object obj);
	String toString();
	Object clone();
	
}
