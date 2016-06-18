package components;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph extends Cloneable {

	boolean addVertex(Vertex v);

	boolean addVertex(String label);

	boolean removeVertex(Vertex v);

	boolean removeVertex(String label);

	String getName();

	List<Connection> getConnectionList();

	int getM();

	Set<Vertex> getVertexSet();

	int getN();

	Map<Vertex, Integer> getVertexDegree();

	boolean isIsomorphic(Graph g);

	// TODO: Once Java9 is out, declare the protected set methods in the
	// interface, and correct the equals in the AbstractGraph class
}
