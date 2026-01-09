package TaskTracker;

public class User {
    private String username;
    private Task[] taskArray=new Task[10];

    public User(String username){
        this.username=username;
    }
    public String getUserName(){
        return this.username;
    }
    public Task[] getTaskArray(){
        return this.taskArray;
    }
}
