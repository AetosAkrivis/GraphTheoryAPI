package components.impl;

/**
 * A vertex is describe via a label, it can also be called a node.
 * @author imady
 * @see Arc
 * @see UndirectedEdge
 */
public class GenericVertex extends AbstractVertex {

	public GenericVertex(String label) {
		super(label);
	}
	
	/**
	 * Will instantiate a vertex with a default label "\"
	 */
	public GenericVertex(){
		super();
	}
	
	@Override
	public Object clone() {
		return new GenericVertex(this.getLabel());
	}

}
