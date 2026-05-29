class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for(int i =0; i < s.length(); i++ ){
            String br = String.valueOf(s.charAt(i));

            if (br.equals("(") || br.equals("[") || br.equals("{")){
                stack.push(br);
                continue;
            }

            switch (br) {
                case ")":
                    if (stack.empty() || stack.pop().equals("(") == false)
                        return false;
                    break;

                case "}":
                    if (stack.empty() || stack.pop().equals("{") == false)
                        return false;
                    break;
                
                case "]":
                    if (stack.empty() || stack.pop().equals("[") == false)
                        return false;
                    break;
            }

           
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }
}
