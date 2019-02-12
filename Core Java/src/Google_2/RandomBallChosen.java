package Google_2;

import java.util.Random;

import practice.Practice;
/*
 * Given a box with N balls in it, each ball having a weight, randomly choose pick one out base on the weight. 
Input ball1-> 5kg, ball2 -> 10kg and ball3 -> 35kg, 
then Prob(ball1 chosen) = 10%, Prob(ball2) = 20%, 
Prob(ball3) = 70% ; 

Follow-up: 
Select a ball randomly based on weights. Once a ball is chosen, remove it. Next time select from the remaining balls.
Go on until there is nothing left in the box.
 */
public class RandomBallChosen 
{
	Random random = new Random();

    class Ball {
        public final int index;
        public final int weight;
        Ball(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    int[] chooseBalls(int[] weights) {
        int n = weights.length;
        int weightSum = 0;
        for (int i = 0; i < n; ++i) {
            weightSum += weights[i];
        }

        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; ++i) {
            balls[i] = new Ball(i, weights[i]);
        }

        int[] sequence = new int[n];
        chooseBalls(sequence, 0, balls, weights.length, weightSum);

        return sequence;
    }

    void chooseBalls(int[] sequence, int index, Ball[] balls, int n, int weightSum) 
    {
        if (n == 0) return;

        StringBuilder debug = new StringBuilder();
        debug.append("Debug: ");

        int x = random.nextInt(weightSum);
        debug.append("rand: " + x + ", ");

        Ball selected = null;
        for (int i = 0; i < n; ++i) {
            x -= balls[i].weight;
            if (x < 0) {
                debug.append("chosen: " + balls[i].index + ", weight: " + balls[i].weight);
                selected = balls[i];
                swap(balls, i, n - 1);
                break;
            }
        }

        System.out.println(debug);

        sequence[index] = selected.index;
        chooseBalls(sequence, index + 1, balls, n - 1, weightSum - selected.weight);
    }

    void swap(Ball[] balls, int i, int j) {
        Ball tmp = balls[i];
        balls[i] = balls[j];
        balls[j] = tmp;
    }

    public static void main(String[] args) {
    	RandomBallChosen rbe = new RandomBallChosen();
        int[] weights = {5, 10, 35};

        for (int t = 0; t < 1000; ++t)
        {
            int[] sequence = rbe.chooseBalls(weights);

            for (int i : sequence) {
                System.out.println(weights[i] + " ");
            }
            System.out.println();
        }

    }
}
