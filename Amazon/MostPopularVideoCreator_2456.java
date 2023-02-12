import java.util.*;
class Pair{
    String name="";
    String id="";
    long view=0L;
    long maxi=0;
    Pair(String name,String id,int vi){
        this.name=name;
        this.id=id;
        view=vi;
        maxi=Math.max(maxi,vi); // to get to know whether the pariticular creator's id has the maximum view so as to get lexicographically smallest id.
    }
}
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String,Pair> map=new TreeMap<>();
        long max=0L;
   
        for(int i=0;i<creators.length;i++){
            if(!map.containsKey(creators[i])){
             Pair temp=new Pair(creators[i],ids[i],views[i]);
                map.put(creators[i],temp);
            }
            else{
                Pair temp=map.get(creators[i]);
               
                if(temp.maxi<views[i] || (temp.maxi==views[i] && ids[i].compareTo(temp.id)<0)){
                    temp.id=ids[i];
                    temp.maxi=views[i];
                }
                 temp.view=temp.view+views[i];
            }
            max=Math.max(max,map.get(creators[i]).view);
        }
       
        List<List<String>>res=new ArrayList<>();
        for(Map.Entry<String,Pair> en:map.entrySet()){
           if(en.getValue().view==max){
               List<String> ls=new ArrayList<>();
               ls.add(en.getKey());
               ls.add(en.getValue().id);
               res.add(new ArrayList<>(ls));
           }
        }

        return res;
        
        
    }
}