import java.util.Iterator;

/**
 * TaskList has five data fields namely: all, active, completed, LOW_PRIORITY, HIGH PRIORITY.
 * @param <E>
 */
public class TaskList<E>{
    private ListQueue<E> all;
    private ListQueue<E> active;
    private ListQueue<E> completed;

    private static final int LOW_PRIORITY = Integer.MAX_VALUE;

    private static final int HIGH_PRIORITY = 1;


    /**
     * It Initializes all the ListQueues in the attributes.
     */
    public TaskList(){
        all = new ListQueue<E>();
        active = new ListQueue<E>();
        completed = new ListQueue<E>();
    }

    /**
     * CreateTask will add the item into active and all queues with default priority as LOW_PRIORITY
     * @param item
     */
    public boolean createTask(E item){
        if(item==null){
            return false;
        }
        else{
            all.offer(item, LOW_PRIORITY);
            active.offer(item, LOW_PRIORITY);
            return true;
        }
    }

    /**
     * It will add the item into active and all queues according to the priority sent to the method.
     * @param item
     * @param priority
     */

    public boolean createTask(E item, int priority){
        if(item==null){
            return false;
        }
        else{
            all.offer(item, priority);
            active.offer(item, priority);
            return true;
        }
    }

    /**
     * getter methods for all the list queues : all, completed and active.
     */
    public ListQueue<E> getActive() {
        return active;
    }

    public ListQueue<E> getAll() {
        return all;
    }

    public ListQueue<E> getCompleted() {
        return completed;
    }

    /**
     *  printTopThreeTask uses an iterator to iterate through the list and then prints the top 3 highest priority tasks.
     *  If there are less than three task, it prints all the task in the active queue.
     */
    public void printTopThreeTask(){
        Iterator<E> it= active.iterator();
        if(active.getSize() < 3){
            for(int i=1; i<= active.getSize(); i++){
                System.out.println(i + ". " + it.next());
            }
        }

        else{
            for(int i=1; i <= 3; i++){
                System.out.println(i + ". " + it.next());
            }
        }
    }

    /**
     * Helper method which uses an iterator to iterate through the queue elements and print them with numbers.
     * Front of the queue will have the task number 1 and each next node will have an increasing task number.
     * @param queue
     */
    private void printTask(ListQueue<E> queue){
        Iterator<E> it= queue.iterator();
        int i=1;
        while (it.hasNext()){
            System.out.println(i + ". " + it.next());
            i++;
        }
    }

    /**
     * showActiveTask(), showAllTask(), showCompletedTask() will call the helper method printTasks(ListQueue<E> queue) to print the tasks in the respective queues.
     */

    public void showActiveTask(){
        printTask(active);
    }

    public void showAllTask(){
        printTask(all);
    }

    public void showCompletedTask(){
        printTask(completed);
    }

    /**
     * crossOffMostUrgent() will remove the highest priority task from the front of the queue and returns true if it successfully removes else returns false.
     * The front of the active queue will get removed and will get stored in the completed queue.
     */
    public boolean crossOffMostUrgent(){
        if(active.getFront()==null){
            return false;
        }
        else{
            E item = active.peek();
            active.poll();
            completed.addRear(item);
            return true;
        }
    }

    /**
     * It removes the task at the location identified by taskNumber from the active queue and then adds it to the completed queue.
     * @param taskNumber
     * @return Returns true if the taskNumber is successfully removed from the active list. Otherwise, this method returns false.
     */
    public boolean crossOffTask(int taskNumber) {
        if (active.getFront() == null || taskNumber > active.getSize()) {
            return false;
        } else {
            ListQueue.Node<E> removed = active.getFront();
            for (int i = 1; i < taskNumber; i++) {
                removed = removed.getNext();
            }
            E removedTask = removed.getData();
            active.remove(removed);
            completed.addRear(removedTask);
            return true;
        }
    }

}
