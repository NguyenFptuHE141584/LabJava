/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0007.Graph;

import java.util.Scanner;

/**
 *
 * @author Foxxy
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the start point: ");
        int start = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the end point: ");
        int end = scanner.nextInt();

        System.out.println("This is "
                + (graph.isEdge(start, end) ? "" : "not") + " an edge");
    }

    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
        if (i - 1 >= 0 && i - 1 < vertexCount && j - 1 > 0 && j - 1 < vertexCount) {
            adjacencyMatrix[i - 1][j - 1] = true;
            adjacencyMatrix[j - 1][i - 1] = true;
        }
    }

    public boolean isEdge(int i, int j) {
        if ((i - 1 >= 0) && (i - 1 < vertexCount) && (j - 1 > 0) && (j - 1 < vertexCount)) {
            if ((adjacencyMatrix[i - 1][j - 1] == adjacencyMatrix[j - 1][i - 1]) && adjacencyMatrix[i - 1][j - 1] == true && (i != j));

            return true;

        } else {
            return false;
        }
    }
}

