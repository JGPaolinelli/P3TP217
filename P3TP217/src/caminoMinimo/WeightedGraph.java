package caminoMinimo;

public class WeightedGraph {
	private int[][] edges; // adjacency matrix
	private Object[] labels;
	private boolean peajes[];

	public WeightedGraph(int n) {
		edges = new int[n][n];
		labels = new Object[n];
		peajes = new boolean[n];//MINE
	}

	public int size() {
		return labels.length;
	}

	public void setLabel(int vertex, Object label, boolean p) {
		labels[vertex] = label;
		this.peajes[vertex]= p;//MINE
	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}

	public void addEdge(int source, int target, int w) {
		edges[source][target] = w;
	}

	public boolean isEdge(int source, int target) {
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target) {
		edges[source][target] = 0;
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public void print() {
		for (int j = 0; j < edges.length; j++) {
			System.out.println("peaje: "+peajes[j]);//MINE
			System.out.print(labels[j] + ": ");
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.print(labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
		
	}

}
