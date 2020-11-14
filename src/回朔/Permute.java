package 回朔;

import java.util.*;

public class Permute {

    List<List<Integer>> res=new LinkedList<>();

    List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track=new LinkedList<>();
        backtrack(nums,track);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if(track.size()==nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])) continue;;
            track.add(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }

    Set<String> result=new TreeSet<>();

    public String[] permute(String s){
        if(s==null) return new String[]{};
        boolean[] visited=new boolean[s.length()];
        process(s,"",visited);
        return result.toArray(new String[result.size()]);
    }

    private void process(String s, String letter, boolean[] visited) {
        if(s.length()==letter.length()){
            result.add(letter);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(visited[i]) continue;
            visited[i]=true;
            process(s,letter+String.valueOf(c),visited);
            visited[i]=false;
        }
    }


    public static void main(String[] args) {
        int[] nums={1,2,3};
        String[] strings=new Permute().permute("abc");
        for(String s:strings){
            System.out.println(s);
        }
    }

}
