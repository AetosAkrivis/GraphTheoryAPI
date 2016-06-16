package components.impl;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import components.Vertex;

public abstract class VertexAbs implements Vertex {
	private String label;

	public VertexAbs(String label) {
		this.label = label;
	}

	public VertexAbs() {
		this.label = "/";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[" + label + "]");
		return sb.toString();
	}

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
	public int hashCode(){
		return new HashCodeBuilder(17,37).append(label).toHashCode();
	}

	@Override
	public abstract Object clone();

}
