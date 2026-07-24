class TimeMap {

    class Node {
        int timeStamp;
        String val;
        Node next;

        Node() { }

        Node( String val, int timeStamp, Node next) {
            this.val = val;
            this.timeStamp = timeStamp;
            this.next = next;
        }

        Node( String val, int timeStamp) {
            this.val = val;
            this.timeStamp = timeStamp;
            this.next = null;
        }
    }

    private Map<String,Node> dict;
    public TimeMap() {
        this.dict = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.dict.containsKey(key)) {
            Node newKey = new Node(value, timestamp);
            dict.put(key, newKey);
        } else {
            Node recent = dict.get(key);
            recent = this.addValue(recent, value, timestamp);
            dict.put(key, recent);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!this.dict.containsKey(key))
            return "";
        
        Node curr = dict.get(key);
        while (curr != null) {
            if (curr.timeStamp <= timestamp)
                return curr.val;

            curr = curr.next;
        }

        return "";
    }

    private Node addValue(Node start, String value, int timestamp) {
        Node prev = null;
        Node curr = start;
        Node newStart = start;

        while(curr != null) {
            if (curr.timeStamp <= timestamp ) {
                Node newValue = new Node(value, timestamp, curr);
                if (prev == null)
                    newStart = newValue;
                else 
                    prev.next =  newValue;
    
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        return newStart;
    }
}
