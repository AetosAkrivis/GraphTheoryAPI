package components.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import components.Edge;
import components.Graph;
import components.Vertex;

public class UnorientedGraph extends GraphAbs {

	public UnorientedGraph(String name, List<Edge> edgeSet) {
		super(name, edgeSet);
	}

	public static void test(){
		Vertex v1 = new GenericVertex("A");
		Vertex v2 = new GenericVertex("B");
		Vertex v3 = new GenericVertex("C");
		Vertex v4 = new GenericVertex("D");

		Edge e1 = new UndirectedEdge(v1, v2, 3.0);
		Edge e2 = new UndirectedEdge(v2, v3);
		Edge e3 = new UndirectedEdge(v3, v4);
		Edge e4 = new UndirectedEdge();
		Edge e5 = new UndirectedEdge(v1, v2);
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(e1);
		edgeList.add(e2);
		edgeList.add(e3);
		edgeList.add(e4);
		edgeList.add(e5);
		
		Graph g = new UnorientedGraph("G", edgeList);
		
//		System.out.println(e4.getEndPoints()[0].hashCode()+","+e4.getEndPoints()[1].hashCode());
//		System.out.println(e3.getEndPoints()[0].hashCode()+","+e3.getEndPoints()[1].hashCode());
	}
}
