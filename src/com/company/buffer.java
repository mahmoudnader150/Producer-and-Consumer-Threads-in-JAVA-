package com.company;

class buffer {
    private int size;
    private Object store[];
    private int inptr = 0;
    private int outptr = 0;
    semaphore spaces ;
    semaphore elements ;// the buffer bound
    buffer(int size){
        this.size = size;
        spaces = new semaphore(this.size);
        elements = new semaphore(0);
        store  = new Object[this.size];
    }

    public void produce(Object value) {
        spaces.P();
        store[inptr] = value;
        inptr = (inptr + 1) % this.size;
        elements.V();
    }
    public Object consume() {
        Object value;
        elements.P();
        value = store[outptr];
        outptr = (outptr + 1) % this.size;
        spaces.V();
        return value;
    }
}