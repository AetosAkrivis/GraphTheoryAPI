package components.impl;

import components.Edge;
import components.Vertex;

/**
 * This class defines the use of Arcs in graph theory.
 * <ul>
 * <li>An arc being a connection between two vertices, with a direction (from
 * one vertex to another). It may have a value attached to it, called weight.
 * </li>
 * </ul>
 * 
 * @author Imad Youbi Idrissi
 * @see UndirectedEdge
 * @see GenericVertex
 */
public class Arc extends EdgeAbs {

	private int direction;

	/**
	 * Instantiate this Arc from a couple of vertices and a direction
	 * 
	 * @param v1
	 *            Vertex 1
	 * @param v2
	 *            Vertex 2
	 * @param direction
	 *            Describes the direction of the arc:
	 *            <ul>
	 *            <li>If direction is +1 then the arc goes from endPoint[0] to
	 *            endPoint[1]</li>
	 *            <li>If direction is -1 then the arc goes from endPoint[1] to
	 *            endPoint[0]</li>
	 *            </ul>
	 * @param weight(Optional)
	 *            A value associated to the arc, if it is not entered amongst
	 *            the parameters, will take the default value of 1.0.
	 */
	public Arc(Vertex v1, Vertex v2, int direction, Double... weight) {
		super(v1, v2, weight);
		if (!(direction == 1 || direction == -1)) {
			throw new IllegalArgumentException("Direction can only be designated with +1 or -1.");
		}
		this.direction = direction;
	}

	/**
	 * Instantiates an arc with default values:
	 * <li>Vertex1 labeled : \</li>
	 * <li>Vertex2 labeled : \</li>
	 * <li>Weight = 1.0</li>
	 * <li>Direction = +1</li>
	 */
	public Arc() {
		super(new GenericVertex(), new GenericVertex(), 1.0);
		this.direction = 1;
	}

	public int getDirection() {
		return this.direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Displays the arc (With directional arrow) and its weight (if it is
	 * different from 1.0).
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		double weight = this.getWeight();
		// Will add the display of weight if it is different from 1
		String bar = weight != 1 ? "--------" + weight + "--------" : "----------------";

		// Will display the direction of the arc
		if (direction != 1) {
			bar = "<" + bar;
		} else {
			bar += ">";
		}

		sb.append(this.getEndPoints()[0]);
		sb.append(bar);
		sb.append(this.getEndPoints()[1]);

		return sb.toString();
	}

	/**
	 * Creates a clone of the Arc, but keeps the reference to the vertices of
	 * the previous arc.
	 */
	@Override
	public Object clone() {
		return new Arc(this.getEndPoints()[0], this.getEndPoints()[1], this.getDirection());
	}

	/**
	 * Display and instantiation (Elemental) tests.
	 */
	public static void test() {
		Vertex v1 = new GenericVertex("A");
		Vertex v2 = new GenericVertex("B");
		Vertex v3 = new GenericVertex("C");
		Vertex v4 = new GenericVertex("D");

		Edge e1 = new Arc(v1, v2, 1, 3.0);
		Edge e2 = new Arc(v2, v3, -1);
		Edge e3 = new Arc(v3, v4, 1);
		Edge e4 = new Arc();

		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
	}

}
