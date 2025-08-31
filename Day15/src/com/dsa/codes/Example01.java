package com.dsa.codes;

class Heap{
    private int[] heap;
    private int size;

    public Heap(int[] arr){
        this.heap = arr;
        this.size = arr.length - 1;
    }

    public void display(){
        for(int i = 1; i < heap.length; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void makeMaxHeap(){

        for (int i = size/2; i >= 1; i--) {

            int parent = heap[i];
            int ci = i * 2; //left child
            while (ci <= size) {
                if ((ci+1) <= size && heap[ci + 1] > heap[ci]) {
                    ci = ci + 1;
                }

                if (parent > heap[ci]) {
                    break;
                }

                heap[ci / 2] = heap[ci];
                ci = ci * 2; //new child if it exists
            }
            heap[ci / 2] = parent;
        }

    }

    public void makeMinHeap(){
        for(int i = size/2; i>=1; i--){

            int parent = heap[i];
            int ci = i*2;

            while(ci <= size){
                if((ci+1) <= size && heap[ci+1] < heap[ci]){
                    ci = ci + 1;
                }

                if(parent < heap[ci]){
                    break;
                }

                heap[ci/2] = heap[ci];
                ci = ci*2;
            }
            heap[ci/2] = parent;
        }
    }

    public int deleteMaxElement(){

        int max = heap[1];
        int temp = heap[size];
        size--;
        int ci = 1 * 2;
        while(ci <= size){

            if((ci+1) <= size && heap[ci+1] > heap[ci]){
                ci = ci + 1;
            }

            if(temp > heap[ci]){
                break;
            }
            heap[ci / 2] = heap[ci];
            ci = ci * 2;
        }
        heap[ci / 2] = temp;
        return max;
    }

    public void heapSort() {
        makeMaxHeap();
        for(int i = heap.length - 1; i >= 1; i--){
           int max = deleteMaxElement();
           heap[i] = max;
        }
    }
}

public class Example01 {

    public static void main(String[] args) {
        int[] arr = {0, 17, 80, 35, 15, 10, 30, 20, 12, 1, 2};
        Heap h = new Heap(arr);
        h.makeMaxHeap();
        h.display();
        h.makeMinHeap();
        h.display();
        //                              | this element is not considered for anything,
        //                              | its not part of the heap. heap starts at index 1
        Heap array = new Heap(new int[]{0,1,4,3,9,7,5,6,8,2});
        array.heapSort();
        array.display();
    }

}
