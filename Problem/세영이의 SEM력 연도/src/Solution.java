import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[3];
			arr[0] = arr[1] = arr[2] = 0;
			int cnt = 1;
			while(arr[0] >= arr[1])
			{
				while(arr[1] >= arr[2])
				{
					
				}
			}
			bw.write("#"+tNum+" "+cnt+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
