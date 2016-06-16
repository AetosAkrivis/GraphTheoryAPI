package components;

public interface Connection {
	
	Vertex[] getEndPoints();
	void setEndPoints(Vertex v1, Vertex v2);
	void setEndPoints(Connection e);
	boolean equals(Object obj);
	String toString();
	Object clone();
	boolean isLoop();
}
