class MedianFinder {
    PriorityQueue<Integer> min; // max-heap → lower half
    PriorityQueue<Integer> max; // min-heap → upper half

    public MedianFinder() {
        min = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        max = new PriorityQueue<>();                           // min-heap
    }

    public void addNum(int num) {
        min.add(num);

        if (!max.isEmpty() && min.peek() > max.peek()) { // ✅ > not <, and min→max
            max.add(min.remove());
        }

        if (min.size() > max.size() + 1) {
            max.add(min.remove());                        // rebalance: min too big
        } else if (max.size() > min.size()) {            // ✅ uncomment & fix this
            min.add(max.remove());                        // rebalance: max too big
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        }
        return (double) min.peek(); // min always holds the extra element
    }
}