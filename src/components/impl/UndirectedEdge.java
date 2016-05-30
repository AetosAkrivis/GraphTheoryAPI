package components.impl;

import components.Edge;
import components.Vertex;

public class UndirectedEdge extends EdgeAbs {

	public UndirectedEdge(Vertex v1, Vertex v2, Double... weight) {
		super(v1, v2, weight);
	}

	public UndirectedEdge() {
		super(new GenericVertex(), new GenericVertex());
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		Double weight = this.getWeight();
		
		String bar = this.getWeight() != 1 ?("--------"+weight+"--------"):("----------------");
		
		sb.append(this.getEndPoints()[0].toString());
		sb.append(bar);
		sb.append(this.getEndPoints()[1]);
		
		return sb.toString();
	}
	
	@Override
	public Object clone() {
		return new UndirectedEdge(this.getEndPoints()[0], this.getEndPoints()[1], this.getWeight());
	}

	public static void test() {
		Vertex v1 = new GenericVertex("A");
		Vertex v2 = new GenericVertex("B");
		Vertex v3 = new GenericVertex("C");
		Vertex v4 = new GenericVertex("D");

		Edge e1 = new UndirectedEdge(v1, v2,3.0);
		Edge e2 = new UndirectedEdge(v2, v3);
		Edge e3 = new UndirectedEdge(v3, v4);
		Edge e4 = new UndirectedEdge();

		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
	}

}
