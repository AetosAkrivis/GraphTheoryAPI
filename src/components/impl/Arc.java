package components.impl;

import components.Edge;
import components.Vertex;

public class Arc extends EdgeAbs {

	private int direction;

	/**
	 * 
	 * @param e
	 *            Instantiate this Arc from a couple of vertices and a direction
	 * @param direction
	 *            Describes the direction of the arc:
	 *            <ul>
	 *            <li>If direction is +1 then the arc goes from endPoint[0] to
	 *            endPoint[1]</li>
	 *            <li>If direction is -1 then the arc goes from endPoint[1] to
	 *            endPoint[0]</li>
	 *            </ul>
	 */
	public Arc(Vertex v1, Vertex v2, int direction, Double... weight) {
		super(v1, v2, weight);
		if (!(direction == 1 || direction == -1)) {
			throw new IllegalArgumentException("Direction can only be designated with +1 or -1.");
		}
		this.direction = direction;
	}

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

	@Override
	public Object clone() {
		return new Arc(this.getEndPoints()[0], this.getEndPoints()[1], this.getDirection());
	}

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
