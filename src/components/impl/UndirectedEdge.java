package components.impl;

import components.Edge;
import components.Vertex;

public abstract class UndirectedEdge extends EdgeAbs {

	public UndirectedEdge(Edge e) {
		super(e);
	}
	public UndirectedEdge(Vertex v1, Vertex v2){
		super(v1,v2);
	}
	
	public static void test(){
	}
}
