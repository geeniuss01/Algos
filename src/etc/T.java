package etc;
// vertices [V]
// edges [[s d w][s d w]]

import java.util.*;

class T {
	public static void shortestPath(int s, int d, int V, int[][] edges){
		int [] dist = new int[V];
		for(int i =0; i<V; i++) {
			dist[i] = i==s?0:Integer.MAX_VALUE;
		}
		for(int[] e: edges){
			int u = e[0], v=e[1],w=e[2];
			if(dist[v] > dist[u] + w){
				dist[v] = dist[u] + w;
			} 
		}
	}

	public static int shortestPathD(int [][] G, int s, int d){
		int V = G.length;
		boolean [] vis = new boolean[V];
		int [] dist = new int[V];
		for(int i = 0; i < V; i++) {
			vis[i]=false;
			dist[i] = s==i?0:Integer.MAX_VALUE;
		}
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
		q.add(new int[]{0,s});

		while(!q.isEmpty()){
			int[] a = q.remove();
			int u = a[0], ud = a[1];
			if(vis[u]) continue;
			vis[u]=true;
			if(u==d) break;
			for(int v =0; v < V; v++){
				int e = G[u][v];
				if(vis[v] || e == 0) continue;
				int vd = dist[v];
				if(ud+e<vd) dist[v]=ud+e;
				q.add(new int[]{dist[v], v});
			}
		}
		return dist[d];
	}

	public static int nthFib(int n){
		if(n<1) return -1;
		if(n<3) return 1;
		int[] ar = new int[n];
		ar[0]=ar[1]=1;
		for(int i=2;i<n;i++) ar[i] = ar[i-1]+ar[i-2];
		return  ar[n-1];
	}

	public static int binSearch(int[] ar, int e){
		int low =0, high = ar.length -1;
		while (high - low > 1) {
			int mid = (low+high)/2;
			if(ar[mid]==e) return mid;
			else if(ar[mid]<e) low = mid;
			else high = mid;
		}

		if(ar[high]==e) return high;
		else if(ar[low]==e) return low;
		else return -1;
	}

	public static void main(String[] args) {
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(wv -> wv[0]));
		priorityQueue.add(new int[]{2, 1});
		priorityQueue.add(new int[]{1, 2});
		priorityQueue.add(new int[]{3, 1});
		int[] remove = priorityQueue.remove();

//		System.out.println(""+priorityQueue);
//		System.out.println(nthFib(8));
		System.out.println(binSearch(new int[]{1,4,7,9,10,14,20,25,100}, 1));
		System.out.println(binSearch(new int[]{1,4,7,9,10,14,20,25,100}, 100));
		System.out.println(binSearch(new int[]{1,4,7,9,10,14,20,25,100}, 8));
		System.out.println(binSearch(new int[]{1,4,7,9,10,14,20,25,100}, 15));
		System.out.println(binSearch(new int[]{1,4,7,9,10,14,20,25,100}, -15));
		System.out.println(binSearch(new int[]{1,4,7,9,10,14,20,25,100}, 150));
	}
}