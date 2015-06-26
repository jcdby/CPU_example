/**
 * SynchronizedQueue.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-8
 */

package execute;

import java.util.*;

public class SynchronizedQueue {
	
	private Queue<Integer> queue = new LinkedList<Integer>();
	
	private UI ui;
	
	/**
	 * Return the ui.
	 */
	
	public UI getUi() {
	
		return ui;
	
	}

	/**
	 * Reset the ui.
	 */
	
	public void setUi(UI ui) {
	
		this.ui = ui;
	
	}
	
	public static void main(String[] args) {

		SynchronizedQueue gequeue = new SynchronizedQueue();
		
		gequeue.inqueue(1);
		gequeue.inqueue(3);
		gequeue.inqueue(2);
		
		System.out.println(gequeue.toString());
		gequeue.inqueue(4);
		System.out.println(gequeue);
		System.out.println(gequeue.dequeue());
		gequeue.update(2);
		System.out.println(gequeue);
		
		
	}
	
	public synchronized void inqueue(int i) {

		queue.offer(new Integer(i));
		ui.updateQueue();
		
	}
	
	public synchronized int peek() {
		
		return queue.peek().intValue();
		
	}
	
	/**
	 * Empty check left to the caller.
	 */
	
	public synchronized int dequeue() {

		int i = queue.poll().intValue();
		ui.updateQueue();
		return i;
		
	}
	
	public synchronized boolean isEmpty() {
		
		return queue.size() == 0;
		
	}
	
	public synchronized void update(int i) {

		Iterator<Integer> itr = queue.iterator();
		LinkedList<Integer> newQueue = new LinkedList<Integer>();
		int k;
		
		while(itr.hasNext()) {
			k = itr.next().intValue();
			if(k > i)
				k--;
			newQueue.offer(new Integer(k));
		}
		
		queue = newQueue;
		
		ui.updateQueue();
		
	}
	
	public synchronized String toString() {
		
		StringBuffer sb = new StringBuffer();
		Iterator<Integer> itr = queue.iterator();
		while(itr.hasNext())
			sb.append(" " + itr.next().intValue());
		return sb.toString();
		
	}

}
