package components;

public interface Edge {
	
	Vertex[] getEndPoints();
	void setEndPoints(Vertex v1, Vertex v2);
	void setEndPoints(Edge e);
	boolean equals(Object obj);
	Object clone();
}
