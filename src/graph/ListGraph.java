package graph;

import java.util.ArrayList;

/**
 * 有向图的链表实现
 */
public class ListGraph {

    ArrayList<ArrayList<Integer>> graphs;

    //v是顶点数
    public ListGraph(int v){
        graphs=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            graphs.add(new ArrayList<>());
        }
    }

    /**
     * 添加边
     * @param start 起点
     * @param end 终点
     */
    public void addEdge(int start,int end){
        graphs.get(start).add(end);
    }

    public void removeEdge(int start,int end){
        graphs.get(start).remove((Integer)end);
    }

}
