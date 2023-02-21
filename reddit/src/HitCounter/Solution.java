package HitCounter;/*
Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).

Your system should accept a timestamp parameter (in seconds granularity), and you may assume that calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing). Several hits may arrive roughly at the same time.

Implement the HitCounter.HitCounter class:

HitCounter.HitCounter() Initializes the object of the hit counter system.
void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).
 

Example 1:

Input
["HitCounter.HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
[[], [1], [2], [3], [4], [300], [300], [301]]
Output
[null, null, null, null, 3, null, 4, 3]

Explanation
HitCounter.HitCounter hitCounter = new HitCounter.HitCounter();
hitCounter.hit(1);       // hit at timestamp 1.
hitCounter.hit(2);       // hit at timestamp 2.
hitCounter.hit(3);       // hit at timestamp 3.
hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
hitCounter.hit(300);     // hit at timestamp 300.
hitCounter.getHits(300); // get hits at timestamp 300, return 4.
hitCounter.getHits(301); // get hits at timestamp 301, return 3.
 

Constraints:

1 <= timestamp <= 2 * 10^9
All the calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing).
At most 300 calls will be made to hit and getHits.
 * Click `Run` to execute the snippet below!
 */



/*
HitCounter.HitCounter hitCounter = new HitCounter.HitCounter();
hitCounter.hit(1);       // hit at timestamp 1. 
hitCounter.hit(3);       // hit at timestamp 3.

400 - 3 = 397
hitCounter.getHits(400); //
hitCounter.getHits(400); // get hits at timestamp 400, return 1.
*/


/*
 * To execute Java, please define "static void main" on a class
 * named HitCounter.Solution.
 *
 * If you need more classes, simply define them inline.
 */

import java.util.*;
class Solution {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        HitCounter hitcounter = new HitCounter();
        hitcounter.hit(1);
        System.out.println(hitcounter.getHits(2));
        hitcounter.hit(3);
        System.out.println(hitcounter.getHits(3));
        hitcounter.hit(103);
        System.out.println(hitcounter.getHits(103));

        hitcounter.hit(203);
        System.out.println(hitcounter.getHits(203));

        hitcounter.hit(400);
        System.out.println(hitcounter.getHits(400));


        hitcounter.hit(1500);
        hitcounter.hit(1501);
        System.out.println(hitcounter.getHits(1503));
    }
}

class HitCounter {
    private static int N = 300;
    private static int[] data;
    public static int lastTimestamp;
    public static int pointer;
    private static int sum;

    public HitCounter() {
        data = new int[N];
        lastTimestamp = 0;
        pointer = 0;
        sum = 0;
    }

    public static void hit(int timestamp) {
        System.out.println("Hitting at timestamp   : " + timestamp);
        rotate(timestamp);
        data[pointer]++;
        sum++;
        lastTimestamp = timestamp;
    }

    public static int getHits(int timestamp) { // 3
        System.out.println("Getting hits at stamp stamp   : " + timestamp);
        rotate(timestamp);
        lastTimestamp = timestamp;
        return sum;
    }

    // value  0   0   0   0        0      0
    // silos  0   1   2   3........99... 299
    // TIME1
    private static void rotate(int timestamp) {
        int gap = timestamp - lastTimestamp;
//        System.out.println(" LastTimestamp : " + lastTimestamp);
//        System.out.println(" gap is : " + gap);
          System.out.println(" LastPosition : " + pointer);

        for (int i = 0; i < gap; i++) {
            pointer = pointer + 1;
            pointer = pointer % N;
            sum -= data[pointer];
            data[pointer] = 0;
        }
    }
}

/* 
Your previous Plain Text content is preserved below:

Welcome to your interviewing.io interview.

Once you and your partner have joined, a voice call will start automatically.

Use the language dropdown near the top right to select the language you would like to use.

You can run code by hitting the 'Run' button near the top left.

Enjoy your interview!
*/

