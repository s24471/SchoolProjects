package utp7_2;

public class StringTask implements Runnable{
    private String txt;
    private String result;
    private int n;
    private int curr;
    private TaskState state;
    public StringTask(String txt, int n) {
        this.txt = txt;
        this.n = n;
        curr=0;
        state = TaskState.CREATED;
        result = "";
    }


    public String getTxt(){
        return txt;
    }
    public String getResult(){
        return result;
    }
    public TaskState getState(){
        return state;
    }
    public void start(){
        Thread t = new Thread(this);
        state = TaskState.RUNNING;
        t.start();
    }
    public void abort(){
        state = TaskState.ABORTED;
    }
    public boolean isDone(){
        if(state == TaskState.READY || state == TaskState.ABORTED)return true;
        return false;
    }
    @Override
    public void run() {
        while(state == TaskState.RUNNING){
            for (int i = 0; i < txt.length(); i++) {
                result +=txt.charAt(txt.length()-i-1);
            }
            curr++;
            if(curr>=n) {
                state = TaskState.READY;
                return;
            }
        }
    }
}
