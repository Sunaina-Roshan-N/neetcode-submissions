class StockSpanner {

    Stack<int[]> stockSpan;
    public StockSpanner() {
        stockSpan = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stockSpan.isEmpty() && price >= stockSpan.peek()[0])
            span += stockSpan.pop()[1];

        int[] priceSpan = new int[2];
        priceSpan[0] = price;
        priceSpan[1] = span;
        stockSpan.push(priceSpan);

        return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */