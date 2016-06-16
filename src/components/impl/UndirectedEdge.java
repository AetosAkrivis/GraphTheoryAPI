package components.impl;

import components.Edge;
import components.Vertex;

/**
 * This class defines the use of edges (undirected) in graph theory.
 * <ul>
 * <li>An edge being an undirected connection between two vertices. May have a
 * value attached to it, called weight.</li>
 * </ul>
 * 
 * @author Imad Youbi Idrissi
 * @see Arc
 * @see GenericVertex
 *
 */
public class UndirectedEdge extends EdgeAbs {

	/**
	 * Instantiate this Edge from a couple of vertices.
	 * 
	 * @param v1
	 *            Vertex 1
	 * @param v2
	 *            Vertex 2
	 * @param weight(Optional)
	 *            A value associated to the Edge, if it is not entered amongst
	 *            the parameters, will take the default value of 1.0.
	 */
	public UndirectedEdge(Vertex v1, Vertex v2, Double... weight) {
		super(v1, v2, weight);
	}

	/**
	 * Instantiates an edge with default values:
	 * <ul>
	 * <li>Vertex1 labeled : \</li>
	 * <li>Vertex2 labeled : \</li>
	 * <li>Weight = 1.0</li>
	 * </ul>
	 */
	public UndirectedEdge() {
		super(new GenericVertex(), new GenericVertex());
	}

	/**
	 * Displays the edge, with its weight (if it is different from 1.0)
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Double weight = this.getWeight();

		String bar = this.getWeight() != 1 ? ("--------" + weight + "--------") : ("----------------");

		sb.append(this.getEndPoints()[0].toString());
		sb.append(bar);
		sb.append(this.getEndPoints()[1]);

		return sb.toString();
	}

	@Override
	public Object clone() {
		return new UndirectedEdge(this.getEndPoints()[0], this.getEndPoints()[1], this.getWeight());
	}

	/**
	 * Display and instantiation (Elemental) tests.
	 */
	public static void test() {
		Vertex v1 = new GenericVertex("A");
		Vertex v2 = new GenericVertex("B");
		Vertex v3 = new GenericVertex("C");
		Vertex v4 = new GenericVertex("D");

		Edge e1 = new UndirectedEdge(v1, v2, 3.0);
		Edge e2 = new UndirectedEdge(v2, v3);
		Edge e3 = new UndirectedEdge(v3, v4);
		Edge e4 = new UndirectedEdge();


		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
	}

}
