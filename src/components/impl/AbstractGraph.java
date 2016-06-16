package components.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import components.Connection;
import components.Graph;
import components.Vertex;

/**
 * A graph is described by its name, and the couple (V(G),E(G)) of its vertices
 * and edges.
 * <p>
 * A graph can be:
 * </p>
 * <ul>
 * <li>oriented, in this case, the edges will be called Arcs.</li>
 * <li>unoriented</li>
 * <li>complete</li>
 * <li>simple</li>
 * </ul>
 * <p>
 * We can calculate/determine :
 * </p>
 * <ul>
 * <li>if a graph has multiple edges</li>
 * <li>if a graph has loops (edges)</li>
 * <li>the order of a graph (number of vertices)</li>
 * <li>the adjacent vertices to a particular vertex</li>
 * <li></li>
 * </ul>
 * 
 * @author imady
 *
 */
public abstract class AbstractGraph implements Graph{

	private String name;
	private Set<Vertex> vertexSet;
	private List<Connection> connectionList;
	private int n;
	private int m;
	private Map<Vertex, Integer> degreeOfVertex;

	public AbstractGraph(String name, List<Connection> edgeList) {
		//Field name
		this.name = name;
		//Field edgeList
		this.connectionList = new ArrayList<>(edgeList);
		//Field vertexSet
		this.vertexSet = new HashSet<>();
		// Calculating the vertices

		Iterator<Connection> itConnection1 = this.connectionList.iterator();

		while (itConnection1.hasNext()) {
			Connection e = itConnection1.next();
			
			Vertex v1 = e.getEndPoints()[0];
			Vertex v2 = e.getEndPoints()[1];
			vertexSet.add(v1);
			vertexSet.add(v2);
		}

		//Field n
		this.n = this.vertexSet.size();
		//Field m
		this.m = this.connectionList.size();

		//Field degreeOfVertex
		
		// Populate the map with the vertices
		// Once the map populated, we will iterate on its keys, verifying if the
		// key exists in each edge, once we find a vertex in an edge, we
		// increment the value of the key in the map

		Iterator<Vertex> itVertex = this.vertexSet.iterator();

		degreeOfVertex = new LinkedHashMap<>();

		while (itVertex.hasNext()) {
			Vertex v = itVertex.next();
			this.degreeOfVertex.putIfAbsent(v, 0);

			Iterator<Connection> itConnection2 = this.connectionList.iterator();
			
			while (itConnection2.hasNext()) {
				Connection e = itConnection2.next();

				//If this edge is a loop, then the degree of its vertex is 2.
				int inc = e.isLoop()?2:1;
				
				if (v.equals(e.getEndPoints()[0]) || v.equals(e.getEndPoints()[1])) {
					//Increment the value (count) of the Key element (in this case key = vertex)
					this.degreeOfVertex.put(v, this.degreeOfVertex.get(v)+inc);
				}
			}
		}
		
		System.out.println("Vertices:"+this.vertexSet);
		System.out.println("Degrees of vertices:"+this.degreeOfVertex);
		System.out.println("Connections:"+this.connectionList);

	}

}
