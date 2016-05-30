package components.impl;

public class GenericVertex extends VertexAbs {

	public GenericVertex(String label) {
		super(label);
	}
	public GenericVertex(){
		super();
	}
	
	@Override
	public Object clone() {
		return new GenericVertex(this.getLabel());
	}

}
