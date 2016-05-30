package components.impl;

import components.Edge;
import components.Vertex;

public abstract class EdgeAbs implements Edge,Cloneable{
	private Vertex[] endPoints;

	public EdgeAbs(Vertex v1, Vertex v2){
		endPoints = new Vertex[2];
		endPoints[0]=v1;
		endPoints[1]=v2;
	}
	
	public EdgeAbs(Edge e){
		endPoints = new Vertex[2];
		endPoints[0] = e.getEndPoints()[0];
		endPoints[1] = e.getEndPoints()[1];
	}
	
	/**
	 * Will return a copy of the list 
	 */
	public Vertex[] getEndPoints(){
		Vertex[] other = new Vertex[2];
		other[0] = endPoints[0];
		other[1] = endPoints[1];
		
		return other;
	}
	
	public void setEndPoints(Vertex v1, Vertex v2){
		endPoints[0] = v1;
		endPoints[1] = v2;
	}

	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Edge))	{
			return false;
		}
		Edge other = (Edge) obj;
		if (endPoints[0] == null && endPoints[1]==null){
			if(other.getEndPoints()[0] != null && other.getEndPoints()[1] != null){
				return false;
			}
		} else if (!(endPoints[0].equals(other.getEndPoints()[0]) && endPoints[1].equals(other.getEndPoints()[1]))){
			return false;
		}
		return true;
		
	}
	public abstract Object clone();
	
	public boolean isLoop(){
		if (!(endPoints[0]== null && endPoints[1]==null)){
			return false;
		}
		if( !(endPoints[0].equals(endPoints[1])) ){
			return false;
		}
		return true;
	}
}
