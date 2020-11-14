package unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 *
 * 	小集合挂大集合
 * 	往上找的过程中沿途链变扁平
 * 	isSameSet & union的行为次数超过O(n)，则认为他们两个的时间复杂度为O(1)
 */
public class UnionFind {

    public static class Element<V>{
        private V value;
        public Element(V value){
            this.value=value;
        }
    }

    public static class UnionFindSet<V>{
        private HashMap<V,Element<V>> elementMap; //包装成点
        private HashMap<Element<V>,Element<V>> fatherMap;//每个点的父集合
        private HashMap<Element<V>,Integer> sizeMap;//每个集合的头节点

        public UnionFindSet(List<V> list){
            for(V value:list){
                Element<V> element=new Element<V>(value);
                elementMap.put(value,element);//将每个值注册进集合中
                fatherMap.put(element,element);//开始时每个集合的父节点就是指向自己
                sizeMap.put(element,1);
            }
        }

        /**
         * 从输入的参数出发，往上一直找，找到不能再往上的头节点再返回
         * 将所有沿途节点的父节点改为最上层的节点，即扁平化
         * @param element
         * @return
         */
        private Element<V> findHead(Element<V> element){
            Stack<Element<V>> path=new Stack<>();
            while(element!=(fatherMap.get(element))){
                path.add(element);
                element=fatherMap.get(element);
            }
            while(!path.isEmpty()){ //路径中的所有节点扁平化
                fatherMap.put(path.pop(),element);
            }
            return element;
        }

        //看两个点是否在一个集合中
        public boolean isSameSet(V a,V b){
            if(elementMap.containsKey(a) && elementMap.containsKey(b)){ //a、b都已经注册进并查集了
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        //合并两个集合
        public void union(V a,V b){
            if(elementMap.containsKey(a) && elementMap.containsKey(b)){
                Element<V> aF=findHead(elementMap.get(a));
                Element<V> bF=findHead(elementMap.get(b));
                if(aF!=bF){  //不在一个集合才合并
                    Element<V> big=sizeMap.get(aF)>=sizeMap.get(bF)?aF:bF;
                    Element<V> small= big==aF?bF:aF;
                    fatherMap.put(small,big);
                    sizeMap.put(big,sizeMap.get(aF)+sizeMap.get(bF));
                    sizeMap.remove(small);
                }
            }
        }
    }

}
