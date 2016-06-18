package components;

public interface Connection {
	
	Vertex[] getEndPoints();
	void setEndPoints(Vertex v1, Vertex v2);
	void setEndPoints(Connection e);
	Double getWeight();
	void setWeight(Double w);
	boolean equals(Object obj);
	String toString();
	Object clone();
	boolean isLoop();
	boolean isIsomorphic(Connection c);
}
