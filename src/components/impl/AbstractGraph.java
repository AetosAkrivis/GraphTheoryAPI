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
 * @author Imad Youbi Idrissi
 *
 */
public abstract class AbstractGraph implements Graph {
	// TODO : Sort the connecionLists by weight, sort the VertexSet by
	// alphabetical order, sort vertexDegrees by vertex alphabetical order (same
	// as VertexSet)

	private String name;
	private List<Connection> connectionList;
	private int m;
	private Set<Vertex> vertexSet;
	private int n;
	private Map<Vertex, Integer> vertexDegree;

	/**
	 * Initiates the vertexSet field. Has to be called <b>after</b> initiating
	 * the connectionList
	 */
	private void initVertices() {

		if (this.connectionList == null) {
			throw new RuntimeException("Can't initiate a list of vertices without having a connection list.");
		}

		this.vertexSet = new HashSet<>();
		Iterator<Connection> itConnection1 = this.connectionList.iterator();

		while (itConnection1.hasNext()) {
			Connection e = itConnection1.next();

			Vertex v1 = e.getEndPoints()[0];
			Vertex v2 = e.getEndPoints()[1];
			vertexSet.add(v1);
			vertexSet.add(v2);
		}

		// Field n: Number of vertices
		this.n = this.vertexSet.size();
	}

	/**
	 * Initiates the degree of each vertex. Has to be called <b>after</b>
	 * initiating the vertexSet
	 */
	private void initVertexDegree() {
		if (this.vertexSet == null) {
			throw new RuntimeException("Can't initiate the degrees of vertices without having a vertex set.");
		}
		// Once the map of vertices is populated, we will iterate on its keys,
		// verifying if the
		// key exists in each edge, once we find a vertex in an edge, we
		// increment the value of the key in the map

		Iterator<Vertex> itVertex = this.vertexSet.iterator();

		vertexDegree = new LinkedHashMap<>();

		while (itVertex.hasNext()) {
			Vertex v = itVertex.next();
			this.vertexDegree.putIfAbsent(v, 0);

			Iterator<Connection> itConnection2 = this.connectionList.iterator();

			while (itConnection2.hasNext()) {
				Connection e = itConnection2.next();

				// If this edge is a loop, then the degree of its vertex is 2.
				int inc = e.isLoop() ? 2 : 1;

				if (v.equals(e.getEndPoints()[0]) || v.equals(e.getEndPoints()[1])) {
					// Increment the value (count) of the Key element (in this
					// case key = vertex)
					this.vertexDegree.put(v, this.vertexDegree.get(v) + inc);
				}
			}
		}
	}

	/**
	 * Convert a variable number, or an array of connections into a list of
	 * connections
	 * 
	 * @param connections
	 *            A variable number or an array of connections that consist of
	 *            vertices.
	 * @see components.Connections.java
	 */
	private static List<Connection> adaptToConnectionList(Connection... connections) {
		List<Connection> tmpConnectionList = new ArrayList<Connection>();

		for (Connection c : connections) {
			tmpConnectionList.add(c);
		}

		return tmpConnectionList;
	}

	/**
	 * Initiate a graph.
	 * 
	 * @param name
	 *            name of the graph.
	 * @param connectionList
	 *            list of connections between vertices.
	 */
	public AbstractGraph(String name, List<Connection> connectionList) {
		// Field name
		this.name = name;
		// Field connectionList
		this.connectionList = new ArrayList<>(connectionList);
		// Field m: Number of connections
		this.m = this.connectionList.size();

		// Field vertexSet, n
		initVertices();

		// Field vertexDegree
		initVertexDegree();

	}

	public AbstractGraph(String name, Connection... connections) {
		this(name, adaptToConnectionList(connections));
	}

	/**
	 * @return Name of this graph.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return A copy of the graph's connection list. Note: The connections in
	 *         the list are passed by reference.
	 */
	public List<Connection> getConnectionList() {
		return new ArrayList<Connection>(this.connectionList);
	}

	/**
	 * @return The number of connections in this graph.
	 */
	public int getM() {
		return this.m;
	}

	/**
	 * @return A copy of the graph's vertex set. Note: The vertices in the s are
	 *         passed by reference.
	 */
	public Set<Vertex> vertexSet() {
		return new HashSet<Vertex>(this.vertexSet);
	}

	/**
	 * @return The number of vertices
	 */
	public int getN() {
		return this.n;
	}

	/**
	 * @return A copy of the graph's vertexDegree map. Note: The vertices in the
	 *         map are passed by reference.
	 */
	public Map<Vertex, Integer> getVertexDegree() {
		return new LinkedHashMap<Vertex, Integer>(this.vertexDegree);
	}

	// TODO : Should the set lists be cloned?
	// TODO : See how to clone lists for the setters
	/**
	 * @param name
	 *            Set new name for this graph.
	 */
	protected void setName(String name) {
		this.name = name;
	}

	// TODO : revise these setters
	protected void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}

	protected void setM(int m) {
		this.m = m;
	}

	protected void setVertexSet(Set<Vertex> vertexSet) {
		this.vertexSet = vertexSet;
	}

	protected void setN(int n) {
		this.n = n;
	}

	protected void setVertexDegree(Map<Vertex, Integer> vertexDegree) {
		this.vertexDegree = vertexDegree;
	}

	// TODO: Move to UnorientedGraph
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vertices: ").append(this.vertexSet).append("\n");
		sb.append("Degrees of vertices:").append(this.vertexDegree).append("\n");
		sb.append("Connections:").append(this.connectionList).append("\n");
		return sb.toString();
	}

	@Override
	public abstract Object clone();

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(this instanceof Graph)) {
			return false;
		}
		/**
		 * This is a workaround, Initially wanted to use Graph interface instead
		 * of AbstractGraph class, but in this version of Java, it isn't
		 * possible to use protected or private in an interface
		 */
		AbstractGraph other = (AbstractGraph) obj;
		if (!(this.getName() == other.getName() && this.getConnectionList().equals(other.getConnectionList())
				&& this.getM() == other.getM() && this.getVertexSet().equals(other.getVertexSet())
				&& this.getN() == other.getN() && this.getVertexDegree().equals(other.getVertexDegree()))) {
			return false;
		}

		return true;
	}

	/**
	 * Tests if two graphs have the same layout. The labels of the vertices
	 * don't matter to verify the isomorphism of two graphs.
	 */
	public boolean isIsomorphic(Graph g) {
		List<Connection> graph1Connections = this.getConnectionList();
		List<Connection> graph2Connections = g.getConnectionList();

		Iterator<Connection> it1 = graph1Connections.iterator();
		Iterator<Connection> it2 = graph2Connections.iterator();

		if (!(graph1Connections.size() == graph2Connections.size())) {
			return false;
		}

		while (it1.hasNext() && it2.hasNext()) {
			if (!it1.next().isIsomorphic(it2.next())) {
				return false;
			}
		}
		return true;
	}

	// TODO: Function that verifies the existance of a vertex in this graph
	public boolean hasVertex(Vertex v) {
		Iterator<Vertex> it1 = this.vertexSet().iterator();
		while (it1.hasNext()) {
			if (it1.next().equals(v)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasVertex(String label){
		Vertex v = new GenericVertex(label);
		return this.hasVertex(v);
	}
	
	// TODO : HashCode
	@Override
	public int hashCode() {
		return 0;
	}

	// TODO : Should the adding removal be treated as a boolean function, or use
	// exceptions?
	// TODO : add/remove Connection
	/**
	 * Add a connection between two vertices that already exist in this graph.
	 * Should be implemented only in inheriting classes.
	 * 
	 * @param v1
	 *            A first vertex that already belongs to this graph.
	 * @param v2
	 *            A second vertex that already belongs to this graph.
	 * @param weight
	 *            The assigned weight to this connection.
	 * @return true, if the addition of the connection succeeds, false if it
	 *         fails.
	 */
	public abstract boolean addConnection(Vertex v1, Vertex v2, int weight);

	public abstract boolean addConnection(String labelV1, String labelV2, int weight);

	// {
	// Should verify the existance of the vertices v1 and v2 in the graph,
	// if(this.hasVertex(v1) && this.hasVertex(v2)){
	//
	// }
	// System.out.println("Connection successfully created.");
	// return false;
	// }
	/**
	 * Remove a connection between two vertices that already exist in this
	 * graph.
	 * 
	 * @param v1
	 *            First vertex.
	 * @param v2
	 *            Second vertex
	 * @param weight
	 *            the weight of the connection to be removed.
	 * @return true if the removal succeeds, false if it fails.
	 */
	public abstract boolean removeConnection(Vertex v1, Vertex v2, int weight);

	// Vertex shouldn't exist in the graph.
	public boolean addVertex(Vertex v) {
		if (this.hasVertex(v)) {
			System.out.println("Failed to add vertex." + v.toString() + " already exists in this graph.");
			return false;
		}

		this.vertexSet.add(v);
		System.out.println("Vertex " + v.toString() + " added succesfully.");
		return true;
	}
	
	public boolean addVertex(String label){
		Vertex v = new GenericVertex(label);
		return this.addVertex(v);
	}

	// Vertex should exist in the graph
	public boolean removeVertex(Vertex v) {
		if (!this.hasVertex(v)) {
			System.out.println("Failed to remove vertex." + v.toString() + " doesn't exist in actual graph.");
			return false;
		}
		this.vertexSet().remove(v);
		System.out.println("Vertex :" + v.toString() + " removed succesfully.");
		return true;
	}
	
	public boolean removeVertex(String label){
		Vertex v = new GenericVertex(label);
		return this.removeVertex(v);
	}
}
