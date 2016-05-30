package components.impl;

import components.Vertex;

public abstract class VertexAbs implements Vertex{
	private String label;

	public VertexAbs(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("VertexAbs [label=" + label + "]");
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vertex)) {
			return false;
		}
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.getLabel() != null) {
				return false;
			}
		} else if (!label.equals(other.getLabel())) {
			return false;
		}
		return true;
	}
	
	@Override
	public abstract Object clone();
	
	
}
