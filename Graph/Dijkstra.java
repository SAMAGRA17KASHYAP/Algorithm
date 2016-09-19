import java.util.*;
abstract class Graph{
	int numEdges;
	int numVertex;
	public Graph(int numVertex,int numEdges){
		this.numVertex=numVertex;
		this.numEdges=numEdges;
	}
	public void setNumVertex(int numVertex){
		this.numVertex=numVertex;
	}
	public void setNumEdges(int numEdges){
		this.numEdges=numEdges;
	}
	public int getNumVertex(){
		return numVertex;
	}
	public int getNumEdges(){
		return numEdges;
	}
	public void addVertex(){
	}
	
	abstract public void addEdge(String from ,String to);
	abstract public List<String> getAdjacencyList(String node);
}
class DirectedGraphList extends Graph{
	HashMap <String,LinkedList<String>> graph=new HashMap<>();
	public DirectedGraphList(int numVertex,int numEdges){
		super(numVertex,numEdges);
	}
	public void addVertex(String vertexName){
		graph.put(vertexName,new LinkedList<String>());
	}
	public void addEdge(String from ,String to){
		if(graph.get(from)==null){
		
			addVertex(from);
		}
		if(graph.get(to)==null){
		
			addVertex(to);
		}
		(graph.get(from)).add(to);
	}
	public List<String> getAdjacencyList(String node){
		return graph.get(node);
	}			
	public String toString(){
		StringBuilder sb=new StringBuilder();
        graph.entrySet().stream().forEach((entry) -> {
            String key = entry.getKey();
            LinkedList<String> value = entry.getValue();
            sb.append(key).append("->").append(value.toString()).append("\n");
        });
        return sb.toString();
	}
	public String dfs(String from, String to ){
		Stack<String> stk=new Stack<>();
		if(from==to){
			return "Src is same as dest";
		}
		HashSet<String> visited=new HashSet<>();
		HashMap<String,String>path=new HashMap<>();
		visited.add(from);
		stk.add(from);
		while(!stk.isEmpty()){
			String curNode=stk.pop();
			
			if(curNode.equals(to)){
				return processPath(path,from,to);
			}
			List<String>neighbours=getAdjacencyList(curNode);
			for(String neighbor:neighbours){
				if(!visited.contains(neighbor)){
					path.put(neighbor,curNode);
					stk.push(neighbor);
					visited.add(neighbor);
				}
			}
		}
		return "No Path Found";
	}	
	public String bfs(String from, String to ){
		Queue<String> q=new ArrayDeque<>();
		if(from==to){
			return "Src is same as dest";
		}
		q.add(from);
		HashSet<String> visited=new HashSet<>();
		HashMap<String,String>path=new HashMap<>();
		visited.add(from);
		while(!q.isEmpty()){
			String curNode=q.poll();
			System.out.println("Queue"+q);
			if(curNode.equals(to)){
				return processPath(path,from,to);
			}
			List<String>neighbours=getAdjacencyList(curNode);
			System.out.println(curNode);
			System.out.println(neighbours);
			for(String neighbor:neighbours){
				if(!visited.contains(neighbor)){
					q.add(neighbor);
					path.put(neighbor,curNode);
					visited.add(neighbor);
				}
			}
		}
		return "No Path Found";
	}	

	public String processPath(HashMap<String,String> path,String from,String to){
		ArrayList<String> walk=new ArrayList<>();
		String key="";
		walk.add(to);
		do{
		 key=path.get(to);
		walk.add(key);
		to=key;
		}while(key!=from);
		Collections.reverse(walk);
		return walk.toString();
	}
}
class Test{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int numVertices=sc.nextInt();
        int numEdges=sc.nextInt();
        
        DirectedGraphList graph=new DirectedGraphList(numVertices, numEdges);
        for (int i = 0; i < numEdges; i++) {
            graph.addEdge(sc.next(), sc.next());
        }
        System.out.println("Graph entered by you is:");
        System.out.println(graph.toString());
        String from =sc.next();
        String to =sc.next();
        System.out.println(graph.bfs(from,to));
        System.out.println(graph.dfs(from,to));


	}
}
