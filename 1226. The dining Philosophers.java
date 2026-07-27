import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    // 5 locks representing the 5 forks
    private final Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Determine first and second fork to pick based on lower index
        int firstFork = Math.min(leftFork, rightFork);
        int secondFork = Math.max(leftFork, rightFork);

        // Lock both forks in order
        forks[firstFork].lock();
        forks[secondFork].lock();

        try {
            // Pick up left and right forks
            pickLeftFork.run();
            pickRightFork.run();

            // Eat
            eat.run();

            // Put down left and right forks
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Unlock in reverse order
            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }
    }
}
