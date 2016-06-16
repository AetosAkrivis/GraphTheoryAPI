package components.impl;

import components.Connection;
import components.Vertex;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class AbstractConnection implements Connection, Cloneable {
	private Vertex[] endPoints;
	private Double weight;

	public AbstractConnection(Vertex v1, Vertex v2, Double... weight) {
		endPoints = new Vertex[2];
		endPoints[0] = v1;
		endPoints[1] = v2;

		// If the weight has been entered as a parameter, We will use it in a
		// separate variable, otherwise it will be given the default value of 1
		Double w = weight.length > 0 ? weight[0] : 1;

		if (weight.length > 1) {
			throw new IllegalArgumentException(
					"There can only be 3 arguments: Vertex c1, Vertex v2, (Optional) double weight");
		}
		if (!(w instanceof Double)) {
			throw new IllegalArgumentException("Weight can only be of type Double (and its subtypes). E.g., 1.0, 5.2");
		}
		this.weight = w;
	}

	public Vertex[] getEndPoints() {
		Vertex[] other = new Vertex[2];
		other[0] = endPoints[0];
		other[1] = endPoints[1];

		return other;
	}

	public void setEndPoints(Vertex v1, Vertex v2) {
		endPoints[0] = v1;
		endPoints[1] = v2;
	}

	public void setEndPoints(Connection e) {
		setEndPoints(e.getEndPoints()[0], e.getEndPoints()[1]);
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Connection)) {
			return false;
		}
		Connection other = (Connection) obj;
		if (endPoints[0] == null && endPoints[1] == null) {
			if (other.getEndPoints()[0] != null && other.getEndPoints()[1] != null) {
				return false;
			}
		} else if (!(endPoints[0].equals(other.getEndPoints()[0]) && endPoints[1].equals(other.getEndPoints()[1]))) {
			return false;
		}
		return true;

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(endPoints).append(weight).toHashCode();
	}

	@Override
	public abstract Object clone();

	/**
	 * If the (Directed or undirected) edge's source is its destination then it
	 * is a loop.
	 * 
	 * @return true if the edge is a loop, false otherwise.
	 */
	public boolean isLoop() {
		if (!(endPoints[0] != null && endPoints[1] != null)) {
			return false;
		}
		if (!(endPoints[0].equals(endPoints[1]))) {
			return false;
		}
		return true;
	}
}