package hash;

import java.util.HashMap;

/**
 * 设计一种结构，在该结构中有三个功能。
 *
 * insert(key)：将某个key加入到该结构中，不重复加入
 *
 * delete(key)：将原本在结构中的key删除
 *
 * getRandom()：等概率随机返回结构中的任何一个key
 *
 * 设计两个map，一个map存放的<key,value>是K，index  index代表第几个加入的
 *            另一个map存放的<key,value>是index，K
 */
public class RandomPool {

    public static class Pool<Key>{
        private HashMap<Key,Integer> keyIndexMap;
        private HashMap<Integer,Key> indexKeyMap;
        private int size;

        public Pool(){
            this.keyIndexMap=new HashMap<>();
            this.indexKeyMap=new HashMap<>();
            this.size=0;
        }

        public void insert(Key key){
            if(!this.keyIndexMap.containsKey(key)){ //如果不存在才加入
                this.keyIndexMap.put(key,this.size);
                this.indexKeyMap.put(this.size++,key);
            }
        }

        public void delete(Key key){
            if(this.keyIndexMap.containsKey(key)){ //如果存在才删除
                int deleteIndex=this.keyIndexMap.get(key);
                int lastIndex=--this.size;
                Key lastKey=this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.indexKeyMap.put(deleteIndex,lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }


        public Key getRandom(){
            if(this.size==0) return null;
            int randomIndex=(int)(Math.random()*this.size); //0-size-1
            return this.indexKeyMap.get(randomIndex);
        }

    }

}
