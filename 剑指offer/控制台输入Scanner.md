2019年12月18日

# 算法机试时，控制台各种输入

### 1. 控制台输入 int[] a = {2, 3, 1, 0, 2, 5, 3};

​	**可以按照这个模式:**

```java
 		控制台输入1,2,3，


		Scanner scanner = new Scanner(System.in);
        //1. 首先 输入 string字符， 单个字符来读取，并用逗号分割开来， scanner默认是 回车为 结束标志
        String string = scanner.next().toString();
        //2. 将 读取的string 使用split安装 逗号 分割为 string[]
        String[] arr = string.split(",");
        //3. 新定义一个 int[]，长度限制为 arr.length
        int[] d = new int[arr.length];
        //4. 将arr数组遍历转换为int，并一个一个赋值给int[]
        for (int i = 0; i< d.length; i++){
            d[i] = Integer.parseInt(arr[i]);
        }
        //5. 打印出来，按照string方式 打印出来
        System.out.println(Arrays.toString(d));
```

### 2. 二维数组的控制台输入

```java
Scanner scanner = new Scanner(System.in);
		System.out.println("输入你需要的阶层");
		int n = scanner.nextInt();
		int[][] arr = new int[n][n];
		System.out.println("输入各数组元素");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j] = scanner.nextInt();//控制台输入给数组赋值
			}
		}
		
		System.out.println("输出数组：");
		for(int i=0; i<n;i++){
			for(int j=0; j<n;j++){
				System.out.print(arr[i][j]+"\t");
				if (j == n-1) {
					System.out.println();
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(arr);
		scanner.close();
```

### 3. 链表的测试用例编写 --- 8.6号

```java
package muke;
///  创建链表  和 打印链表
public class ListNode {
	public int val;
	public ListNode next = null;

	public ListNode(int x) {
		val = x;
	}

    // 根据n个元素的数组arr创建一个链表
    // 使用arr为参数，创建另外一个ListNode的构造函数
	public ListNode(int[] arr) {
		if (arr == null || arr.length <= 0) {
			throw new IllegalArgumentException("arr can not be empty");
		}
		this.val = arr[0];
		ListNode curNode = this;// 第一个节点
		for (int i = 1; i < arr.length; i++) {
			curNode.next = new ListNode(arr[i]);
			curNode = curNode.next;
		}
	}
    // 返回以当前ListNode为头结点的链表信息字符串
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		ListNode curNode = this;
		while (curNode != null) {
			s.append(Integer.toString(curNode.val));
			s.append(" -> ");
			curNode = curNode.next;
		}
		s.append("NULL");

		return s.toString();

	}
}
```

```java
package muke;

public class Main5_1_链表反转 {
	// 链表的反转
	public ListNode reverseList(ListNode head) {

		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}
/// 反转链表的 测试
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = new ListNode(nums);/// 传入一个 数组即可创建爱你链表
		System.out.println(head);///创建好的打印

		ListNode head2 = (new Main5_1_链表反转()).reverseList(head);
		System.out.println(head2);///调用后的打印情况	
	}
}
```

**下面这种情况已经out了**

```java
//因为listNode每次创建一个节点都要 调用有参构造方法即 new	
//链表的测试用例
		ListNode head = new ListNode(1);//创建头结点
		head.next = new ListNode(2);//再定义头结点的next域
		ListNode tListNode = head.next;
		for(int i=3; i<10;i++){ //创建一个简单的链表{1,2,3,4,5,...,9}
			tListNode.next = new ListNode(i);
			tListNode = tListNode.next;
		}
		
		System.out.println(head);
```

```java
//为了便于查看结果，写的打印链表的方法
		public void printListNode(ListNode head) {
			while(head!=null) {
				System.out.print(head.val+" ");
				head = head.next;
			}
		}
```

### 4. 二叉树编写测试用例 --- 8.7

```java
package muke;
/// 437. Path Sum III
/// https://leetcode.com/problems/path-sum-iii/description/
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Main_7_5_从二叉树中找到路径和为sum的路径个数 {

	 // 在以root为根节点的二叉树中,寻找和为sum的路径,返回这样的路径个数
//	此函数的定义： 在以root为根节点的二叉树中，寻找和为sum的路径
//	返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
    	if (root == null) {
			return 0;
		}
    	
//    	分为两种情况：当前root是此路径的一部分， 不是此路径的一部分
//    	不是一部分：
    	int res = findPath(root,sum);
    	
    	res += pathSum(root.left, sum);
    	res += pathSum(root.right, sum);
    	
    	return res;
    	
    }
//	此函数的定义：
//    以node为根节点二叉树，寻找包含node节点的路径，和为sum
//    返回这样的路径个数
    private int findPath(TreeNode node, int sum){
    	if (node == null) {
			return 0;
		}
    	int res = 0;
    	if (node.val == sum) {
			res += 1;
		}
    	
    	res += findPath(node.left, sum - node.val);
    	res += findPath(node.right, sum - node.val);
    	
    	return res;
    }
    
    public static void main(String[] args) {

        // 手动创建Leetcode题页上的测试用例。
        // 当然, 有更好的更智能的创建二叉树的方式, 有兴趣的同学可以自行研究编写程序:)

        /*****************
         * 测试用例:
         *
         *       10
         *      /  \
         *     5   -3
         *    / \    \
         *   3   2   11
         *  / \   \
         * 3  -2   1
         *****************/
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-2);

        TreeNode node3 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node5.right = node4;

        TreeNode node6 = new TreeNode(5);
        node6.left = node3;
        node6.right = node5;

        TreeNode node7 = new TreeNode(11);
        TreeNode node8 = new TreeNode(-3);
        node8.right = node7;

        TreeNode node9 = new TreeNode(10);
        node9.left = node6;
        node9.right = node8;

        System.out.println((new Main_7_5_从二叉树中找到路径和为sum的路径个数()).pathSum(node9, 8));
    }
}

```



```java
	///二叉树 编写测试用例
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
		tSequence_32.branchPrintTree(root);
```

```java
 /* 案例：
 *  1
   / \
  2   3
     / \
    4   5
    
    输出： 序列化为 "[1,2,3,null,null,4,5]"
*/
	  public static void main(String[] args){
		  TreeSerializeAndDeserialize_37 serialize_37 = new TreeSerializeAndDeserialize_37();
		  //构建案例中的 二叉树，和链表类似，都是用指针来维护一个结构
		  TreeNode rNode = new TreeNode(1);//创建第一个节点
		  rNode.left = new TreeNode(2);
		  rNode.right = new TreeNode(3);
		  TreeNode temp = rNode.right;
		  temp.left = new TreeNode(4);
		  temp.right = new TreeNode(5);
		  
		  System.out.println("=======");
		  System.out.println(serialize_37.Serialize(rNode));
		  
		  ///测试
		  TreeNode newRoot = serialize_37.deserialize(serialize_37.Serialize(rNode));
		  assert newRoot != null;

		  //写一个 前序递归
		  serialize_37.dfs(newRoot);
		 
	  }	
```













