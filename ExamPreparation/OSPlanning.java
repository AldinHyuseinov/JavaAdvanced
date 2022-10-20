package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] taskArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> taskStack = new ArrayDeque<>();

        for (int task : taskArr) {
            taskStack.push(task);
        }

        int[] threadsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        for (int thread : threadsArr) {
            threadsQueue.offer(thread);
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (taskStack.peek() != taskToKill) {

            if (threadsQueue.peek() >= taskStack.peek()) {
                threadsQueue.poll();
                taskStack.pop();
            } else if (threadsQueue.peek() < taskStack.peek()) {
                threadsQueue.poll();
            }
        }

        System.out.println("Thread with value " + threadsQueue.peek() + " killed task " + taskToKill);

        while (!threadsQueue.isEmpty()) {
            System.out.print(threadsQueue.poll() + " ");
        }
    }
}
