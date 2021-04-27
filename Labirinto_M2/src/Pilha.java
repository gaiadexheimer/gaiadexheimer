
public class Pilha {

		int elementos[];
		int topo;
		
		public Pilha() {
			elementos = new int[10000];
			topo = -1;
		}
		
		public void push (int e) {
			topo++;
			elementos[topo] = e;
		}
		
		public int pop() {
			int e;
			e = elementos[topo];
			topo--;
			return e;
		}
		
		public boolean isEmpty() {
			return (topo == -1);
		}
		
		public boolean isFull() {
			return (topo == 9999);
		}
		
		public int top() {
			return elementos[topo];
		}
		
		
}
