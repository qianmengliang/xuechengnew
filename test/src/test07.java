import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能
 */
public class test07 {
    public static class MList<T>{
        private Stack<T> stack1 = new Stack<T>();
        private Stack<T> stack2 = new Stack<T>();
        //1.先往栈里放数据
        public void pushStack1(T t){
            stack1.add(t);
        }

        public T delete(){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if(stack2.isEmpty()){
                throw new RuntimeException("11");
            }
            return stack2.pop();
        }
    }


    public static void main(String[] args) {
        MList mList = new MList();
        mList.pushStack1("a");
        mList.pushStack1("b");
        mList.pushStack1("c");
        System.out.println(mList.delete());
    }
}