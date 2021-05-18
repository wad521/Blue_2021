package LeetCode_4月;

/**
 * @author:yxl
 **/
public class 字典树 {

    // 构造Trie树节点
    class TrieNode {

        // 标识该节点是否是字符串的结束节点
        boolean isEnd = false;
        // 当前节点的孩子节点
        TrieNode[] next = new TrieNode[26];

        // 设置当前节点为一个字符串的结束节点
        public void setIsEnd (boolean isEnd) {
            this.isEnd = isEnd;
        }

    }

    // root为根节点
    TrieNode root;

    /** Initialize your data structure here. */
    public 字典树()  {
        root = new TrieNode();
    }

    /** 插入. */
    public void insert(String word) {

        char[] chs = word.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {

            int u = chs[i] - 'a';
            // 判断node的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (node.next[u] == null)
                node.next[u] = new TrieNode();
            // 继续向下构建
            node = node.next[u];

        }

        // 当前TrieNode节点是一个字符串的结尾
        node.setIsEnd(true);

    }

    /** 查询. */
    public boolean search(String word) {

        char[] chs = word.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {

            int u = chs[i] - 'a';
            // 判断node的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (node.next[u] == null)
                return false;
            // 继续向下构建
            node = node.next[u];

        }

        // 当前TrieNode节点是否一个字符串的结尾
        return node.isEnd;

    }

    /** 查询前缀存在与否 */
    public boolean startsWith(String prefix) {

        char[] chs = prefix.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {

            int u = chs[i] - 'a';
            // 判断node的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (node.next[u] == null)
                return false;
            // 继续向下构建
            node = node.next[u];

        }

        // 前缀查找成功
        return true;

    }
}
