package DSA_Diary.daily.d_2025_09_18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_TaskManager {

}

class TaskManager {

    // Task class
    static class Task {
        int userId, taskId, priority;

        Task(int u, int t, int p) {
            userId = u;
            taskId = t;
            priority = p;
        }
    }

    // Map to track latest task info by taskId
    private Map<Integer, Task> taskMap;

    // Max-Heap: higher priority first, if tie → higher taskId first
    private PriorityQueue<Task> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {

        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });

        // initialize with given tasks
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }

    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        maxHeap.offer(task);
    }

    public void edit(int taskId, int newPriority) {

        if (!taskMap.containsKey(taskId)) return;
        Task old = taskMap.get(taskId);
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        maxHeap.offer(updated); // lazy update
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy removal (heap still has stale task)

    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            if (taskMap.containsKey(top.taskId) && taskMap.get(top.taskId).priority == top.priority) {
                // valid task
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1; // no tasks
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */


/*
class TaskManager {
    static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) { userId = u; taskId = t; priority = p; }
    }

    private final Map<Integer, Task> taskMap;       // taskId -> current Task
    private final PriorityQueue<Task> maxHeap;      // lazy heap

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });

        if (tasks != null) {
            for (List<Integer> t : tasks) {
                // list format: [userId, taskId, priority]
                add(t.get(0), t.get(1), t.get(2));
            }
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        maxHeap.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task cur = taskMap.get(taskId);
        if (cur == null) return;            // guaranteed exists by problem, but safe
        Task updated = new Task(cur.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        maxHeap.offer(updated);             // lazy-update
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);             // lazy removal; heap may still contain stale entries
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            Task latest = taskMap.get(top.taskId);
            // Validate that this heap entry matches the current (latest) record exactly.
            if (latest != null
                && latest.priority == top.priority
                && latest.userId == top.userId) {
                // valid, execute it
                taskMap.remove(top.taskId);
                return top.userId;
            }
            // else stale entry -> skip and continue
        }
        return -1;
    }
}
 */