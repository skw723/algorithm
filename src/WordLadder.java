import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Answer answer = new Answer();
        answer.init();
        answer.exec();
    }

    static class Answer {
        private String start = "hit";
        private String end = "cog";
        // start + end + dic
//        private List<String> dic = Arrays.asList("hot", "dot", "dog", "lot", "log", "hit", "cog");
        private List<String> dic = Arrays.asList("hot", "dot", "dog", "lot", "log", "hit", "cog", "hog", "cot");
        private Queue<Node> queue = new LinkedList<>();
        private HashMap<String, List<String>> adjacent = new HashMap<>();
        private HashSet<String> visit = new LinkedHashSet<>();

        public void init() {
            for (String target : dic) {
                List<String> nextDic = new ArrayList<>();
                for (String str : dic) {
                    if (oneDiff(target, str)) {
                        nextDic.add(str);
                    }
                }
                adjacent.put(target, nextDic);
            }
        }

            private boolean oneDiff(String target, String str) {
                if (target.length() != str.length()) {
                    return false;
                }

                int diff = 0;
                for (int i = 0; i < target.length(); i++) {
                    if (target.charAt(i) != str.charAt(i)) {
                        diff++;
                    }
            }

            if (diff == 1) {
                return true;
            } else {
                return false;
            }
        }

        public void exec() {
            // 첫 해를 찾은 경우 동일 level에 다른 해가 있을 수 있으므로 maxLevel까지는 탐색을 계속 진행
            int maxLevel = -1;
            queue.add(new Node(start, null, 1));
            visit.add(start);

            while (queue.isEmpty() == false) {
                Node current = queue.remove();

                // 해를 찾은 경우 같은 레벨까지만 탐색
                if (maxLevel > 0 && current.getLevel() > maxLevel) {
                    break;
                }

                // 완료 조건
                if (current.getWord().equals(end)) {
                    StringBuilder str = new StringBuilder();

                    Node node = current;
                    str.append(node.getWord());
                    str.append(",");
                    while (node.getParent() != null) {
                        node = node.getParent();
                        str.append(node.getWord());
                        str.append(",");
                    }
                    System.out.println(str);

                    // maxLevel 설정
                    if (maxLevel < 0) {
                        maxLevel = current.getLevel();
                    }
                    continue;
                }

                // 이동할 수 있는 다음 경로를 모두 add
                List<String> next = adjacent.get(current.getWord());
                for (String str : next) {
                    if (visit.contains(str) == false) {
                        // 형제 노드 및 이전 레벨에 방문한 노드로는 이동하지 않아도 됨
                        // 형제 노드에 end가 있는 경우에는 부모 노드에서 이동으로 해가 됨...
                        // 부모 노드에서 이동할 수 없는 경우 end는 형제 노드가 될 수 없음
                        queue.add(new Node(str, current, current.getLevel() + 1));
                        visit.add(str);
                    }
                }
                // 해가 여러개인 경우 end를 visit 해버리면 다음 결과값을 찾을 수 없음.
                visit.remove(end);
            }
        }
    }

    static class Node {
        private String word;
        private Node parent;
        private int level;

        public Node(String word, Node parent, int level) {
            this.word = word;
            this.parent = parent;
            this.level = level;
        }

        public String getWord() {
            return word;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {

            this.level = level;
        }

        public Node getParent() {
            return parent;
        }
    }
}
