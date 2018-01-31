package lintcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
    public interface NestedInteger{
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> list=new ArrayList<>();
        doFlatten(nestedList,list);
        return list;
    }
    public void doFlatten(List<NestedInteger> nestedList,List<Integer> list){
        if(nestedList != null){
            for(int i=0;i<nestedList.size();i++){
                if(nestedList.get(i).isInteger()){
                    list.add(nestedList.get(i).getInteger());
                }else{
                    doFlatten(nestedList.get(i).getList(),list);
                }
            }
        }
    }


}
