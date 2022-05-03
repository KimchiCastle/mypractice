
package data_structure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class backjoon_18258_Builder {
	
	static class Queue1<T>{
		//������ Ȯ�� ����
		private int count = 0;
		class Node<T>{
			
			private T data;
			private Node<T> next;
			
			
			public Node(T data) {
				// TODO Auto-generated constructor stub
				this.data = data;
			}
		}
		
		//ó���� ���� Ȯ���ϱ� ���� ������� ����
		
		private Node<T> first;
		private Node<T> last;
		
		public void push(T item) {
			
			count++;
			
			Node<T> t = new Node<T>(item);
			
			//�ϳ��� �����Ͱ� ��������
			if(last != null) {
				//������������ ������ ����
				last.next = t;
			}
			//���� ������� ��ü�� ��Ʈ
			last = t;
			
			//�����Ͱ� ���������
			if(first == null) {
				first = last;
			}
			
		}
		
		public void pop() {
			
			if(first==null) {
				sb.append(-1).append('\n');
				return;
			}
			//�����͸� ����
			if(count<0) {
				count = 0;
			}else count--;
			
			
			//������ ����
			T data = first.data;
			first = first.next;
			
			if(first == null){
				last = null;
			}
			//first data �� ����
			sb.append(data).append('\n');
		}
		
		public void size() {
			sb.append(count).append('\n');
		}

		
		public void empty() {
			sb.append(first == null ? 1 : 0).append('\n');
		}

		public void front() {
			if (first == null) {
				//ó���� ��������� �ͼ���
				sb.append(-1).append('\n');
				return;
			}
			// ó���� ����Ű�� �ִ� �����͸� ��ȯ
			sb.append(first.data).append('\n');
		}
		
		public void back() {
			if (last == null) {
				//ó���� ��������� �ͼ���
				sb.append(-1).append('\n');
				return;
			}
			// ó���� ����Ű�� �ִ� �����͸� ��ȯ
			sb.append(last.data).append('\n');
		}

	}// Queue end	
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Queue1<Integer> q = new Queue1<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/*
			if(st.nextToken().equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				q.push(n);	
			}else if(st.nextToken().equals("front")) {
				q.front();
			}else if(st.nextToken().equals("back")) {
				q.back();
			}else if(st.nextToken().equals("size")) {
				q.size();
			}else if(st.nextToken().equals("empty")) {
				q.empty();
			}else if(st.nextToken().equals("pop")) {
				q.pop();
			}
			*/
			
			switch (st.nextToken()) {
			case "push":
				int n = Integer.parseInt(st.nextToken());
				q.push(n);
				break;
			case "front" :
				q.front();
				break;
			case "back" :
				q.back();
				break;
			case "size" :
				q.size();
				break;
			case "empty" :
				q.empty();
				break;		
			default:
				q.pop();
				break;
			} // switch end
			
			
		} // for end
		
		System.out.println(sb);
	}
}