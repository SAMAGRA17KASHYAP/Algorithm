import java.util.*;	
  enum NodeType{
  	INTERNAL,EXTERNAL
  }
  class Node{
  	public NodeType type;
  	public char content;
	public int frequency;
  	public String encoding;
  	public boolean canBeUsed;
  	public Node left;
  	public Node right;
  	public char code;
  	public String toString(){
  		return content+"";
  	}
  	public int hashCode(){
  		return -50;
  	}
  }
  public class Huffman{
  	StringBuffer sb=new StringBuffer();
  	public ArrayList<Node> nodes=new ArrayList<>();
  	public HashMap<Character,String> table=new HashMap<>();
  	Node root;
  	public void traversePath(){

  	}
  	public Node combine(Node min1,Node min2){
  		min1.canBeUsed=false;
  		min2.canBeUsed=false;
  		Node node=new Node();
  		node.canBeUsed=true;
  		node.frequency=min1.frequency+min2.frequency;
  		node.type=NodeType.INTERNAL;
  		node.left=min1;
  		node.right=min2;
  		nodes.add(node);
  		return node;
  	}
  	public Node[] getMinimum(){
  		Node min1=nodes.get(0);
  		int i=1;
  		while(i<nodes.size()){
  			if(min1.frequency>nodes.get(i).frequency){
  				min1=nodes.get(i);
  			}	
  			i++;
  		}
  		nodes.remove(min1);
  		Node min2=nodes.get(0);

  		i=1;
  		while(i<nodes.size()){
  			if(min2.frequency>nodes.get(i).frequency){
  				min2=nodes.get(i);
  			}	
  			i++;
  		}
  		nodes.remove(min2);
  		return new Node []{min1,min2};
  	}
  	public void assignCodes(Node node){
  		if(node!=null){
  			if(node.left!=null){
  				sb.append("0");
  				assignCodes(node.left);
  			}
  			if(node.right!=null){
				sb.append("1");
  				assignCodes(node.right);
  			}
  			if(node.left==null&&node.right==null){
  				table.put(node.content,sb.toString());
  			}
  			if(node !=root)
  			sb.setLength(sb.length()-1);
  		}	
  	}
  	public void orchestration(){
  		System.out.println("Orch start");
  		while(nodes.size()!=1){
  			Node[]mins=getMinimum();
  			System.out.println(mins[0].content);
  			System.out.println(mins[1].content);

  			combine(mins[0],mins[1]);
  		}
  		root=nodes.get(0);
  		assignCodes(root);
  		System.out.println("Orch End");
  	
  	}
  }
  class Test{
  	public static void main(String[] args) {
  		Huffman hf=new Huffman();
  		Node n1=new Node();
  		n1.content='a';
  		n1.frequency=10;
  		hf.nodes.add(n1);
  		n1=new Node();
  		n1.content='b';
  		n1.frequency=5;
  		hf.nodes.add(n1);
  		n1=new Node();
  		n1.content='c';
  		n1.frequency=8;
  		hf.nodes.add(n1);
  		n1=new Node();
  		
  		n1.content='d';
  		n1.frequency=2;
  		hf.nodes.add(n1);
  		n1=new Node();
  		
  		n1.content='e';
  		n1.frequency=14;
  		hf.nodes.add(n1);

  		n1.content='f';
  		n1.frequency=1;
  		hf.nodes.add(n1);
  		n1=new Node();
  		n1.content='g';
  		n1.frequency=5;
  		hf.nodes.add(n1);
  		n1=new Node();
  		n1.content='h';
  		n1.frequency=18;
  		hf.nodes.add(n1);
  		n1=new Node();
  		
  		n1.content='i';
  		n1.frequency=2;
  		hf.nodes.add(n1);
  		n1=new Node();
  		
  		n1.content='j';
  		n1.frequency=3;
  		hf.nodes.add(n1);


  		hf.orchestration();
  		System.out.println(" After calling Orch ");

  		Map<Character, String> map = hf.table;
for (Map.Entry<Character, String> entry : map.entrySet()) {
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}
  	}
  }