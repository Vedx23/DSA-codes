package com.dsa.codes;

//HashMap

class Element{
    public int key;
    public String data;

    public Element(int key, String data){
        this.key = key;
        this.data = data;
    }

    public int getKey(){
        return this.key;
    }

    public String getData(){
        return this.data;
    }
}

class HashMap{
    //default size 10
    private static final int SIZE = 10;
    private Element[] hashmap;

    public HashMap(){
        this.hashmap = new Element[SIZE];
        System.out.println("Initialized default hashmap with capacity 10");
    }

    private int getHash(int key){
        return key % SIZE;
    }

    private int getReHash(int key, int counter){
        return (key+counter) % SIZE;
    }

    public void put(int key, String Name){

        int counter = 1;
        while (true){
            int index = getHash(key);
            if (hashmap[index] == null){
                hashmap[index] = new Element(key,Name);
                return;
            }
            if (hashmap[index].key == key){
                hashmap[index].data = Name;
                return;//data updated if key already present
            }
            index = getReHash(key, counter++);
        }


    }

    public void get(int key){

        int counter = 1;

        while(true){
            int index = getHash(key);
            if(hashmap[index] == null){

                return; //element not found
            }

            if (hashmap[index].key == key){
                //name found
                System.out.println("Data found : " + hashmap[index].data);
                return;
            }
            index = getReHash(key, counter++);
        }

    }

}

public class Example01 {

    public static void main(String[] args) {
        HashMap hm1 = new HashMap();
        hm1.put(1, "Vedant");
        hm1.put(2,"Cafe");
        hm1.put(3, "Cheese");
        hm1.get(2);
        hm1.put(2, "Money");
        hm1.get(2);
    }

}
