import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int V,E,start,target;
	public static ArrayList<Pos>[] arr;
	public static int[] p;
	public static int[] dis;
	public static PriorityQueue<Pos> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		arr = new ArrayList[V+1];
		p = new int[V+1];
		dis = new int[V+1];
		
		for(int i = 0 ; i <= V ; i++)
			arr[i] = new ArrayList<>();

		for(int i = 0 ; i < E ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[a].add(new Pos(b,w));
		}//for input
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		//logic
		infinite();
		dijkstra(start,target);

		bw.write(String.valueOf(dis[target]));
		bw.flush();
		bw.close();

	}
	public static void infinite()
	{
		for(int i = 1 ; i <= V ; i++)
			dis[i] = Integer.MAX_VALUE;
	}
	public static void dijkstra(int start, int target)
	{
		// starting point
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(start,0));
		dis[start] = 0;
		
		while(!pq.isEmpty())
		{
			Pos cur = pq.poll();
			if(cur.index == target) break;
			for(Pos next : arr[cur.index])
			{
				if(dis[next.index] > dis[cur.index] + next.w)
				{
					dis[next.index] = dis[cur.index] + next.w;
					pq.offer(new Pos(next.index , dis[next.index]));
				}
			}
		}
		
	}
}
class Pos implements Comparable<Pos>
{
	public int index,w;
	Pos( int b, int w)
	{
		this.index =b;
		this.w =w;
	}
	@Override
	public int compareTo(Pos o) {
		return this.w - o.w;
	}
}